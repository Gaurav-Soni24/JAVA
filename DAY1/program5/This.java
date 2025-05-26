package program5;

import java.lang.String;
import java.util.Scanner;
import java.util.ArrayList;

class Student{
    long rollNumber;
    String name;

    static int totalStudents;

    Student(){
        this(0L, "Unknown");
    }

    Student(long rollNumber, String name){
        this.rollNumber = rollNumber;
        this.name = name;
        System.out.println("Student Created Successfully with Name " + this.name + " and Roll Number " + this.rollNumber + "!!!");
        totalStudents++;
        System.out.println("Total Number of Students : " + totalStudents);
    }

    void updateDetails(long rollNumber, String name){
        this.rollNumber = rollNumber;
        this.name = name;
        System.out.println("Details Updated Successfully with Name " + this.name + " and Roll Number " + this.rollNumber + "!!!");
    }

    void setRollNumber(long rollNumber){
        updateDetails(rollNumber, this.name);
    }

    void setName(String name){
        updateDetails(this.rollNumber, name);
    }

    int getTotalStudents(){
        return totalStudents;
    }

    void displayStudent(){
        System.out.println("Roll Number: " + rollNumber + ", Name: " + name);
    }

    @Override
    public String toString(){
        return "Student [Roll Number: " + rollNumber + ", Name: " + name + "]";
    }
}

public class This {
    static ArrayList<Student> students = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=================================");
        System.out.println("  STUDENT MANAGEMENT SYSTEM");
        System.out.println("=================================");

