package test;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UseCase10TrainConsistMgmtTest {

    // Inner Bogie class for testing
    static class Bogie {
        String name;
        int capacity;

        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }
    }

    @Test
    void testReduce_TotalSeatCalculation() {
        // Arrange
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("Sleeper", 70));

        // Act
        int totalSeats = bogies.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);

        // Assert
        assertEquals(222, totalSeats, "Total seating capacity should be 222");
    }

    @Test
    void testReduce_MultipleBogiesAggregation() {
        // Arrange
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 50));
        bogies.add(new Bogie("AC Chair", 60));
        bogies.add(new Bogie("First Class", 30));

        // Act
        int totalSeats = bogies.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);

        // Assert
        assertEquals(140, totalSeats, "Total should be sum of all bogie capacities");
    }

    @Test
    void testReduce_SingleBogieCapacity() {
        // Arrange
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));

        // Act
        int totalSeats = bogies.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);

        // Assert
        assertEquals(72, totalSeats, "Total should equal single bogie capacity");
    }

    @Test
    void testReduce_EmptyBogieList() {
        // Arrange
        List<Bogie> bogies = new ArrayList<>();

        // Act
        int totalSeats = bogies.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);

        // Assert
        assertEquals(0, totalSeats, "Empty list should return identity value 0");
    }

    @Test
    void testReduce_CorrectCapacityExtraction() {
        // Arrange
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 100));
        bogies.add(new Bogie("AC Chair", 200));

        // Act
        int totalSeats = bogies.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);

        // Assert
        assertEquals(300, totalSeats, "Capacities should be correctly extracted and summed");
    }

    @Test
    void testReduce_AllBogiesIncluded() {
        // Arrange
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 10));
        bogies.add(new Bogie("AC Chair", 20));
        bogies.add(new Bogie("First Class", 30));
        bogies.add(new Bogie("General", 40));

        // Act
        int totalSeats = bogies.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);

        // Assert
        assertEquals(100, totalSeats, "All bogies should be included in aggregation");
    }

    @Test
    void testReduce_OriginalListUnchanged() {
        // Arrange
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));

        int originalSize = bogies.size();
        int originalFirstCapacity = bogies.get(0).capacity;

        // Act
        int totalSeats = bogies.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);

        // Assert
        assertEquals(originalSize, bogies.size(), "Original list size should remain unchanged");
        assertEquals(originalFirstCapacity, bogies.get(0).capacity,
                "Original bogie data should remain unchanged");
        assertEquals(128, totalSeats, "Total should be correctly calculated");
    }
}