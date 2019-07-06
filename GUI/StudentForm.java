import javax.swing.*;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class StudentForm {
  public static void main(String[] args) {
      StudentForm stud = new StudentForm();
      Student s1 = new Student("118","Kirsten","Torrijos","Sison","CCS");
      StudentFrame frame = new StudentFrame();

      String[] fields = new String[] {
        "ID Number",
        "First Name",
        "Middle Name",
        "Last Name",
        "College"
      };
      ArrayList <JTextField> textfields = new ArrayList<JTextField>();

      for (int i = 0; i < fields.length; i++){
        JLabel name = new JLabel(fields[i]);
        JTextField field = new JTextField();

        name.setBounds(10, 20 + (i * 40), 150, 30);
        field.setBounds(170, 20 + (i * 40), 200, 30);

        textfields.add(field);
        frame.add(name);
        frame.add(field);
      }
      JButton submit = new JButton("Submit");
        submit.setBounds(170, 20+(5*40), 200, 30);
      JTextArea textarea = new JTextArea(20, 50); /* rows, columns*/
        textarea.setBounds(170, 20+(6*40), 200, 200);
        textarea.setEnabled(false); /* Prevents user from editing the text area */
      JList<Student> studentList = new JList <> ();
        studentList.setBounds(10, 20+(7*40), 400, 200);

      ArrayList<Student> students = new ArrayList<>();
      submit.addActionListener(e -> {
        Student newStudent = new Student(
            textfields.get(0).getText(),
            textfields.get(1).getText(),
            textfields.get(2).getText(),
            textfields.get(3).getText(),
            textfields.get(4).getText()
        );
        students.add(newStudent);

        Student [] sarr = new Student[students.size()];
        for (int i = 0; i < students.size(); i++) {
          sarr[i] = students.get(i);
        }
        // textarea.append(newStudent.toString() + "\n");
        studentList.setListData(sarr); /* Convert from ArrayList to Array */
      });

      frame.add(submit);
      frame.add(studentList);
      frame.display();
  }
}

class StudentFrame extends JFrame {
  StudentFrame() {
    setTitle("StudentForm");
    setSize(500,700); /*widht height*/
    setLayout(null);
  }

  public void display() {
    setVisible(true);
  }
}

class Student {
    private String id_number;
    private String first_name;
    private String middle_name;
    private String last_name;
    private String college;

    public Student(String id, String first, String middle, String last, String college) {
        id_number = id;
        first_name = first;
        middle_name = middle;
        last_name = last;
        this.college = college;
    }
    public String getIDNumber() {
        return id_number;
    }
    public String getFirstName() {
      return first_name;
    }
    public String getMiddleName() {
      return middle_name;
    }
    public String getLastName() {
      return last_name;
    }
    public String getCollege() {
      return college;
    }

    public String toString() {
      return this.id_number + " " +
      this.first_name + " " + this.last_name + " " + this.college;
    }
  }