        while(true){
            displayMenu();
            System.out.print("Enter your choice: ");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // consume newline

                switch(choice){
                    case 1:
                        addStudent();
                        break;
                    case 2:
                        displayAllStudents();
                        break;
                    case 3:
                        searchStudent();
                        break;
                    case 4:
                        updateStudentDetails();
                        break;
                    case 5:
                        updateStudentName();
                        break;
                    case 6:
                        updateStudentRollNumber();
                        break;
                    case 7:
                        deleteStudent();
                        break;
                    case 8:
                        displayTotalStudents();
                        break;
                    case 9:
                        displayStudentsByName();
                        break;
                    case 10:
                        clearAllStudents();
                        break;
                    case 11:
                        displaySystemInfo();
                        break;
                    case 0:
                        exitSystem();
                        return;
                    default:
                        System.out.println("❌ Invalid choice! Please select a valid option.");
                }

                System.out.println("\nPress Enter to continue...");
                scanner.nextLine();

            } catch (Exception e) {
                System.out.println("❌ Invalid input! Please enter a valid number.");
                scanner.nextLine(); // clear invalid input
                System.out.println("\nPress Enter to continue...");
                scanner.nextLine();
            }
        }
    }

    static void displayMenu(){
        System.out.println("\n=================================");
        System.out.println("           MAIN MENU");
        System.out.println("=================================");
        System.out.println("1️⃣  Add New Student");
        System.out.println("2️⃣  Display All Students");
        System.out.println("3️⃣  Search Student");
        System.out.println("4️⃣  Update Student Details");
        System.out.println("5️⃣  Update Student Name Only");
        System.out.println("6️⃣  Update Roll Number Only");
        System.out.println("7️⃣  Delete Student");
        System.out.println("8️⃣  Show Total Students Count");
        System.out.println("9️⃣  Display Students (Sorted by Name)");
        System.out.println("🔟  Clear All Students");
        System.out.println("🔍  System Information");
        System.out.println("0️⃣  Exit System");
        System.out.println("=================================");
    }

    static void addStudent(){
        System.out.println("\n--- Add New Student ---");
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine().trim();

        if(name.isEmpty()){
            System.out.println("❌ Name cannot be empty!");
            return;
        }

        System.out.print("Enter Roll Number: ");
        try {
            long rollNumber = scanner.nextLong();
            scanner.nextLine(); // consume newline

            // Check if roll number already exists
            if(findStudentByRollNumber(rollNumber) != null){
                System.out.println("❌ Student with Roll Number " + rollNumber + " already exists!");
                return;
            }

            Student student = new Student(rollNumber, name);
            students.add(student);
            System.out.println("✅ Student added successfully!");

        } catch (Exception e) {
            System.out.println("❌ Invalid roll number! Please enter a valid number.");
            scanner.nextLine(); // clear invalid input
        }
    }

    static void displayAllStudents(){
        System.out.println("\n--- All Students ---");
        if(students.isEmpty()){
            System.out.println("📝 No students found in the system.");
            return;
        }

        System.out.println("Total Students: " + students.size());
        System.out.println("================================");

        for(int i = 0; i < students.size(); i++){
            System.out.println((i+1) + ". " + students.get(i));
        }
    }

    static void searchStudent(){
        System.out.println("\n--- Search Student ---");
        System.out.println("1. Search by Roll Number");
        System.out.println("2. Search by Name");
        System.out.print("Choose search method: ");

        try {
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch(choice){
                case 1:
                    searchByRollNumber();
                    break;
                case 2:
                    searchByName();
                    break;
                default:
                    System.out.println("❌ Invalid choice!");
            }
        } catch (Exception e) {
            System.out.println("❌ Invalid input!");
            scanner.nextLine();
        }
    }

    static void searchByRollNumber(){
        System.out.print("Enter Roll Number to search: ");
        try {
            long rollNumber = scanner.nextLong();
            scanner.nextLine();

            Student student = findStudentByRollNumber(rollNumber);
            if(student != null){
                System.out.println("✅ Student Found:");
                student.displayStudent();
            } else {
                System.out.println("❌ No student found with Roll Number: " + rollNumber);
            }
        } catch (Exception e) {
            System.out.println("❌ Invalid roll number!");
            scanner.nextLine();
        }
    }

    static void searchByName(){
        System.out.print("Enter Name to search: ");
        String name = scanner.nextLine().trim();

        ArrayList<Student> foundStudents = new ArrayList<>();
        for(Student student : students){
            if(student.name.toLowerCase().contains(name.toLowerCase())){
                foundStudents.add(student);
            }
        }

        if(foundStudents.isEmpty()){
            System.out.println("❌ No students found with name containing: " + name);
        } else {
            System.out.println("✅ Students Found (" + foundStudents.size() + "):");
            for(Student student : foundStudents){
                student.displayStudent();
            }
        }
    }

    static void updateStudentDetails(){
        System.out.println("\n--- Update Student Details ---");
        System.out.print("Enter Roll Number of student to update: ");

        try {
            long rollNumber = scanner.nextLong();
            scanner.nextLine();

            Student student = findStudentByRollNumber(rollNumber);
            if(student == null){
                System.out.println("❌ No student found with Roll Number: " + rollNumber);
                return;
            }

            System.out.println("Current Details: " + student);
            System.out.print("Enter new name: ");
            String newName = scanner.nextLine().trim();

            System.out.print("Enter new roll number: ");
            long newRollNumber = scanner.nextLong();
            scanner.nextLine();

            // Check if new roll number already exists (and it's not the same student)
            Student existing = findStudentByRollNumber(newRollNumber);
            if(existing != null && existing != student){
                System.out.println("❌ Roll Number " + newRollNumber + " already exists!");
                return;
            }

            student.updateDetails(newRollNumber, newName);
            System.out.println("✅ Student details updated successfully!");

        } catch (Exception e) {
            System.out.println("❌ Invalid input!");
            scanner.nextLine();
        }
    }

    static void updateStudentName(){
        System.out.println("\n--- Update Student Name ---");
        System.out.print("Enter Roll Number of student: ");

        try {
            long rollNumber = scanner.nextLong();
            scanner.nextLine();

            Student student = findStudentByRollNumber(rollNumber);
            if(student == null){
                System.out.println("❌ No student found with Roll Number: " + rollNumber);
                return;
            }

            System.out.println("Current Name: " + student.name);
            System.out.print("Enter new name: ");
            String newName = scanner.nextLine().trim();

            if(newName.isEmpty()){
                System.out.println("❌ Name cannot be empty!");
                return;
            }

            student.setName(newName);
            System.out.println("✅ Student name updated successfully!");

        } catch (Exception e) {
            System.out.println("❌ Invalid input!");
            scanner.nextLine();
        }
    }

    static void updateStudentRollNumber(){
        System.out.println("\n--- Update Student Roll Number ---");
        System.out.print("Enter current Roll Number: ");

        try {
            long oldRollNumber = scanner.nextLong();
            scanner.nextLine();

            Student student = findStudentByRollNumber(oldRollNumber);
            if(student == null){
                System.out.println("❌ No student found with Roll Number: " + oldRollNumber);
                return;
            }

            System.out.println("Current Roll Number: " + student.rollNumber);
            System.out.print("Enter new roll number: ");
            long newRollNumber = scanner.nextLong();
            scanner.nextLine();

            // Check if new roll number already exists
            if(findStudentByRollNumber(newRollNumber) != null){
                System.out.println("❌ Roll Number " + newRollNumber + " already exists!");
                return;
            }

            student.setRollNumber(newRollNumber);
            System.out.println("✅ Roll number updated successfully!");

        } catch (Exception e) {
            System.out.println("❌ Invalid input!");
            scanner.nextLine();
        }
    }

    static void deleteStudent(){
        System.out.println("\n--- Delete Student ---");
        System.out.print("Enter Roll Number of student to delete: ");

        try {
            long rollNumber = scanner.nextLong();
            scanner.nextLine();

            Student student = findStudentByRollNumber(rollNumber);
            if(student == null){
                System.out.println("❌ No student found with Roll Number: " + rollNumber);
                return;
            }

            System.out.println("Student to delete: " + student);
            System.out.print("Are you sure you want to delete this student? (y/n): ");
            String confirm = scanner.nextLine().trim().toLowerCase();

            if(confirm.equals("y") || confirm.equals("yes")){
                students.remove(student);
                Student.totalStudents--;
                System.out.println("✅ Student deleted successfully!");
                System.out.println("Total Students now: " + Student.totalStudents);
            } else {
                System.out.println("❌ Deletion cancelled.");
            }

        } catch (Exception e) {
            System.out.println("❌ Invalid input!");
            scanner.nextLine();
        }
    }

    static void displayTotalStudents(){
        System.out.println("\n--- Student Statistics ---");
        System.out.println("📊 Total Students in System: " + Student.totalStudents);
        System.out.println("📋 Students in Current List: " + students.size());

        if(Student.totalStudents != students.size()){
            System.out.println("ℹ️  Note: Some students may have been removed from the list.");
        }
    }

    static void displayStudentsByName(){
        System.out.println("\n--- Students Sorted by Name ---");
        if(students.isEmpty()){
            System.out.println("📝 No students found in the system.");
            return;
        }

        // Simple bubble sort by name
        ArrayList<Student> sortedStudents = new ArrayList<>(students);
        for(int i = 0; i < sortedStudents.size() - 1; i++){
            for(int j = 0; j < sortedStudents.size() - i - 1; j++){
                if(sortedStudents.get(j).name.compareToIgnoreCase(sortedStudents.get(j + 1).name) > 0){
                    Student temp = sortedStudents.get(j);
                    sortedStudents.set(j, sortedStudents.get(j + 1));
                    sortedStudents.set(j + 1, temp);
                }
            }
        }

        System.out.println("Total Students: " + sortedStudents.size());
        System.out.println("================================");
        for(int i = 0; i < sortedStudents.size(); i++){
            System.out.println((i+1) + ". " + sortedStudents.get(i));
        }
    }

    static void clearAllStudents(){
        System.out.println("\n--- Clear All Students ---");
        if(students.isEmpty()){
            System.out.println("📝 No students to clear.");
            return;
        }

        System.out.print("⚠️  Are you sure you want to delete ALL students? (y/n): ");
        String confirm = scanner.nextLine().trim().toLowerCase();

        if(confirm.equals("y") || confirm.equals("yes")){
            int count = students.size();
            students.clear();
            Student.totalStudents = 0;
            System.out.println("✅ All " + count + " students have been cleared from the system!");
        } else {
            System.out.println("❌ Operation cancelled.");
        }
    }

    static void displaySystemInfo(){
        System.out.println("\n--- System Information ---");
        System.out.println("🏫 Student Management System v1.0");
        System.out.println("📊 Current Statistics:");
        System.out.println("   • Total Students Created: " + Student.totalStudents);
        System.out.println("   • Active Students in List: " + students.size());
        System.out.println("   • Memory Usage: " + (students.size() * 2) + " student records");
        System.out.println("⚙️  Available Operations: 11 different actions");
        System.out.println("💾 Data Storage: In-memory (ArrayList)");
        System.out.println("🔍 Search Options: By Roll Number or Name");
    }

    static void exitSystem(){
        System.out.println("\n=================================");
        System.out.println("   Thank you for using");
        System.out.println("  STUDENT MANAGEMENT SYSTEM");
        System.out.println("=================================");
        System.out.println("👋 Goodbye! Have a great day!");
        System.out.println("📊 Final Statistics:");
        System.out.println("   • Total Students: " + Student.totalStudents);
        System.out.println("   • Active Records: " + students.size());
        scanner.close();
    }

    // Helper method to find student by roll number
    static Student findStudentByRollNumber(long rollNumber){
        for(Student student : students){
            if(student.rollNumber == rollNumber){
                return student;
            }
        }
        return null;
    }
}