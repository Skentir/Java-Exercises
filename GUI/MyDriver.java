public class MyDriver
{
  public static void main(String[] args)
  {
     MyGui gui = new MyGui();
     //Notebook ntb = new Notebook();
     MyController cont = new MyController(gui/*, ntb*/);
  }
}
