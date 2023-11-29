import java.util.Scanner;

/*
 * Purpose: Create a processing file:
 */
public class Processor {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        SchoolMemberList schoolMemberList = new SchoolMemberList();
        schoolMemberList.createSchoolMemberList();
        doMenu(schoolMemberList, scan);
    }

    public static void doMenu(SchoolMemberList schoolMemberList, Scanner scan) {
        boolean flag = true;
        do {
            System.out.println("1. Enter Data");
            System.out.println("2. Display Teacher with Most Experience");
            System.out.println("3. Display Teachers with More Than 5 Years of Experience in Natural Sciences");
            System.out.println("4. Find Highest Average Score");
            System.out.println("5. Display Students with Highest Average Score");
            System.out.println("6. Display the Entire School List, Including Classification for Students");
            System.out.println("7. Sort Students with Highest Average Score");
            System.out.println("8. Sort Students by Name");
            System.out.println("0. Exit");
            int choice = Integer.parseInt(scan.nextLine());
            switch (choice) {
                case 1:
                    schoolMemberList.enter(scan);
                    break;
                case 2:
                    schoolMemberList.calculateExperience();
                    schoolMemberList.findTeacherWithMaxExperience();
                    break;
                case 3:
                    schoolMemberList.findTeachersInNaturalSciences();
                    break;
                case 4:
                    schoolMemberList.findMaxAverageScore();
                    schoolMemberList.displayStudentsWithMaxAverageScore();
                    break;
                case 5:
                    schoolMemberList.displayStudentsWithMaxAverageScore();
                    break;
                case 6:
                    schoolMemberList.display();
                    break;
                case 7:
                    schoolMemberList.displaySortedByAverageScore();
                    break;
                case 8:
                    schoolMemberList.displaySortedByFullName();
                    break;
                case 0:
                    flag = false;
                    break;
                default:
                    System.out.println("Invalid syntax.");
                    break;
            }
        } while (flag);
    }
}
