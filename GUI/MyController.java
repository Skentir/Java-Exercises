import java.awt.event.*;

public class MyController implements ActionListener // is a Listener
/* ActionListener is an interface. We can implements multiple interfaces.
* We have to code all of its methods.
*/
{
  private MyGui gui;

  public MyController(MyGui g /*, Notebook ntb*/)
  {
    gui = g;
    // ntb = n;
    gui.addListeners(this); // Pass the controller
  }

  public void actionPerformed(ActionEvent e)
  {
    if(e.getActionCommand().equals("Ok?"))
      gui.setTextContent("OK Button Pressed!");
    else if(e.getActionCommand().equals("Cancel!"))
      gui.setTextContent("Cancel Button Pressed!");
  }
}
