 feature/UC7-SortBogiesByCapacity
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

 feature/UC6-MapBogieToCapacity
import java.util.HashMap;
import java.util.Map;
 dev

 feature/UC5-InsertionOrderOfBogie
import java.util.LinkedHashSet;
import java.util.Set;
dev

 feature/UC4-Order_BogieIds
import java.util.LinkedList;
import java.util.List;
dev

public class TrainConsistManagementApp {
    static class Bogie {
        String name;
        int capacity;

        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }

        @Override
        public String toString() {
            return name + " -> " + capacity;
        }
    }

    public static void main(String[] args) {
        System.out.println("==============================================");
        System.out.println("UC7 - Sort Bogies by Capacity (Comparator)");
        System.out.println("==============================================");
        System.out.println();

        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("General", 90));

        System.out.println("Before Sorting:");
        for (Bogie bogie : bogies) {
            System.out.println(bogie);
        }
        System.out.println();

        bogies.sort(Comparator.comparingInt(bogie -> bogie.capacity));

        System.out.println("After Sorting by Capacity:");
        for (Bogie bogie : bogies) {
            System.out.println(bogie);
        }
        System.out.println();

        System.out.println("UC7 sorting completed...");
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
