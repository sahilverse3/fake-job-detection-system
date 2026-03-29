import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Job> jobs = new ArrayList<>();
        JobAnalyzer analyzer = new JobAnalyzer();

        while (true) {
            System.out.println("\n1. Add Job");
            System.out.println("2. Analyze All Jobs");
            System.out.println("3. Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.println("Enter Company Name:");
                String company = sc.nextLine();

                System.out.println("Enter Email:");
                String email = sc.nextLine();

                System.out.println("Enter Job Description:");
                String description = sc.nextLine();

                System.out.println("Enter Salary:");
                double salary = sc.nextDouble();

                System.out.println("Does it ask for money? (true/false):");
                boolean asksMoney = sc.nextBoolean();
                sc.nextLine();

                Job job = new Job(company, email, description, salary, asksMoney);
                jobs.add(job);

                // Save to file
                try {
                    FileWriter fw = new FileWriter("jobs.txt", true);
                    fw.write(company + "," + email + "," + description + "," + salary + "," + asksMoney + "\n");
                    fw.close();
                } catch (Exception e) {
                    System.out.println("Error saving file");
                }

                System.out.println("Job added and saved successfully!");
            }

            else if (choice == 2) {
                if (jobs.isEmpty()) {
                    System.out.println("No jobs to analyze.");
                } else {
                    int i = 1;
                    for (Job job : jobs) {
                        System.out.println("\nJob " + i++);
                        System.out.println("Result: " + analyzer.analyze(job));
                    }
                }
            }

            else if (choice == 3) {
                System.out.println("Exiting...");
                break;
            }

            else {
                System.out.println("Invalid choice!");
            }
        }
    }
}