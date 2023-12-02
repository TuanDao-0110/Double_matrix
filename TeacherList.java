import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/*
 * Purpose: Create a list of teachers
 * Author:
 * Date:
 * Version:
 */
public class TeacherList {
    public ArrayList<Teacher> list;

    public TeacherList() {
        this.list = new ArrayList<Teacher>();
    }

    public ArrayList<Teacher> getList() {
        return list;
    }

    public void setList(ArrayList<Teacher> list) {
        this.list = list;
    }

    public void display() {
        for (Teacher teacher : this.list) {
            teacher.display();
        }
    }

    public void createData() {
        try {
            FileReader reader = new FileReader("./task1.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] infoList = line.split(" # ");
                // Check if it is a head teacher or regular staff
                Teacher teacher = new Teacher(infoList[1], Integer.parseInt(infoList[2]), infoList[3], infoList[4],
                        Integer.parseInt(infoList[5]), infoList[6]);                

                this.list.add(teacher);
            }
            // Create data for each personnel

            // Add personnel to the list

            reader.close(); // Close the file
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
