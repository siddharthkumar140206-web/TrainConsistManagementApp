package Test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;
import java.util.stream.*;

public class UseCase9TrainConsistMgmtTest {

    // Inner Bogie class mirroring the main class
    static class Bogie {
        String name;
        int capacity;

        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }

        String getName() {
            return name;
        }

        int getCapacity() {
            return capacity;
        }
    }

    // Helper method to group bogies by name
    private Map<String, List<Bogie>> groupBogies(List<Bogie> bogies) {
        return bogies.stream()
                .collect(Collectors.groupingBy(Bogie::getName));
    }

    private List<Bogie> bogies;

    @BeforeEach
    void setUp() {
        bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper",     72));
        bogies.add(new Bogie("AC Chair",    56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("Sleeper",     70));
        bogies.add(new Bogie("AC Chair",    60));
    }

    /**
     * testGrouping_BogiesGroupedByType()
     * Verifies that bogies are correctly grouped based on their type
     * using Collectors.groupingBy().
     * Tests: Bogies with the same name appear under the same Map key.
     */
    @Test
    void testGrouping_BogiesGroupedByType() {
        Map<String, List<Bogie>> grouped = groupBogies(bogies);

        // Sleeper bogies should be under "Sleeper" key
        assertTrue(grouped.containsKey("Sleeper"),
                "Map should contain key 'Sleeper'");

        // All bogies in "Sleeper" group should have name "Sleeper"
        for (Bogie b : grouped.get("Sleeper")) {
            assertEquals("Sleeper", b.getName(),
                    "Each bogie in Sleeper group should have name Sleeper");
        }
    }

    /**
     * testGrouping_MultipleBogiesInSameGroup()
     * Verifies that when multiple bogies share the same name,
     * they are grouped together within the same list.
     * Tests: Two or more bogies with the same type are stored in the same group.
     */
    @Test
    void testGrouping_MultipleBogiesInSameGroup() {
        Map<String, List<Bogie>> grouped = groupBogies(bogies);

        // There are 2 Sleeper bogies and 2 AC Chair bogies
        assertEquals(2, grouped.get("Sleeper").size(),
                "Sleeper group should contain 2 bogies");

        assertEquals(2, grouped.get("AC Chair").size(),
                "AC Chair group should contain 2 bogies");
    }

    /**
     * testGrouping_DifferentBogieTypes()
     * Verifies that bogies with different types are separated into different groups.
     * Tests: Each bogie type appears as a distinct key in the resulting Map.
     */
    @Test
    void testGrouping_DifferentBogieTypes() {
        Map<String, List<Bogie>> grouped = groupBogies(bogies);

        // All three types should be separate keys
        assertTrue(grouped.containsKey("Sleeper"),
                "Map should contain key 'Sleeper'");
        assertTrue(grouped.containsKey("AC Chair"),
                "Map should contain key 'AC Chair'");
        assertTrue(grouped.containsKey("First Class"),
                "Map should contain key 'First Class'");

        // Total distinct keys should be 3
        assertEquals(3, grouped.size(),
                "Map should have exactly 3 distinct bogie type keys");
    }

    /**
     * testGrouping_EmptyBogieList()
     * Verifies that grouping an empty bogie list does not produce errors.
     * Tests: The resulting Map is empty.
     */
    @Test
    void testGrouping_EmptyBogieList() {
        List<Bogie> emptyList = new ArrayList<>();
        Map<String, List<Bogie>> grouped = groupBogies(emptyList);

        assertNotNull(grouped, "Grouped map should not be null");
        assertTrue(grouped.isEmpty(),
                "Grouped map should be empty for empty bogie list");
    }

    /**
     * testGrouping_SingleBogieCategory()
     * Verifies behavior when only one bogie type exists in the list.
     * Tests: The Map contains only one key with a list of bogies
     *        belonging to that category.
     */
    @Test
    void testGrouping_SingleBogieCategory() {
        List<Bogie> singleCategory = new ArrayList<>();
        singleCategory.add(new Bogie("Sleeper", 72));
        singleCategory.add(new Bogie("Sleeper", 70));
        singleCategory.add(new Bogie("Sleeper", 68));

        Map<String, List<Bogie>> grouped = groupBogies(singleCategory);

        assertEquals(1, grouped.size(),
                "Map should contain exactly one key for single category");
        assertTrue(grouped.containsKey("Sleeper"),
                "Map should contain key 'Sleeper'");
        assertEquals(3, grouped.get("Sleeper").size(),
                "Sleeper group should have 3 bogies");
    }

    /**
     * testGrouping_MapContainsCorrectKeys()
     * Verifies that the grouped Map contains the expected bogie type keys.
     * Tests: Keys such as "Sleeper", "AC Chair", and "First Class" exist in the Map.
     */
    @Test
    void testGrouping_MapContainsCorrectKeys() {
        Map<String, List<Bogie>> grouped = groupBogies(bogies);

        Set<String> expectedKeys = new HashSet<>(
                Arrays.asList("Sleeper", "AC Chair", "First Class"));

        assertEquals(expectedKeys, grouped.keySet(),
                "Map keys should match expected bogie type names");
    }

    /**
     * testGrouping_GroupSizeValidation()
     * Verifies that the number of bogies within each group
     * matches the expected count.
     * Tests: "Sleeper" group has 2, "AC Chair" has 2, "First Class" has 1.
     */
    @Test
    void testGrouping_GroupSizeValidation() {
        Map<String, List<Bogie>> grouped = groupBogies(bogies);

        assertEquals(2, grouped.get("Sleeper").size(),
                "Sleeper group should contain 2 bogies");

        assertEquals(2, grouped.get("AC Chair").size(),
                "AC Chair group should contain 2 bogies");

        assertEquals(1, grouped.get("First Class").size(),
                "First Class group should contain 1 bogie");
    }

    /**
     * testGrouping_OriginalListUnchanged()
     * Verifies that the original bogie list remains unchanged
     * after the grouping operation.
     * Tests: The original list size and contents remain the same after grouping.
     */
    @Test
    void testGrouping_OriginalListUnchanged() {
        int originalSize = bogies.size();
        List<String> originalNames = new ArrayList<>();
        for (Bogie b : bogies) {
            originalNames.add(b.getName());
        }

        // Perform grouping
        groupBogies(bogies);

        // Verify list size unchanged
        assertEquals(originalSize, bogies.size(),
                "Original list size should remain unchanged after grouping");

        // Verify list contents unchanged
        for (int i = 0; i < bogies.size(); i++) {
            assertEquals(originalNames.get(i), bogies.get(i).getName(),
                    "Original list content should remain unchanged after grouping");
        }
    }
}