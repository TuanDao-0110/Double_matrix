import java.util.Scanner;

/*
 * Purpose: Subclass for the superclass Member
 * Author:
 * Date:
 * Version:
 */
public class Teacher extends Member {
    // 1. Attributes:
    public int startTeachingYear;
    public String expertise;
    public int experienceYears;
    final int CURRENT_YEAR = 2023;

    // 2. Getters and setters:
    public int getStartTeachingYear() {
        return startTeachingYear;
    }

    public void setExperienceYears(int experienceYears) {
        this.experienceYears = experienceYears;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public void setStartTeachingYear(int startTeachingYear) {
        this.startTeachingYear = startTeachingYear;
    }

    public String getExpertise() {
        return expertise;
    }

    public void setExpertise(String expertise) {
        this.expertise = expertise;
    }

    // 3. Constructors:
    public Teacher(String fullName, int birthYear, String birthPlace, String address, int startTeachingYear,
            String expertise) {
        super(fullName, birthYear, birthPlace, address);
        this.startTeachingYear = startTeachingYear;
        this.expertise = expertise;
    }

    public Teacher(String fullName, int birthYear, String birthPlace, String address, int startTeachingYear,
            String expertise, int experienceYears) {
        super(fullName, birthYear, birthPlace, address);
        this.startTeachingYear = startTeachingYear;
        this.expertise = expertise;
        this.experienceYears = experienceYears;
    }

    public Teacher() {
        // TODO Auto-generated constructor stub
    }

    // 4. Input and output:

    @Override
    public void enter(Scanner scan) {
        // TODO Auto-generated method stub
        super.enter(scan);
        System.out.println("Enter the starting year of teaching:");
        this.startTeachingYear = Integer.parseInt(scan.nextLine());
        boolean flag = true;
        do {
            System.out.println("Enter 1. Natural Sciences or 2. Social Sciences:");
            int n = Integer.parseInt(scan.nextLine());
            if (n == 1) {
                this.expertise = "Natural";
                flag = false;
            } else if (n == 2) {
                this.expertise = "Social";
                flag = false;
            }
        } while (flag);
    }

    @Override
    public void display() {
        // TODO Auto-generated method stub
        super.display();
        System.out.println("\t Starting Teaching Year: " + this.startTeachingYear + "\t Expertise: " + this.expertise
                + "\t Experience Years: " + this.experienceYears + " years");
    }

    public void calculateExperience() {
        this.experienceYears = this.CURRENT_YEAR - this.startTeachingYear;
    }
}
