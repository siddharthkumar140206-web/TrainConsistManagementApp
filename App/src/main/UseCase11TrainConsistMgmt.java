package main;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class UseCase11TrainConsistMgmt {

    public static void main(String[] args) {

        System.out.println("============================================");
        System.out.println("UC11 - Validate Train ID and Cargo Code");
        System.out.println("============================================\n");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Train ID (Format: TRN-1234): ");
        String trainId = scanner.nextLine();

        System.out.print("Enter Cargo Code (Format: PET-AB): ");
        String cargoCode = scanner.nextLine();

        String trainIdPattern = "TRN-\\d{4}";
        String cargoCodePattern = "PET-[A-Z]{2}";

        Pattern trainPattern = Pattern.compile(trainIdPattern);
        Pattern cargoPattern = Pattern.compile(cargoCodePattern);

        Matcher trainMatcher = trainPattern.matcher(trainId);
        Matcher cargoMatcher = cargoPattern.matcher(cargoCode);

        boolean isTrainIdValid = trainMatcher.matches();
        boolean isCargoCodeValid = cargoMatcher.matches();

        System.out.println("\nValidation Results:");
        System.out.println("Train ID Valid: " + isTrainIdValid);
        System.out.println("Cargo Code Valid: " + isCargoCodeValid);

        System.out.println("\nUC11 validation completed...\n");

        scanner.close();
    }
}