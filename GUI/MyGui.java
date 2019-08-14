import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyGui extends JFrame
/*
 * Extends we are inheriting whatever JFrame has
 * Java GUI libraries: AWT, Swing, FX
 */
{
   private JButton btnOk;
   private JButton btnCancel;
   private JTextField tfEntry;
   private JTextArea taContent;
   private ActionListener listener;

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
    setLayout(new BorderLayout());
    /* NORTH PANEL */
    add(pnlBase, BorderLayout.NORTH);
    pnlBase.add(lbTitle);
    tfEntry.setColumns(15);
    pnlBase.add(tfEntry);
    /* SOUTH PANEL*/
    pnlBase = new JPanel();
    add(pnlBase, BorderLayout.SOUTH);
    pnlBase.add(btnOk);
    pnlBase.add(btnCancel);
    /* CENTER PANEL */
    taContent = new JTextArea();
    add(taContent, BorderLayout.CENTER);
    /* Scroll Bar */
    taContent = new JTextArea();
    JScrollPane scrScroll = new JScrollPane(taContent);
    add(scrScroll, BorderLayout.CENTER);

  }

  public void addListeners(ActionListener a)
  {
      listener = a;
      btnOk.addActionListener(a); /* Can have multiple listerner per button*/
      btnCancel.addActionListener(a); /* Can have multiple listerner per button*/
  }

  public String getTextContent()
  {
    return taContent.getText();
  }

  public void setTextContent(String c)
  {
    taContent.setText(c);
  }
}
