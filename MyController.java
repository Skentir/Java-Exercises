import java.awt.event.*;

public class MyController implements ActionListener
/* ActionListener is an interface. We can implements multiple interfaces.
* We have to code all of its methods.
*/
{
  private MyGui gui;

  public MyController(MyGui g /*, Notebook ntb*/)
  {
    gui = g;
    // ntb = n;
  }

  public void actionPerformed(ActionEvent e)
  {
    gui.setTextContent("Button Pressed!");
  }
}
