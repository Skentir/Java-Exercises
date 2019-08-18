import java.util.*;

public abstract class Document
{
  private String[] authors = new String[2];
  private Date date;

  public String getAuthors()
  {
    return authors[0];
  }

  public void addAuthor(String name)
  {
      authors[0] = name;
  }

  public Date getDate()
  {
    return date;
  }

}
