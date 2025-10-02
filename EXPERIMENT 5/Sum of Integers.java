import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n===== AUTBOXING MENU =====");
            System.out.println("1. Enter Numbers and Calculate Sum");
            System.out.println("2. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();  

            switch (choice) {
                case 1:
                    sumOfIntegers();
                    break;
                case 2:
                    System.out.println("Exiting program...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }

    static void sumOfIntegers() {
        ArrayList<Integer> numbers = new ArrayList<>();
        System.out.println("Enter integers (type 'done' to finish):");
        while (true) {
            String input = sc.nextLine();
            if (input.equalsIgnoreCase("done")) {
                break;
            }
            try {
                int value = Integer.parseInt(input);
                numbers.add(value);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter an integer or 'done'.");
            }
        }
        int sum = 0;
        for (Integer num : numbers) {
            sum += num;
        }
        System.out.println("Numbers entered: " + numbers);
        System.out.println("Sum of integers: " + sum);
    }
}
