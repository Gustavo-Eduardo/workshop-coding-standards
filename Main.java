import java.util.*;

class Student {
    String id;
    String name;
    List<Double> grades;
    boolean pass;
    boolean honor;

    public Student(String id, String name) {
        if (id == null || id.isEmpty() || name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name and ID cannot be empty");
        }
        this.id = id;
        this.name = name;
        grades = new ArrayList<Double>();
        this.pass = false;
        this.honor = false;
    }

    public void addGrade(double grade) {
        if (grade < 0 || grade > 100) {
            System.out.println("Grade should be in range [0-100]");
            return;
        }
        grades.add(grade);
    }

    public double getAverage() {
        double total = 0;
        for (double grade : grades) {
            total += grade;
        }
        double average = total / grades.size();
        pass = average >= 60;
        honor = average >= 90;
        return average;
    }

    public boolean getHonorStatus() {
        return getAverage() > 90;
    }

    public String getGradeLetter() {
        double average = getAverage();
        if (average > 90) {
            return "A";
        } else if (average > 80){
            return "B";
        } else if (average > 70) {
            return "C"; 
        } else if (average > 60) {
            return "D";
        } else {
            return "F";
        }
    }

    public void removeGrade(double grade) {
        grades.remove(grade);
    }

    public void reportCard() {
        System.out.println("Student: " + name);
        System.out.println("ID: " + id);
        System.out.println("Grades #: " + grades.size());
        System.out.println("Average: " + getAverage()); 
        System.out.println("Grade letter: " + getGradeLetter());
        System.out.println("Honor Roll: " + honor); 
        System.out.println("Passed: " + (pass ? "Passed" : "Failed"));
    }
}

public class Main {
    public static void main(String[] args) {
        Student s = new Student("abc", null);
        s.addGrade(100);
        s.addGrade(90);
        s.removeGrade(9); 
        s.reportCard();
    }
}
