// Name: Rona Chan
// Class Name: CS20B
// Section: 4103
// Professor: Nicolai Kalisch
// Project: 3
// Date: 4/28/18
import java.util.*;

public class Run
{
  public static void main(String[]args)
  {
    TextTree tree = new TextTree();
    tree.add("Good Morning!");
    tree.add("Good Night!");
    tree.add("Today is Wednesday!");
    tree.add("Today is Thursday!");
    tree.add("Today, it's raining.");

    System.out.println("Contains Good Morning?:" + tree.contains("Good Morning!"));

    for (String print : tree)
    {
      System.out.print(print + " ");
    }
    System.out.println();

    System.out.println("Tree Size: " + tree.size());
    System.out.println("Tree height: " + tree.height());
  }
}
