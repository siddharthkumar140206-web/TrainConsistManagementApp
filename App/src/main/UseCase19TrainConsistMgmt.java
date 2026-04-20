package main;
import java.util.Arrays;

public class UseCase19TrainConsistMgmt {

    public static boolean binarySearchBogieId(String[] bogieIds, String key) {
        // Handle empty array
        if (bogieIds == null || bogieIds.length == 0) {
            return false;
        }

        // Ensure data is sorted before binary search (precondition)
        Arrays.sort(bogieIds);

        // Initialize low and high indexes
        int low = 0;
        int high = bogieIds.length - 1;

        // ---- BINARY SEARCH LOGIC ----
        while (low <= high) {
            // Compute mid index correctly
            int mid = low + (high - low) / 2;

            // Compare key with mid element using compareTo()
            int comparison = key.compareTo(bogieIds[mid]);

            if (comparison == 0) {
                // Key found at mid position
                return true;
            } else if (comparison > 0) {
                // Key is greater, search right half
                low = mid + 1;
            } else {
                // Key is smaller, search left half
                high = mid - 1;
            }
        }

        // Key not found
        return false;
    }

    public static void main(String[] args) {

        System.out.println("=============================================");
        System.out.println(" UC19 - Binary Search for Bogie ID ");
        System.out.println("=============================================\n");

        // Create sorted array of bogie IDs
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};

        // Ensure data is sorted before binary search (precondition)
        Arrays.sort(bogieIds);

        // Search key
        String key = "BG309";

        // Display available bogies
        System.out.println("Sorted Bogie IDs:");
        for (String id : bogieIds) {
            System.out.println(id);
        }

        System.out.println();

        // ---- BINARY SEARCH LOGIC ----
        boolean found = binarySearchBogieId(bogieIds, key);

        // Display result
        if (found) {
            System.out.println("Bogie " + key + " found using Binary Search.");
        } else {
            System.out.println("Bogie " + key + " NOT found using Binary Search.");
        }

        System.out.println("\nUC19 search completed...");
    }
}