import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/*
 * Purpose: Create a list for the entire school;
 * Author:
 * Date:
 * Version:
 */
public class SchoolMemberList {
    // 1. Attributes:
    public ArrayList<Member> list;
    private TeacherList teacherList;
    private StudentList studentList;
    private float maxAverageScore;

    // 2. Getters and setters:
    public ArrayList<Member> getList() {
        return list;
    }

    public float getMaxAverageScore() {
        return maxAverageScore;
    }

    public StudentList getStudentList() {
        return studentList;
    }

    public void setStudentList(StudentList studentList) {
        this.studentList = studentList;
    }

    public TeacherList getTeacherList() {
        return teacherList;
    }

    public void setTeacherList(TeacherList teacherList) {
        this.teacherList = teacherList;
    }

    public void setList(ArrayList<Member> list) {
        this.list = list;
    }

    // 3. Constructors:
    public SchoolMemberList(ArrayList<Member> list, TeacherList teacherList, StudentList studentList) {
        super();
        this.list = list;
        this.teacherList = teacherList;
        this.studentList = studentList;
    }

    public SchoolMemberList() {
        this.teacherList = new TeacherList();
        this.studentList = new StudentList();
        this.list = new ArrayList<Member>();
    }

    // 4. Input and output:
    public void enter(Scanner scan) {
        Teacher teacher = new Teacher();
        Student student = new Student();
        boolean flag = true;

        do {
            System.out.println("Enter 1 for Teacher or 2 for Student");
            int n = Integer.parseInt(scan.nextLine());
            switch (n) {
                case 1:
                    teacher.enter(scan);
                    this.list.add(teacher);
                    flag = false;
                    break;
                case 2:
                    student.enter(scan);
                    this.list.add(student);
                    flag = false;
                    break;
                default:
                    break;
            }
        } while (flag);
    }

    public void display() {
        for (Member member : this.list) {
            member.display();
        }
    }

    // 5. Business methods:
    // 5.1 Create mock data;
    public void createSchoolMemberList() {
        this.teacherList.createData();
        for (Teacher teacher : teacherList.getList()) {
            teacher.calculateExperience();
            this.list.add(teacher);
        }

        this.studentList.createData();
        for (Student student : this.studentList.getList()) {
            student.calculateAverage();
            student.classifyStudent();
            this.list.add(student);
        }
    }

    // 5.2 Method to calculate the number of teaching years for teachers
    public void calculateExperience() {
        for (Member member : this.list) {
            if (member instanceof Teacher) {
                ((Teacher) member).calculateExperience();
            }
        }
    }

    // 5.3 Method to find the teacher with the highest experience
    public void findTeacherWithMaxExperience() {
        Teacher teacher = this.teacherList.getList().get(0);
        for (Teacher t : this.teacherList.getList()) {
            if (teacher.getExperienceYears() < t.getExperienceYears()) {
                teacher = t;
            }
        }
        System.out.println("Teacher with the most experience is:");
        teacher.display();
    }

    // 5.4 Find teachers with more than 5 years of experience and in the natural sciences group
    public void findTeachersInNaturalSciences() {
        System.out.println("List of teachers with more than 5 years of experience and in the natural sciences group:");
        for (Teacher t : this.teacherList.getList()) {
            if (t.getExperienceYears() > 5 && t.getExpertise().equalsIgnoreCase("Natural")) {
                t.display();
            }
        }
    }

    // 5.5 Calculate the average score of students:
    // 5.6 Calculate the highest average score of students
    public void findMaxAverageScore() {
        Student student = this.studentList.getList().get(0);
        for (Student s : this.studentList.getList()) {
            if (student.getAverageScore() < s.getAverageScore()) {
                student = s;
            }
        }
        System.out.println("The highest average score is: " + student.averageScore);
        this.maxAverageScore = student.averageScore;
    }

    public void displayStudentsWithMaxAverageScore() {
        System.out.println("List of students with the highest average score:");
        for (Student s : this.studentList.getList()) {
            if (s.getAverageScore() == maxAverageScore) {
                s.display();
            }
        }
    }

    // 5.7 Implement sorting and output using quickSort
    public void quickSortByAverageScore(StudentList list, int low, int high) {
        if (this.list == null || list.getList().size() == 0) {
            return;
        }
        if (low >= high) {
            return;
        }

        float pivot = list.getList().get(high).getAverageScore();
        int i = low, j = high;

        while (i <= j) {
            while (list.getList().get(i).getAverageScore() > pivot) {
                i++;
            }
            while (list.getList().get(j).getAverageScore() < pivot) {
                j--;
            }
            if (i <= j) {
                Collections.swap(list.getList(), i, j);
                i++;
                j--;
            }
        }

        if (low < j) {
            quickSortByAverageScore(list, low, j);
        }
        if (high > i) {
            quickSortByAverageScore(list, i, high);
        }
    }

    public void performQuickSort() {
        this.quickSortByAverageScore(this.studentList, 0, this.studentList.getList().size() - 1);
    }

    public void displaySortedByAverageScore() {
        this.performQuickSort();
        this.studentList.display();
    }

    // 5.8 Implement sorting student names using Bubble sort:
    public void displaySortedByFullName() {
        int i, j;
        for (i = 0; i < this.studentList.getList().size() - 1; i++) {
            for (j = this.studentList.getList().size() - 1; j > i; j--) {
                if (this.studentList.getList().get(j).getFullName().codePointAt(0) <
                        this.studentList.getList().get(i).getFullName().codePointAt(0)) {
                    Collections.swap(this.studentList.getList(), i, j);
                }
            }
        }
        this.studentList.display();
    }
}
