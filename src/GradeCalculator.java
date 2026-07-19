import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("====== STUDENT GRADE CALCULATOR ======");
        System.out.print("Enter the number of subjects: ");
        int numSubjects = scanner.nextInt();

        if (numSubjects <= 0) {
            System.out.println("Invalid number of subjects. Exiting.");
            scanner.close();
            return;
        }

        double totalMarks = 0;

        // Input marks for each subject out of 100
        for (int i = 1; i <= numSubjects; i++) {
            while (true) {
                System.out.print("Enter marks obtained in Subject " + i + " (out of 100): ");
                double marks = scanner.nextDouble();

                if (marks >= 0 && marks <= 100) {
                    totalMarks += marks;
                    break;
                } else {
                    System.out.println("Invalid input. Marks must be between 0 and 100.");
                }
            }
        }

        // Calculations
        double averagePercentage = totalMarks / numSubjects;
        char grade;

        // Assigning grades based on average percentage
        if (averagePercentage >= 90) {
            grade = 'A';
        } else if (averagePercentage >= 80) {
            grade = 'B';
        } else if (averagePercentage >= 70) {
            grade = 'C';
        } else if (averagePercentage >= 60) {
            grade = 'D';
        } else if (averagePercentage >= 35) {
            grade = 'E';
        } else {
            grade = 'F';
        }

        // Displaying Results
        System.out.println("\n====== RESULTS ======");
        System.out.println("Total Marks Obtained: " + totalMarks + " / " + (numSubjects * 100));
        System.out.printf("Average Percentage  : %.2f%%\n", averagePercentage);
        System.out.println("Final Grade         : " + grade);

        scanner.close();
    }
}