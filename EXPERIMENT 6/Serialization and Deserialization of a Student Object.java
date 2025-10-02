import java.io.*;
import java.util.Scanner;

class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    private int studentID;
    private String name;
    private double grade;

    public Student(int studentID, String name, double grade) {
        this.studentID = studentID;
        this.name = name;
        this.grade = grade;
    }

    public void display() {
        System.out.println("Student ID: " + studentID);
        System.out.println("Name: " + name);
        System.out.println("Grade: " + grade);
    }
}

public class Main {
    static Scanner sc = new Scanner(System.in);
    static String filename = "student.ser";

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n===== SERIALIZATION MENU =====");
            System.out.println("1. Serialize New Student");
            System.out.println("2. Deserialize Last Student");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    serializeStudent();
                    break;
                case 2:
                    deserializeStudent();
                    break;
                case 3:
                    System.out.println("Exiting program...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }

    static void serializeStudent() {
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        sc.nextLine(); 
        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Grade: ");
        double grade = sc.nextDouble();
        sc.nextLine();

        Student s1 = new Student(id, name, grade);

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(s1);
            System.out.println("Student object has been serialized to " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void deserializeStudent() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            Student s2 = (Student) in.readObject();
            System.out.println("\nStudent object has been deserialized:");
            s2.display();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No serialized student found. Please serialize first.");
        }
    }
}
