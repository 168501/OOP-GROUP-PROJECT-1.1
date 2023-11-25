import java.util.Scanner;
public class MainSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Hotel Management System");
        System.out.println("1. Book a Reservation");
        System.out.println("2. Receptionist Login");
        System.out.println("3. View Hotel Information");
        System.out.println("4. Employee list");
        System.out.println("5. suppliers details");
        System.out.println("6. exit");


        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                // Call the Reservation class to handle booking reservations
                ReservationSystem.main(args);
                break;
            case 2:
                // Call the ReceptionistLogin class to handle receptionist login
                Reception.main(args);
                break;
            case 3:
                // Call the HotelInfo class to display hotel information
                HotelInfo.main(args);
                break;
            case 4:
                // Call the HotelInfo class to display hotel information
                Staff.main(args);
                break;
            case 5:
                // Call the HotelInfo class to display hotel information
                Suppliers.main(args);
                break;
            case 6:
                System.out.println("Exiting the Hotel Management System. Goodbye!");
                break;

            default:
                System.out.println("Invalid choice");
        }

        scanner.close();
    }
}
