package main.java.com.baticuisine.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Date;

import main.java.com.baticuisine.model.Client;
import main.java.com.baticuisine.model.Labor;
import main.java.com.baticuisine.model.Material;
import main.java.com.baticuisine.model.Project;
import main.java.com.baticuisine.model.Quote;
import main.java.com.baticuisine.service.client.ClientServiceImplt;
import main.java.com.baticuisine.service.labor.LaborServiceImplt;
import main.java.com.baticuisine.service.material.MaterialServiceImplt;
import main.java.com.baticuisine.service.project.ProjectService;
import main.java.com.baticuisine.service.quote.QuoteServiceImplt;
import main.java.com.baticuisine.util.InputValidator;

public class Menu {

    private final ProjectService projectService;
    private final ClientServiceImplt clientService;
    private final MaterialServiceImplt materialServiceImplt;
    private final LaborServiceImplt laborServiceImplt;
    private final QuoteServiceImplt quoteServiceImplt;


    private List<Material> materials = new ArrayList<>();
    private List<Labor> labors = new ArrayList<>();

    public Menu(ProjectService projectService, ClientServiceImplt clientService, MaterialServiceImplt materialServiceImplt, LaborServiceImplt laborServiceImplt, QuoteServiceImplt quoteServiceImplt) {
        this.projectService = projectService;
        this.clientService = clientService;
        this.materialServiceImplt = materialServiceImplt;
        this.laborServiceImplt = laborServiceImplt;
        this.quoteServiceImplt = quoteServiceImplt;
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
                    dispalyProjects();
                    break;
                case 3:
                    calculateProjectCost();
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
            client = clientService.getClientByName(clientName).orElse(null);
            if(client == null) {
                System.out.println("Client not found. Please add a new client.");
                client = createNewClient();
            }
        } else {
            client = createNewClient();
        }

        System.out.print("Enter the project name: ");
        String projectName = scanner.nextLine();
        if(!InputValidator.isValidString(projectName)) {
            System.out.println("Invalid project name. Please try again.");
            return;
        }

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

        System.out.println("Do you want to generate a quote for this project? (yes/no)");
        scanner.nextLine(); 
        String generateQuoteChoice = scanner.nextLine();
    
        if (generateQuoteChoice.equalsIgnoreCase("yes")) {
            generateQuote(project, totalCost);
        }
        materials.clear();
        labors.clear();

