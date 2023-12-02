import java.util.Scanner;

/*
 * Purpose: Subclass for the superclass Member;
 * Author:
 * Date:
 * Version:
 */
public class Student extends Member {
    // 1. Attributes:
    private String classification;
    public float mathScore;
    public float physicsScore;
    public float chemistryScore;
    public float averageScore;

    // 2. Getters and setters:
    public float getMathScore() {
        return mathScore;
    }

    public String getClassification() {
        return classification;
    }

    public float getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(float averageScore) {
        this.averageScore = averageScore;
    }

    public void setMathScore(float mathScore) {
        this.mathScore = mathScore;
    }

    public float getPhysicsScore() {
        return physicsScore;
    }

    public void setPhysicsScore(float physicsScore) {
        this.physicsScore = physicsScore;
    }

    public float getChemistryScore() {
        return chemistryScore;
    }

    public void setChemistryScore(float chemistryScore) {
        this.chemistryScore = chemistryScore;
    }

    // 3. Constructors:
    public Student(String fullName, int birthYear, String birthPlace, String address, float mathScore,
            float physicsScore,
            float chemistryScore) {
        super(fullName, birthYear, birthPlace, address);
        this.mathScore = mathScore;
        this.chemistryScore = chemistryScore;
        this.physicsScore = physicsScore;
    }

    public Student() {
        // TODO Auto-generated constructor stub
    }

    // 4. Input and output:
    @Override
    public void enter(Scanner scan) {
        // TODO Auto-generated method stub
        super.enter(scan);
        System.out.println("Enter Math Score:");
        this.mathScore = Float.parseFloat(scan.nextLine());
        System.out.println("Enter Chemistry Score:");
        this.chemistryScore = Float.parseFloat(scan.nextLine());
        System.out.println("Enter Physic Score:");
        this.physicsScore = Float.parseFloat(scan.nextLine());
        this.calculateAverage();
        this.classifyStudent();
    }

    @Override
    public void display() {
        // TODO Auto-generated method stub
        super.display();
        System.out.println("\t Math Score: " + this.mathScore + "\t Chemistry Score: " + this.chemistryScore
                + "\t Physics Score: " + this.physicsScore + "\t Average Score: " + this.averageScore
                + "\t Classification: "
                + this.classification);
    }

    public void calculateAverage() {
        this.averageScore = ((this.chemistryScore + this.mathScore + this.physicsScore) / 3);
    }

    public void classifyStudent() {
        if (this.averageScore < 5) {
            this.classification = "Weak";
        } else if (this.averageScore < 7 && this.averageScore >= 5) {
            this.classification = "Average";
        } else if (this.averageScore >= 7 && this.averageScore < 8) {
            this.classification = "Good";
        } else if (this.averageScore >= 8 && this.averageScore < 9) {
            this.classification = "Excellent";
        } else {
            this.classification = "Outstanding";
        }
    }
}
