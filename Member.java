import java.util.Scanner;

/*
 * Purpose: Create a superclass to manage members
 * Author:
 * Date:
 * Version:
 */
public class Member {
    // 1. Attributes:

    protected String fullName;
    protected int birthYear;
    protected String birthPlace;
    protected String address;

    // 2. Getters and setters
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // 3. Constructors
    public Member(String fullName, int birthYear, String birthPlace, String address) {
        super();
        this.fullName = fullName;
        this.birthYear = birthYear;
        this.birthPlace = birthPlace;
        this.address = address;
    }

    public Member() {

    }

    // 4. Input and output
    public void display() {
        System.out.print("Name: " + this.fullName + "\t Birth Year: " + this.birthYear + "\t Birth Place: "
                + this.birthPlace + "\t Address: " + this.address);
    }

    public void enter(Scanner scan) {
        System.out.println("Enter Name:");
        this.fullName = scan.nextLine();
        System.out.println("Enter Birth Year:");
        this.birthYear = Integer.parseInt(scan.nextLine());
        System.out.println("Enter Address:");
        this.address = scan.nextLine();
        System.out.println("Enter Birth Place:");
        this.birthPlace = scan.nextLine();
    }
}
