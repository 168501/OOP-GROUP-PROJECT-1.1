public class HotelInfo {
    public static void main(String[] args) {
        String name;
        String location;
        String contactDetails;
        Hotel hotel = new Hotel("Hotel Transylvania", "Transylvania", "123-456-7890");

        System.out.println("Hotel Information");
        System.out.println("Name: " + hotel.getName());
        System.out.println("Location: " + hotel.getLocation());
        System.out.println("Contact: " + hotel.getContactDetails());
    }
}
