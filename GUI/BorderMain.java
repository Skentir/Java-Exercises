import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.*;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class BorderMain {
  public static void main (String[] args) {
    GridFrame frame = new GridFrame();
    /*
    frame.add(new JButton("Center"), BorderLayout.CENTER);
    frame.add(new JButton("East"), BorderLayout.EAST);
    frame.add(new JButton("West"), BorderLayout.WEST);
    frame.add(new JButton("North"), BorderLayout.NORTH);
    frame.add(new JButton("South"), BorderLayout.SOUTH);
    */
    frame.add(new JButton("1st"));
    frame.add(new JButton("2nd"));
    frame.add(new JButton("3rd"));
    frame.add(new JButton("4th"));
    frame.add(new JButton("5th"));
    frame.display();
  }
}

class GridFrame extends JFrame {
  GridFrame() {
    setLayout(new GridLayout(4,4)); /* rows , cols */
    setSize(700,500);
    setTitle("Grid Layout Sample");
  }
  public void display(){
    setVisible(true);
  }
}
class BorderFrame extends JFrame {
  BorderFrame() {
    setLayout(new BorderLayout(10,10)); /* horizontal gap, vertical gap or No gap*/
    setSize(700,500); /*width, height*/
    setTitle("Border Layout Sample");
  }
  public void display(){
    setVisible(true);
  }
}
