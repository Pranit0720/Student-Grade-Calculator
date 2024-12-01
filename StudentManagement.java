import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String name;
    private int studentID;
    private double[] grades;


    //Constructor
    public Student(String name, int studentID, double[] grades) {
        this.name = name;
        this.studentID = studentID;
        this.grades = grades;
    }

    //Method to Calculate average grade
    public double calculateAverage() {
        double sum = 0;
        for(double grade : grades){
            sum += grade;
        }
        return sum/grades.length;
    }

    //Method to Display individual grades
    public void displayGrades() {
        System.out.println("Grades for "+ name +" :");
        for(double grade : grades){
            System.out.println(grade+" ");
        }
        System.out.println();
    }

    //Methodto determine if the student has passed or failed
    public boolean hasPassed(double passingGrade){
        return calculateAverage() >= passingGrade;
    }

    //Getter for name
    public String getName() {
        return name;
    }    
}



public class StudentManagement{
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();
        System.out.print("Enter number of students: ");
        int numOfStudents = sc.nextInt();

        //input detail for each student

        for(int i = 1;i <= numOfStudents;i++){
            System.out.println("Enter details for student "+ i +";");
            System.out.print("Enter name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Enter student ID: ");
            int studentID = sc.nextInt();
            System.out.print("Enter number of grades: ");
            int numberOfGrades = sc.nextInt();
            double[] grades = new double[numberOfGrades];
            System.out.println("Enter grades; ");
            for(int j = 0;j < numberOfGrades;j++){
                grades[j] = sc.nextDouble();

            }

            //Add the student to the list

            students.add(new Student(name, studentID,grades));
        }
        //calculate and display the class average
        double classTotal = 0;
        for(Student student : students){
            double avg = student.calculateAverage();
            classTotal += avg;
            student.displayGrades();
            System.out.println("Average: "+avg);
            System.out.println(student.getName()+" has "+(student.hasPassed(50) ? "Passed":"failed")+".");
        }
        double classAvg = classTotal/students.size();
        System.out.println("Class average: "+classAvg);
        sc.close();
    }
}