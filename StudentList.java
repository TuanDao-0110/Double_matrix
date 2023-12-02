import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class StudentList {
    public ArrayList<Student> list;

    public ArrayList<Student> getList() {
        return list;
    }

    public void setList(ArrayList<Student> list) {
        this.list = list;
    }

    public StudentList() {
        this.list = new ArrayList<Student>();
    }

    public void display() {
        for (Student student : this.list) {
            student.display();
        }
    }

    public void createData() {
        try {
            FileReader reader = new FileReader("./task.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] infoList = line.split(" # ");
                // Check if it is a head teacher or regular staff

                Student student = new Student();
                student.setFullName(infoList[1]);
                student.setBirthYear(Integer.parseInt(infoList[2]));
                student.setBirthPlace(infoList[3]);
                student.setAddress(infoList[4]);
                student.setChemistryScore(Float.parseFloat(infoList[5]));
                student.setPhysicsScore(Float.parseFloat(infoList[6]));
                student.setMathScore(Float.parseFloat(infoList[7]));

                this.list.add(student);
            }

            reader.close(); // Close the file
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
