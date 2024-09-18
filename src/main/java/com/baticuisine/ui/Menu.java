package main.java.com.baticuisine.ui;
import java.util.Scanner;

import main.java.com.baticuisine.model.Client;
import main.java.com.baticuisine.model.Project;

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



    private void createNewProject(Scanner scanner) {
        System.out.println("--- Project Creation ---");

        // Client selection or creation
        System.out.println("1. Search for an existing client");
        System.out.println("2. Add a new client");
        int clientChoice = scanner.nextInt();
        scanner.nextLine();

        Client client;
        if (clientChoice == 1) {
            System.out.print("Enter the client's name: ");
            String clientName = scanner.nextLine();

        } else {
            client = createNewClient(scanner);
        }

        System.out.print("Enter the project name: ");
        String projectName = scanner.nextLine();

       
        System.out.println("Project created successfully!");
    }


    private Client createNewClient(Scanner scanner) {
        System.out.print("Enter the client name: ");
        String name = scanner.nextLine();

        System.out.print("Enter the client address: ");
        String address = scanner.nextLine();

        System.out.print("Enter the client phone number: ");
        String phone = scanner.nextLine();

        System.out.print("Is the client a professional? (true/false): ");
        boolean isProfessional = scanner.nextBoolean();
         return new Client(name, address, phone, isProfessional);
    }

    private void calculateProjectCost(Scanner scanner) {
        System.out.print("Enter the project name to calculate cost: ");
        String projectName = scanner.nextLine();
      
    }
}
