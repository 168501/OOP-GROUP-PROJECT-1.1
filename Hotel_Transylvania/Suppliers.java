import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Suppliers {
    private static final int NUM_SUPPLIERS = 5;
    private static final int NUM_PRODUCTS_PER_SUPPLIER = 5;

    public static void main(String[] args) {
        List<Supplier> suppliers = generateSampleSuppliers();

        // Print information about each supplier and their supplies
        for (Supplier supplier : suppliers) {
            System.out.println("Supplier: " + supplier.getCompanyName());
            for (Supply supply : supplier.getSupplies()) {
                System.out.println("Supply Name: " + supply.getSupplyName());
                System.out.println("Amount: " + supply.getAmount());
                System.out.println("Date Supplied: " + supply.getDateSupplied());
                System.out.println();
            }
        }
    }

    private static List<Supplier> generateSampleSuppliers() {
        List<Supplier> suppliers = new ArrayList<>();

        for (int i = 1; i <= NUM_SUPPLIERS; i++) {
            String companyName = generateRandomCompanyName();
            List<Supply> supplies = generateSampleSupplies();

            Supplier supplier = new Supplier(companyName, supplies);
            suppliers.add(supplier);
        }

        return suppliers;
    }

    private static List<Supply> generateSampleSupplies() {
        List<Supply> supplies = new ArrayList<>();

        for (int i = 1; i <= NUM_PRODUCTS_PER_SUPPLIER; i++) {
            String supplyName = generateRandomProductName();
            int amount = generateRandomAmount();
            String dateSupplied = generateRandomDate();

            Supply supply = new Supply(supplyName, amount, dateSupplied);
            supplies.add(supply);
        }

        return supplies;
    }

    private static String generateRandomCompanyName() {
        String[] companyPrefixes = {"Global", "Elite", "Advanced", "Premium", "Innovative", "Superior", "Quality", "Pro", "Total", "Master"};
        String[] companySuffixes = {"Supplies", "Products", "Solutions", "Goods", "Merchants", "Services"};

        Random random = new Random();
        String prefix = companyPrefixes[random.nextInt(companyPrefixes.length)];
        String suffix = companySuffixes[random.nextInt(companySuffixes.length)];

        return prefix + " " + suffix + " Inc.";
    }

    private static String generateRandomProductName() {
        String[] productNames = {
                "Bed Linens", "Toiletries", "Cleaning Supplies", "Furniture", "Electronics",
                "Catering Services", "Office Supplies", "Uniforms", "Kitchen Equipment", "Luggage"};
        return productNames[new Random().nextInt(productNames.length)];
    }

    private static int generateRandomAmount() {
        return new Random().nextInt(100) + 1; // Random amount between 1 and 100
    }

    private static String generateRandomDate() {
        // Generating a random date within the past year
        long now = System.currentTimeMillis();
        long pastYearInMillis = 365L * 24 * 60 * 60 * 1000;
        long randomDateInMillis = now - (long) (Math.random() * pastYearInMillis);

        return new java.sql.Date(randomDateInMillis).toString();
    }
}

class Supplier {
    private String companyName;
    private List<Supply> supplies;

    public Supplier(String companyName, List<Supply> supplies) {
        this.companyName = companyName;
        this.supplies = supplies;
    }

    public String getCompanyName() {
        return companyName;
    }

    public List<Supply> getSupplies() {
        return supplies;
    }
}

class Supply {
    private String supplyName;
    private int amount;
    private String dateSupplied;

    public Supply(String supplyName, int amount, String dateSupplied) {
        this.supplyName = supplyName;
        this.amount = amount;
        this.dateSupplied = dateSupplied;
    }

    public String getSupplyName() {
        return supplyName;
    }

    public int getAmount() {
        return amount;
    }

    public String getDateSupplied() {
        return dateSupplied;
    }
}
