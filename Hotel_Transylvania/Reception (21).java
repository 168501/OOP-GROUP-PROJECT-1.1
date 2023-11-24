import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Reception {
    private static final String RESERVATION_FILE = "reservations.txt";
    private static final String CURRENT_GUESTS_FILE = "currentGuests.txt";
    private static final String LOGS_FILE = "logs.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Reception System!");

        System.out.print("Enter guest ID: ");
        int guestId = scanner.nextInt();

        // Check if the guest has a reservation
        boolean hasReservation = checkReservation(guestId);

        if (hasReservation) {
            // Guest has a reservation
            String guestName = getGuestName(guestId);
            System.out.println("Guest Name: " + guestName);

            System.out.print("Is the guest checking in? (true/false): ");
            boolean isCheckingIn;
            try {
                isCheckingIn = Boolean.parseBoolean(scanner.next());
            } catch (Exception e) {
                System.out.println("Invalid input for check-in. Please enter 'true' or 'false'.");
                return;
            }

            if (isCheckingIn) {
                // Guest is checking in
                payAndCheckIn(guestId, guestName);
                logCheckIn(guestName, guestId);
            } else {
                // Guest is checking out
                checkOut(guestId, guestName);
            }
        } else {
            // Guest does not have a reservation
            System.out.println("No reservation found for guest ID: " + guestId);
        }

        // Close the scanner
        scanner.close();
    }

    private static boolean checkReservation(int guestId) {
        try (BufferedReader reader = new BufferedReader(new FileReader(RESERVATION_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Guest ID: " + guestId)) {
                    return true; // Reservation found
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }
        return false; // Reservation not found
    }

    private static String getGuestName(int guestId) {
        try (BufferedReader reader = new BufferedReader(new FileReader(RESERVATION_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Guest ID: " + guestId)) {
                    return reader.readLine().substring("Name: ".length());
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }
        return null; // Guest name not found
    }

    private static void payAndCheckIn(int guestId, String guestName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(RESERVATION_FILE));
             BufferedWriter writer = new BufferedWriter(new FileWriter(RESERVATION_FILE, true));
             BufferedWriter currentGuestsWriter = new BufferedWriter(new FileWriter(CURRENT_GUESTS_FILE, true));
             BufferedWriter logsWriter = new BufferedWriter(new FileWriter(LOGS_FILE, true))) {

            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Guest ID: " + guestId)) {
                    // Extract data from the reservation
                    String roomType = reader.readLine().substring("Room Type: ".length());

                    // Mark guest as checked in
                    writer.write("Checked In: true\n");
                    writer.write("\n"); // Separate entries with a blank line

                    // Write current guest data to currentGuests.txt
                    currentGuestsWriter.write("Guest ID: " + guestId + "\n");
                    currentGuestsWriter.write("Name: " + guestName + "\n");
                    currentGuestsWriter.write("Room Type: " + roomType + "\n");
                    currentGuestsWriter.write("Checked In: true\n");
                    currentGuestsWriter.write("\n"); // Separate entries with a blank line

                    System.out.println("Guest checked in successfully.");
                    return;
                }
            }
            System.out.println("Guest ID " + guestId + " not found in the reservations file.");

        } catch (IOException e) {
            System.err.println("Error processing check-in: " + e.getMessage());
        }
    }

    private static void checkOut(int guestId, String guestName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(RESERVATION_FILE));
             BufferedWriter currentGuestsWriter = new BufferedWriter(new FileWriter(CURRENT_GUESTS_FILE, true))) {

            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Guest ID: " + guestId)) {
                    // Extract data from the reservation
                    String roomType = reader.readLine().substring("Room Type: ".length());

                    // Mark guest as checked out in the reservation file
                    currentGuestsWriter.write("Guest ID: " + guestId + "\n");
                    currentGuestsWriter.write("Name: " + guestName + "\n");
                    currentGuestsWriter.write("Room Type: " + roomType + "\n");
                    currentGuestsWriter.write("Checked In: false\n");
                    currentGuestsWriter.write("\n"); // Separate entries with a blank line

                    System.out.println("Guest checked out successfully.");
                    return;
                }
            }
            System.out.println("Guest ID " + guestId + " not found in the reservations file.");

        } catch (IOException e) {
            System.err.println("Error processing check-out: " + e.getMessage());
        }
    }

    private static void logCheckIn(String guestName, int guestId) {
        try (BufferedWriter logsWriter = new BufferedWriter(new FileWriter(LOGS_FILE, true))) {
            // Get the current date and time
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String currentDate = dateFormat.format(new Date());

            // Write log entry to logs.txt
            logsWriter.write("Name: " + guestName + " Guest ID: " + guestId + " checked in during this date and time: " + currentDate + "\n");
            logsWriter.write("\n"); // Separate entries with a blank line
        } catch (IOException e) {
            System.err.println("Error writing to logs file: " + e.getMessage());
        }
    }
}
