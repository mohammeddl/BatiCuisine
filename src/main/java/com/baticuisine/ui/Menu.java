package main.java.com.baticuisine.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import main.java.com.baticuisine.model.Client;
import main.java.com.baticuisine.model.Labor;
import main.java.com.baticuisine.model.Material;
import main.java.com.baticuisine.model.Project;
import main.java.com.baticuisine.service.client.ClientServiceImplt;
import main.java.com.baticuisine.service.labor.LaborServiceImplt;
import main.java.com.baticuisine.service.material.MaterialServiceImplt;
import main.java.com.baticuisine.service.project.ProjectService;

public class Menu {

    private final ProjectService projectService;
    private final ClientServiceImplt clientService;
    private final MaterialServiceImplt materialServiceImplt;
    private final LaborServiceImplt laborServiceImplt;


    private List<Material> materials = new ArrayList<>();
    private List<Labor> labors = new ArrayList<>();

    public Menu(ProjectService projectService, ClientServiceImplt clientService, MaterialServiceImplt materialServiceImplt, LaborServiceImplt laborServiceImplt) {
        this.projectService = projectService;
        this.clientService = clientService;
        this.materialServiceImplt = materialServiceImplt;
        this.laborServiceImplt = laborServiceImplt;
    }

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
                    createNewProject();
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

    private void createNewProject() {
        System.out.println("--- Project Creation ---");
        System.out.println("1. Search for an existing client");
        System.out.println("2. Add a new client");
        int clientChoice = scanner.nextInt();
        scanner.nextLine();

        Client client;
        if (clientChoice == 1) {
            System.out.print("Enter the client's name: ");
            String clientName = scanner.nextLine();
            client = clientService.getClientByName(clientName);
        } else {
            client = createNewClient();
        }

        System.out.print("Enter the project name: ");
        String projectName = scanner.nextLine();

        Project project = new Project(projectName, client);
        projectService.addProject(project);

        boolean addingComponents = true;

        while (addingComponents) {
            System.out.println("--- Adding components ---");
            System.out.println("Enter type of component (material/labor): ");
            String typeComponent = scanner.nextLine();

            if (typeComponent.equalsIgnoreCase("material")) {
                addMaterial(project);
            } else if (typeComponent.equalsIgnoreCase("labor")) {
                addLabor(project);
            } else {
                System.out.println("Invalid component type, please try again.");
                continue;
            }

            System.out.println("Do you want to add another component? (yes/no): ");
            addingComponents = scanner.nextLine().equalsIgnoreCase("yes");
        }


        double totalCost = calculateTotalCost();
        System.out.println("Total Cost: " + totalCost);

        System.out.print("Enter the benefit margin percentage: ");
        double marginBenefit = scanner.nextDouble();
        double benefitAmount = totalCost * (marginBenefit / 100);

        project.setTotalCost(totalCost);
        project.setMargeBeneficium(benefitAmount);

        projectService.calculateProjectBenefit(project);
        materials.clear();
        labors.clear();

        System.out.println("Project created successfully with calculated total cost and benefit!");
    }

    private void addMaterial(Project project) {
        System.out.println("--- Adding Material ---");
        System.out.print("Enter the name of the material: ");
        String materialName = scanner.nextLine();
        System.out.print("Enter the quantity of the material: ");
        int quantity = scanner.nextInt();
        System.out.print("Enter the tax rate of the material: ");
        int taxRate = scanner.nextInt();
        System.out.print("Enter the transport cost of the material: ");
        int transportCost = scanner.nextInt();
        scanner.nextLine();

        Project projectId = projectService.getProjectByName(project.getProjectName());
        Material material = new Material(materialName, quantity, taxRate, transportCost, "Material", projectId.getId());
        materials.add(material);
        materialServiceImplt.addMaterial(material);
        System.out.println("Material added successfully!");
    }

    private void addLabor(Project project) {
        System.out.println("--- Adding Labor ---");
        System.out.print("Enter the name of the labor: ");
        String laborName = scanner.nextLine();
        System.out.print("Enter the hourly rate: ");
        int hourlyRate = scanner.nextInt();
        System.out.print("Enter the number of hours: ");
        int hours = scanner.nextInt();
        scanner.nextLine();


        Project projectId = projectService.getProjectByName(project.getProjectName());
        Labor labor = new Labor(laborName, hourlyRate, hours, "Labor", projectId.getId());
        labors.add(labor);
        laborServiceImplt.addLabor(labor);
        System.out.println("Labor added successfully!");
    }

    private double calculateTotalCost() {
        double totalMaterialCost = materials.stream()
                                    .mapToDouble(Material::calculateCost)
                                    .sum();

        double totalLaborCost = labors.stream()
                                    .mapToDouble(Labor::calculateCost)
                                    .sum();
        return totalMaterialCost + totalLaborCost;
    }

    private Client createNewClient() {
        int id = 1;
        System.out.print("Enter the client name: ");
        String name = scanner.nextLine();

        System.out.print("Enter the client address: ");
        String address = scanner.nextLine();

        System.out.print("Enter the client phone number: ");
        String phone = scanner.nextLine();

        System.out.print("Is the client a professional? (true/false): ");
        boolean isProfessional = scanner.nextBoolean();
        scanner.nextLine(); 

        Client client = new Client(id++, name, address, phone, isProfessional);
        clientService.addClient(client);
        return client;
    }


}
