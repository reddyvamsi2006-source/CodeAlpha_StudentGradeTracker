import java.util.Scanner;

class Student {
    private String name;
    private int score;
    private char grade;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
        this.grade = calculateGrade(score);
    }

    private char calculateGrade(int score) {
        if (score >= 90) return 'A';
        else if (score >= 80) return 'B';
        else if (score >= 70) return 'C';
        else if (score >= 60) return 'D';
        else return 'F';
    }

    public String getName() { return name; }
    public int getScore() { return score; }
    public char getGrade() { return grade; }
}

public class GradingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();
        scanner.nextLine(); // consume newline

        Student[] students = new Student[numStudents];

        // Input details
        for (int i = 0; i < numStudents; i++) {
            System.out.println("\n--- Student " + (i + 1) + " ---");
            System.out.print("Enter student name: ");
            String name = scanner.nextLine();

            System.out.print("Enter student score: ");
            int score = scanner.nextInt();
            scanner.nextLine(); // consume newline

            students[i] = new Student(name, score);
        }

        // Calculate statistics
        int total = 0, highest = Integer.MIN_VALUE, lowest = Integer.MAX_VALUE;
        String topStudent = "", lowStudent = "";

        for (Student s : students) {
            int score = s.getScore();
            total += score;
            if (score > highest) {
                highest = score;
                topStudent = s.getName();
            }
            if (score < lowest) {
                lowest = score;
                lowStudent = s.getName();
            }
        }

        double average = (double) total / numStudents;

        // Display report
        System.out.println("\nStudent Grade Summary:");
        System.out.printf("%-20s %-10s %-10s\n", "Name", "Score", "Grade");
        System.out.println("------------------------------------------");
        for (Student s : students) {
            System.out.printf("%-20s %-10d %-10c\n", s.getName(), s.getScore(), s.getGrade());
        }

        System.out.println("\nClass Statistics:");
        System.out.println("Average Score: " + String.format("%.2f", average));
        System.out.println("Highest Score: " + highest + " (" + topStudent + ")");
        System.out.println("Lowest Score : " + lowest + " (" + lowStudent + ")");

        scanner.close();
    }
}
