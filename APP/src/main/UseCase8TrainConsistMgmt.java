package main;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UseCase8TrainConsistMgmt {
    public static class Bogie {
        String name;
        int capacity;

        public Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }

        @Override
        public String toString() {
            return name + " -> " + capacity;
        }
    }

    public static List<Bogie> createBogieList() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("General", 90));
        return bogies;
    }

    public static List<Bogie> filterBogiesByCapacity(List<Bogie> bogies, int threshold) {
        return bogies.stream()
                .filter(b -> b.capacity > threshold)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        System.out.println("===============================================");
        System.out.println("UC8 - Filter Passenger Bogies Using Streams");
        System.out.println("===============================================");
        System.out.println();

        List<Bogie> bogies = createBogieList();

        System.out.println("All Bogies:");
        for (Bogie bogie : bogies) {
            System.out.println(bogie);
        }
        System.out.println();

        List<Bogie> filteredBogies = filterBogiesByCapacity(bogies, 60);

        System.out.println("Filtered Bogies (Capacity > 60):");
        for (Bogie bogie : filteredBogies) {
            System.out.println(bogie);
        }
        System.out.println();

        System.out.println("UC8 filtering completed...");
    }
}