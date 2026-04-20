 feature/UC5-InsertionOrderOfBogie
import java.util.LinkedHashSet;
import java.util.Set;

 feature/UC4-Order_BogieIds
import java.util.LinkedList;
import java.util.List;
dev

public class TrainConsistManagementApp {
    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("UC5 - Preserve Insertion Order of Bogies");
        System.out.println("========================================");
        System.out.println();

        Set<String> formation = new LinkedHashSet<>();
        formation.add("Engine");
        formation.add("Sleeper");
        formation.add("Cargo");
        formation.add("Guard");
        formation.add("Sleeper");

        System.out.println("Final Train Formation:");
        System.out.println(formation);
        System.out.println();
        System.out.println("Note:");
        System.out.println("LinkedHashSet preserves insertion order and removes duplicates automatically.");
        System.out.println();
        System.out.println("UC5 formation setup completed....") ;
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
