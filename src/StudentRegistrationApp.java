import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class StudentRegistrationApp {
    private static final String BATCH_DATA_PATH = System.getenv("FILES_BATCH");
    private static final String DATA = System.getenv("DATA_BATCH");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(true){
            System.out.println("Main Menu");
            System.out.println("1- Add student data");
            System.out.println("2- Add batch students data");
            System.out.println("3- Exit");
    
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
    
            if (choice == 1) {
                System.out.println("Add Student Data");
                System.out.print("Enter student's name: ");
                String name = scanner.nextLine();
    
                System.out.print("Enter student's ID: ");
                int id = scanner.nextInt();
                scanner.nextLine();
    
                System.out.print("Enter courses (comma separated): ");
                String coursesInput = scanner.nextLine();
                String[] coursesArray = coursesInput.split(",");
    
                //Write name, id, coursesArray in txt
    
                String data = name + ";" + id + ";";
                for(String course : coursesArray) {
                    data += course + ",";
                    //if last course, remove comma
    
                    if(course.equals(coursesArray[coursesArray.length - 1])) {
                        data = data.substring(0, data.length() - 1);
                    }
                }
    
    
                try {
                    // Create a BufferedWriter object using FileWriter
                    String path = DATA + "/data.csv";
                    BufferedWriter writer = new BufferedWriter(new FileWriter(path, true));
    
                    // Write the new line to the file
                    writer.write(data);
                    writer.newLine();
    
                    // Close the writer
                    writer.close();
    
                    System.out.println("New line appended to the file.");
                } catch (IOException e) {
                    System.out.println("An error occurred: " + e.getMessage());
                }
    
    
    
    
                System.out.println("Student data added successfully!");
            } else if (choice == 2) {
                System.out.println("Add Batch Students Data");
                System.out.println("Listing eligible batch files:");
                listEligibleFiles();
    
                System.out.print("Enter the name of the file to insert: ");
                String fileName = scanner.nextLine();
                insertBatchData(fileName);
    
                System.out.println("Batch data inserted successfully!");
            } else if (choice == 3) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid choice!");
            }
        }
        
    }

    private static void listEligibleFiles() {
        File batchDir = new File(BATCH_DATA_PATH);
        File[] files = batchDir.listFiles((dir, name) -> name.contains("verified"));

        if (files != null) {
            for (File file : files) {
                System.out.println(file.getName());
            }
        }
    }

    private static void insertBatchData(String fileName) {
        try {
            File file = new File(BATCH_DATA_PATH + '/' +fileName);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(";");
                String data2 = "";

                if (data.length >= 3) {
                    String name = data[0];
                    int id = Integer.parseInt(data[1]);
                    String[] coursesArray = data[2].split(",");

                    System.out.println("Name: " + name);
                    System.out.println("ID: " + id);
                    System.out.println("Courses: ");
                    for (String course : coursesArray) {
                        System.out.println(course);
                    }
                    System.out.println();

                    data2 = name + ";" + id + ";";
                    for(String course : coursesArray) {
                        data2 += course + ",";
                        //if last course, remove comma

                        if(course.equals(coursesArray[coursesArray.length - 1])) {
                            data2 = data2.substring(0, data2.length() - 1);
                        }
                    }
                    try {
                        // Create a BufferedWriter object using FileWriter
                        String path = DATA + "/data.csv";
                        BufferedWriter writer = new BufferedWriter(new FileWriter(path, true));
        
                        // Write the new line to the file
                        writer.write(data2);
                        writer.newLine();
        
                        // Close the writer
                        writer.close();
        
                        System.out.println("New line appended to the file.");
                    } catch (IOException e) {
                        System.out.println("An error occurred: " + e.getMessage());
                    }


                }

            }

            scanner.close();
        } catch (Exception e) {
            System.out.println("Error reading batch file: " + e.getMessage());
        }
    }
}