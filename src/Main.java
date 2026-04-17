import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;

public class Main {

    static ArrayList<Proposal> proposals = new ArrayList<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        loadFromFile(); //  загрузка данных

        while (true) {
            System.out.println("\n===== Proposal Management System =====");
            System.out.println("1. Add Proposal");
            System.out.println("2. View Proposals");
            System.out.println("3. Update Proposal");
            System.out.println("4. Delete Proposal");
            System.out.println("5. Export to CSV");
            System.out.println("6. Import from CSV");
            System.out.println("7. Exit");
            System.out.print("Choose option: ");

            int choice;

            // защита от ввода букв
            try {
                choice = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Please enter a number!");
                scanner.nextLine();
                continue;
            }
            scanner.nextLine();

            if (choice == 1) {
                addProposal(scanner);
            } else if (choice == 2) {
                viewProposals();
            } else if (choice == 3) {
                updateProposal(scanner);
            } else if (choice == 4) {
                deleteProposal(scanner);
            } else if (choice == 5) {
                exportToCSV();
            } else if (choice == 6) {
                importFromCSV();
            } else if (choice == 7) {
                saveToFile();
                System.out.println("Goodbye!");
                break;
            } else {
                System.out.println("Invalid choice!");
            }
        }
    }

    //  CREATE
    public static void addProposal(Scanner scanner) {

        int id;

        //  проверка ID
        try {
            System.out.print("Enter ID: ");
            id = scanner.nextInt();
            scanner.nextLine();
        } catch (Exception e) {
            System.out.println("Invalid ID!");
            scanner.nextLine();
            return;
        }

        //  проверка дубликата
        for (Proposal p : proposals) {
            if (p.getId() == id) {
                System.out.println("ID already exists!");
                return;
            }
        }


        System.out.print("Enter Title: ");
        String title = scanner.nextLine();

        if (title.isEmpty()) {
            System.out.println("Title cannot be empty!");
            return;
        }

        System.out.print("Enter Description: ");
        String description = scanner.nextLine();

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        if (name.isEmpty()) {
            System.out.println("Name cannot be empty!");
            return;
        }

        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        if (!email.contains("@")) {
            System.out.println("Invalid email!");
            return;
        }

        System.out.print("Enter Status: ");
        String status = scanner.nextLine();

        Proposal proposal = new Proposal(id, title, description, name, email, status);
        proposals.add(proposal);

        System.out.println("Proposal added!");
    }

    //  READ
    public static void viewProposals() {
        if (proposals.isEmpty()) {
            System.out.println("No proposals found.");
            return;
        }

        for (Proposal p : proposals) {
            p.display();
        }
    }

    //  UPDATE
    public static void updateProposal(Scanner scanner) {

        int id;

        //  защита от ошибки
        try {
            System.out.print("Enter ID to update: ");
            id = scanner.nextInt();
            scanner.nextLine();
        } catch (Exception e) {
            System.out.println("Invalid ID!");
            scanner.nextLine();
            return;
        }

        for (Proposal p : proposals) {
            if (p.getId() == id) {

                System.out.print("Enter new title: ");
                String newTitle = scanner.nextLine();

                if (newTitle.isEmpty()) {
                    System.out.println("Title cannot be empty!");
                    return;
                }

                p.setTitle(newTitle);

                System.out.println("Updated!");
                return;
            }
        }

        System.out.println("Proposal not found.");
    }

    //  DELETE
    public static void deleteProposal(Scanner scanner) {

        int id;

        try {
            System.out.print("Enter ID to delete: ");
            id = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Invalid ID!");
            scanner.nextLine();
            return;
        }

        //  безопасное удаление
        for (int i = 0; i < proposals.size(); i++) {
            if (proposals.get(i).getId() == id) {
                proposals.remove(i);
                System.out.println("Deleted!");
                return;
            }
        }

        System.out.println("Proposal not found.");
    }

    //SAVE
    public static void saveToFile() {
        try {
            FileWriter writer = new FileWriter("proposals.txt");

            for (Proposal p : proposals) {
                writer.write(p.getId() + "," + p.getTitle() + "," + p.getStatus() + "\n");
            }

            writer.close();
            System.out.println("Saved to file!");

        } catch (IOException e) {
            System.out.println("Error saving file.");
        }
    }

    //  LOAD
    public static void loadFromFile() {
        try {
            File file = new File("proposals.txt");
            Scanner reader = new Scanner(file);

            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                String[] parts = line.split(",");

                int id = Integer.parseInt(parts[0]);
                String title = parts[1];
                String status = parts.length > 2 ? parts[2] : "Loaded";

                Proposal p = new Proposal(id, title, "", "", "", status);
                proposals.add(p);
            }

            reader.close();

        } catch (Exception e) {
            System.out.println("No saved file found.");
        }
    }

    //  EXPORT
    public static void exportToCSV() {
        try {
            FileWriter writer = new FileWriter("export.csv");

            writer.write("ID,Title,Status\n");

            for (Proposal p : proposals) {
                writer.write(p.getId() + "," + p.getTitle() + "," + p.getStatus() + "\n");
            }

            writer.close();
            System.out.println("Exported to CSV!");

        } catch (IOException e) {
            System.out.println("Error exporting.");
        }
    }

    //  IMPORT
    public static void importFromCSV() {
        try {
            File file = new File("export.csv");
            Scanner reader = new Scanner(file);

            reader.nextLine();

            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                String[] parts = line.split(",");

                int id = Integer.parseInt(parts[0]);
                String title = parts[1];
                String status = parts.length > 2 ? parts[2] : "Imported";

                Proposal p = new Proposal(id, title, "", "", "", status);
                proposals.add(p);
            }

            reader.close();
            System.out.println("Imported from CSV!");

        } catch (Exception e) {
            System.out.println("Error importing.");
        }
    }
}