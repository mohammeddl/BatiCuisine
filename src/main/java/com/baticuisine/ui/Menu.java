package main.java.com.baticuisine.ui;
import java.util.Scanner;

public class Menu {
    
    private Scanner scanner = new Scanner(System.in);

    public void displayMenu() {
        boolean quit = false;
        while (!quit) {

            System.out.println("=== Main Menu ===");
            System.out.println("1. Create a new project");
            System.out.println("2. Show existing projects");
            System.out.println("3. Calculate project cost");
            System.out.println("4. Quit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Creating a new project...");
                    break;
                case 2:
                    System.out.println("Showing existing projects...");
                    break;
                case 3:
                    System.out.println("Calculating project cost...");
                    break;
                case 4:
                    System.out.println("Quitting...");
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }



    
}
