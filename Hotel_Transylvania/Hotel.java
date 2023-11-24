public class Hotel {
    private String name;
    private String location;
    private String contactDetails;


    public Hotel(String name, String location, String contactDetails) {
        this.name = name;
        this.location = location;
        this.contactDetails = contactDetails;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public String getContactDetails() {
        return contactDetails;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setContactDetails(String contactDetails) {
        this.contactDetails = contactDetails;
    }
}
