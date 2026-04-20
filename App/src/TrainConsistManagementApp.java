 feature/UC6-MapBogieToCapacity
import java.util.HashMap;
import java.util.Map;

 feature/UC5-InsertionOrderOfBogie
import java.util.LinkedHashSet;
import java.util.Set;
dev

 feature/UC4-Order_BogieIds
import java.util.LinkedList;
import java.util.List;
dev

public class TrainConsistManagementApp {
    public static void main(String[] args) {
        System.out.println("=========================================");
        System.out.println("UC6 - Map Bogie to Capacity (HashMap)");
        System.out.println("=========================================");
        System.out.println();

        Map<String, Integer> capacityMap = new HashMap<>();
        capacityMap.put("Sleeper", 72);
        capacityMap.put("AC Chair", 56);
        capacityMap.put("First Class", 24);
        capacityMap.put("Cargo", 120);

        System.out.println("Bogie Capacity Details:");
        for (Map.Entry<String, Integer> entry : capacityMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
        System.out.println();
        System.out.println("UC6 bogie-capacity mapping completed...");
    }
}

import java.util.LinkedHashSet;
import java.util.Set;

 class TrainConsistManagement {
    public static void main(String[] args) {

        System.out.println("==========================================");
        System.out.println("UC5 - Preserve Insertion Order of Bogies");
        System.out.println("==========================================\n");

        Set<String> formation = new LinkedHashSet<>();

        formation.add("Engine");
        formation.add("Sleeper");
        formation.add("Cargo");
        formation.add("Guard");

        formation.add("Sleeper");

        System.out.println("Final Train Formation:");
        System.out.println(formation);

        System.out.println("\nLinkedHashSet preserves insertion order and removes duplicates automatically.");
        System.out.println("\nUC5 formation setup completed...");
    }
}
 dev
