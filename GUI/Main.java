import javax.swing.*;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
  public static void main(String[] args)
  {
    MainFrame frame = new MainFrame("Hello World"); /* Declares the Frame, Holds the Title */
    frame.setLayout(null);
    JButton button1 = new JButton("Submit"); /* Instantiate it with a string, icon, or nothing */
        button1.setBounds(50,50,150,30); /*x,y,width, height*/
    JButton button2 = new JButton("Exit");
        button2.setBounds(220,50, 150, 30);
    JLabel label1 = new JLabel("Buttons are "); /* text */
        label1.setBounds(50, 20, 150,30);
    JLabel label2 = new JLabel();
        label2.setBounds(50, 120, 150,30);

    JTextField field1 = new JTextField("Enter name:"); /* Place holder*/
        field1.setBounds(50, 80, 150, 30);
        button1.addActionListener(new ActionListener() { /* Anonymous */
          private int btn1_counter = 0;
          @Override /* REQUIRED to override*/
          public void actionPerformed(ActionEvent e) {
              // System.out.println(field1.getText());
              label1.setText("Hello " + field1.getText());
              btn1_counter++;
              label2.setText("Counter: " + btn1_counter);
          }
        });
    /* All components have a setBounds() */
    frame.add(button1); /* 0 by 0 if not instantiated*/
    frame.add(button2);
    frame.add(label1);
    frame.add(field1);
    frame.add(label2);
    /* Add all components dynamically before setting frame visible */
    frame.setVisible(true);
  }
}
/* JFrame is a type of container in Java Swing, we add components to import junit.framework.TestCase;
 e.g. JButton. Container can have multiple containers but a component cannot be without container
*/
class MainFrame extends JFrame
{ /* All PUBLIC functions of (Parent) JFrame in (Children) MainFrame*/
  MainFrame(String title) {
    setTitle(title);
    setSize(500, 500);
    setResizable(false); /* Prevents user from resizing */
  }
}