        System.out.println("Project created successfully with calculated total cost and benefit!");
    }

    //adding material
    private void addMaterial(Project project) {
        System.out.println("--- Adding Material ---");
        System.out.print("Enter the name of the material: ");
        String materialName = scanner.nextLine();
        if(!InputValidator.isValidString(materialName)) {
            System.out.println("Invalid material name. Please try again.");
            return;
        }
        System.out.print("Enter the quantity of the material: ");
        int quantity = scanner.nextInt();
        if(!InputValidator.isValidPositiveInteger(String.valueOf(quantity))) {
            System.out.println("Invalid quantity. Please try again.");
            return;
        }
        System.out.print("Enter the tax rate of the material: ");
        int taxRate = scanner.nextInt();
        if(!InputValidator.isValidPositiveInteger(String.valueOf(taxRate))) {
            System.out.println("Invalid tax rate. Please try again.");
            return;
        }
        System.out.print("Enter the transport cost of the material: ");
        int transportCost = scanner.nextInt();
        if(!InputValidator.isValidPositiveInteger(String.valueOf(transportCost))) {
            System.out.println("Invalid transport cost. Please try again.");
            return;
        }
        scanner.nextLine();

        Project projectId = projectService.getProjectByName(project.getProjectName()).orElseThrow(() -> new RuntimeException("Project not found"));
        Material material = new Material(materialName, quantity, taxRate, transportCost, "Material", projectId.getId());
        materials.add(material);
        materialServiceImplt.addMaterial(material);
    }

    //adding labor
    private void addLabor(Project project) {
        System.out.println("--- Adding Labor ---");
        System.out.print("Enter the name of the labor: ");
        String laborName = scanner.nextLine();
        if(!InputValidator.isValidString(laborName)) {
            System.out.println("Invalid labor name. Please try again.");
            return;
        }
        System.out.print("Enter the hourly rate: ");
        int hourlyRate = scanner.nextInt();
        if(!InputValidator.isValidPositiveInteger(String.valueOf(hourlyRate))) {
            System.out.println("Invalid hourly rate. Please try again.");
            return;
        }
        System.out.print("Enter the number of hours: ");
        int hours = scanner.nextInt();
        if(!InputValidator.isValidPositiveInteger(String.valueOf(hours))) {
            System.out.println("Invalid number of hours. Please try again.");
            return;
        }
        scanner.nextLine();

        Project projectId = projectService.getProjectByName(project.getProjectName()).orElseThrow(() -> new RuntimeException("Project not found"));
        Labor labor = new Labor(laborName, hourlyRate, hours, "Labor", projectId.getId());
        labors.add(labor);
        laborServiceImplt.addLabor(labor);
    }

    //calculating total cost
    private double calculateTotalCost() {
        double totalMaterialCost = materials.stream()
                                    .mapToDouble(Material::calculateCost)
                                    .sum();

        double totalLaborCost = labors.stream()
                                    .mapToDouble(Labor::calculateCost)
                                    .sum();
        return totalMaterialCost + totalLaborCost;
    }

    //creating new client
    private Client createNewClient() {
        System.out.print("Enter the client name: ");
        String name = scanner.nextLine();
        if(!InputValidator.isValidString(name)) {
            System.out.println("Invalid client name. Please try again.");
            return null;
        }

        System.out.print("Enter the client address: ");
        String address = scanner.nextLine();
        if(!InputValidator.isValidString(address)) {
            System.out.println("Invalid client address. Please try again.");
            return null;
        }

        System.out.print("Enter the client phone number: ");
        String phone = scanner.nextLine();
        if(!InputValidator.isValidString(phone)) {
            System.out.println("Invalid client phone number. Please try again.");
            return null;
        }
        
        System.out.print("Is the client a professional? (true/false): ");
        boolean isProfessional = scanner.nextBoolean();
        scanner.nextLine(); 

        Client clientNew = new Client(name, address, phone, isProfessional);
        clientService.addClient(clientNew);
        Client client = clientService.getClientByName(name).orElse(null);

        return client;
    }
    

    //generate quote project 
    private void generateQuote(Project project, double totalCost) {
        Client client = project.getClient();
        double discountPercentage = getDiscountPercentage(client);
        double discountAmount = totalCost * (discountPercentage / 100);
        double discountedCost = totalCost - discountAmount;

        System.out.println("Generating quote for project: " + project.getProjectName());
        System.out.println("Original Total Cost: " + totalCost);
        System.out.println("Discount Percentage: " + discountPercentage + "%");
        System.out.println("Discounted Total Cost: " + discountedCost);
        
        System.out.println("Generating quote for project: " + project.getProjectName());
    
        Date issueDate = new Date(); 
        Date validityDate = new Date(issueDate.getTime() + (7 * 24 * 60 * 60 * 1000)); 
    
        // Create a Quote object
        Project projectId = projectService.getProjectByName(project.getProjectName()).orElseThrow(() -> new RuntimeException("Project not found"));
        Quote quote = new Quote(discountedCost, issueDate, validityDate, false, projectId.getId()); 
        quoteServiceImplt.addQuote(quote); 
    
        System.out.println("Quote generated successfully!");
        System.out.println(quote);
    
        System.out.println("Do you want to accept this quote? (yes/no)");
        String acceptQuoteChoice = scanner.nextLine();
    
        if (acceptQuoteChoice.equalsIgnoreCase("yes")) {
            quote.setAccepted(true);
            projectId.setProjectStatus("terminated");
            System.out.println("Quote accepted!");
        } else {
            projectId.setProjectStatus("anulled");
            System.out.println("Quote not accepted.");
        }
        projectService.updateProject(projectId);
        quoteServiceImplt.updateQuote(quote);
    }

    // display projects
    public void  dispalyProjects() {
        System.out.println("Displaying projects...");
        projectService.displayProjects();
    }


    //calculate project cost
    public void calculateProjectCost() {
        Date issueDate = new Date(); 
        Date validityDate = new Date(issueDate.getTime() + (7 * 24 * 60 * 60 * 1000)); 
        dispalyProjects();
        System.out.println("Enter the project name: ");
        String projectName = scanner.nextLine();
        Project projectId = projectService.getProjectByName(projectName).orElseThrow(() -> new RuntimeException("Project not found"));
        Quote quote = new Quote(projectId.getTotalCost(), issueDate, validityDate, false, projectId.getId()); 
        System.out.println("Quote generated successfully!");
        Quote quoteResult = quoteServiceImplt.getQuote(projectId.getId()).orElse(null);
        System.out.println(quoteResult);
    
        quoteServiceImplt.addQuote(quote); 

        System.out.println("Do you want to accept this quote? (yes/no)");
        String acceptQuoteChoice = scanner.nextLine();
        
        if (acceptQuoteChoice.equalsIgnoreCase("yes")) {
            quote.setAccepted(true);
            System.out.println("Quote accepted!");
        } else {
            System.out.println("Quote not accepted.");
        }
        quoteServiceImplt.updateQuote(quote);
    }

    // calculate discount percentage
    private double getDiscountPercentage(Client client) {
        if (client.isProfessional()) { 
            return 10.0; 
        }
        return 0.0; 
    }
}
