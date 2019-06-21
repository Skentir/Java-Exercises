import javax.swing.*;
import java.awt.*;

public class MyGui extends JFrame
/*
 * Extends we are inheriting whatever JFrame has
 * Java GUI libraries: AWT, Swing, FX
 */
{
   private JButton btnOk;
   private JButton btnCancel;
   private JTextField tfEntry;

  public MyGui()
  {
    super("My First GUI"); /*super calls the JFrame package*/
    setDefaultCloseOperation(EXIT_ON_CLOSE); /* should never be before super*/
    setSize(500,800);
    initGui();
    setVisible(true);
    /* default is invisible. should always be last ni constructor.*/
  }

  public void initGui()
  /* make sure to be included in constructor or else it wont be initialized. */
  {
    /* Doesn't need to be an attribute bc no need for data retrieval*/
    JLabel lbTitle = new JLabel("Title: ");
    tfEntry = new JTextField();
    btnOk = new JButton("Ok?");
    btnCancel = new JButton("Cancel!");
    /* Layouts:
    * Flow - flexible but left to right and top to bottom placement
    * Border - 5 panels. Panels can have different layout.
    * Grid - Each "square" is of equal size
    */
    JPanel pnlBase = new JPanel();
    add(pnlBase, BorderLayout.NORTH);
    pnlBase.setLayout(new BorderLayout());

    add(lbTitle, BorderLayout.NORTH);
    add(tfEntry, BorderLayout.SOUTH);
  }
}
