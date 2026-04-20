package main;

public class UseCase20TrainConsistMgmt {

    public static boolean searchBogie(String[] bogieIds, String searchId) {

        if (bogieIds.length == 0) {
            throw new IllegalStateException("No bogies available in train. Cannot perform search.");
        }

        for (String id : bogieIds) {
            if (id.equals(searchId)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        System.out.println("============================================");
        System.out.println("UC20 - Exception Handling During Search");
        System.out.println("============================================\n");

        String[] bogieIds = {};   // empty train scenario
        String searchId = "BG101";

        boolean found = searchBogie(bogieIds, searchId);

        if (found) {
            System.out.println("Bogie " + searchId + " found.");
        } else {
            System.out.println("Bogie " + searchId + " not found.");
        }

        System.out.println("\nUC20 execution completed...");
    }
}