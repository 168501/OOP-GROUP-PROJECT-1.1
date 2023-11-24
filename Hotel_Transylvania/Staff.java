import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Staff {
    private static final int NUM_EMPLOYEES_PER_CATEGORY = 20;

    public static void main(String[] args) {
        List<String> managementStaff = generateSampleNames("Management", NUM_EMPLOYEES_PER_CATEGORY);
        List<String> technicalStaff = generateSampleNames("Technical", NUM_EMPLOYEES_PER_CATEGORY);
        List<String> supportStaff = generateSampleNames("Support", NUM_EMPLOYEES_PER_CATEGORY);

        System.out.println("Management Staff:");
        printEmployeeList(managementStaff);

        System.out.println("\nTechnical Staff:");
        printEmployeeList(technicalStaff);

        System.out.println("\nSupport Staff:");
        printEmployeeList(supportStaff);
    }

    private static List<String> generateSampleNames(String category, int numEmployees) {
        List<String> employeeNames = new ArrayList<>();
        Random random = new Random();

        for (int i = 1; i <= numEmployees; i++) {
            String name = generateRandomName();
            employeeNames.add(category + " Employee " + i + ": " + name);
        }

        return employeeNames;
    }

    private static String generateRandomName() {
        String[] firstNames = {"Alice", "Bob", "Charlie", "David", "Emma", "Frank", "Grace", "Henry", "Ivy", "Jack"};
        String[] lastNames = {"Smith", "Johnson", "Williams", "Jones", "Brown", "Davis", "Miller", "Wilson", "Moore", "Taylor"};

        Random random = new Random();
        String firstName = firstNames[random.nextInt(firstNames.length)];
        String lastName = lastNames[random.nextInt(lastNames.length)];

        return firstName + " " + lastName;
    }

    private static void printEmployeeList(List<String> employeeList) {
        for (String employee : employeeList) {
            System.out.println(employee);
        }
    }
}
