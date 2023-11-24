import java.io.*;
import java.util.Scanner;

public class ReservationSystem {
    private static final double SINGLE_RATE = 1500.0;
    private static final double DUPLEX_RATE = 2000.0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Reservation System!");

        // Get user input
        System.out.print("Enter guest name: ");
        String name = scanner.nextLine();

        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine();

        // Choose room type
        System.out.println("Choose room type:");
        System.out.println("1. Single");
        System.out.println("2. Duplex");
        System.out.print("Enter your choice (1 or 2): ");
        int roomTypeChoice = scanner.nextInt();

        String roomType;
        double ratePerDay;

        if (roomTypeChoice == 1) {
            roomType = "Single";
            ratePerDay = SINGLE_RATE;
        } else if (roomTypeChoice == 2) {
            roomType = "Duplex";
            ratePerDay = DUPLEX_RATE;
        } else {
            System.out.println("Invalid choice. Defaulting to Single room.");
            roomType = "Single";
            ratePerDay = SINGLE_RATE;
        }

        // Get check-in date and length of stay
        System.out.print("Enter check-in date (YYYY-MM-DD): ");
        String checkInDate = scanner.next();
        System.out.print("Enter length of stay (in days): ");
        int lengthOfStay = scanner.nextInt();

        // Generate guest ID
        int guestId = generateGuestId();

        // Display reservation details to the client
        System.out.println("\nYour reservation details:");
        System.out.println("Guest ID: " + guestId);
        System.out.println("Name: " + name);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Room Type: " + roomType + " (Rate per day: $" + ratePerDay + ")");
        System.out.println("Check-in Date: " + checkInDate);
        System.out.println("Length of Stay: " + lengthOfStay + " days");

        // Calculate total cost
        double totalCost = lengthOfStay * ratePerDay;
        System.out.println("Total Cost: $" + totalCost);

        // Save reservation data to file
        saveReservationToFile(guestId, name, phoneNumber, roomType, checkInDate, lengthOfStay, totalCost);

        // Close the scanner
        scanner.close();
    }

    // Method to generate a unique guest ID
    private static int generateGuestId() {
        int latestGuestId = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader("reservations.txt"))) {
            // Read the last line of the file to get the latest guest ID
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Guest ID: ")) {
                    latestGuestId = Integer.parseInt(line.substring("Guest ID: ".length()));
                }
            }
        } catch (IOException | NumberFormatException e) {
            // Ignore and use the default value (0) if an error occurs
        }

        return latestGuestId + 1;
    }

    // Method to save reservation data to a text file
    private static void saveReservationToFile(int guestId, String name, String phoneNumber, String roomType,
                                              String checkInDate, int lengthOfStay, double totalCost) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("reservations.txt", true))) {
            // Append data to the file
            writer.write("Guest ID: " + guestId + "\n");
            writer.write("Name: " + name + "\n");
            writer.write("Phone Number: " + phoneNumber + "\n");
            int ratePerDay=0;
            if (roomType == "Single"){
                ratePerDay=1500;
            }
            else ratePerDay=2000;
            writer.write("Room Type: " + roomType + " (Rate per day: $" + ratePerDay + ")\n");
            writer.write("Check-in Date: " + checkInDate + "\n");
            writer.write("Length of Stay: " + lengthOfStay + " days\n");
            writer.write("Total Cost: $" + totalCost + "\n");
            writer.write("\n"); // Separate entries with a blank line
            System.out.println("Reservation data has been saved to reservations.txt");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }


}
