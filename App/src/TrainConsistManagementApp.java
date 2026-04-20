 feature/UC4-Order_BogieIds
import java.util.LinkedList;
import java.util.List;

public class TrainConsistManagementApp {
    public static void main(String[] args) {
        System.out.println("======================================");
        System.out.println("UC4 - Maintain Ordered Bogie Consist");
        System.out.println("======================================");
        System.out.println();

        List<String> trainConsist = new LinkedList<>();
        trainConsist.add("Engine");
        trainConsist.add("Sleeper");
        trainConsist.add("AC");
        trainConsist.add("Cargo");
        trainConsist.add("Guard");

        System.out.println("Initial Train Consist:");
        System.out.println(trainConsist);
        System.out.println();

        trainConsist.add(2, "Pantry Car");

        System.out.println("After Inserting 'Pantry Car' at position 2:");
        System.out.println(trainConsist);
        System.out.println();

        trainConsist.remove(0);
        trainConsist.remove(trainConsist.size() - 1);

        System.out.println("After Removing First and Last Bogie:");
        System.out.println(trainConsist);
        System.out.println();

        System.out.println("UC4 ordered consist operations completed...") ;
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
