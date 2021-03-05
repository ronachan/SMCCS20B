// Name: Rona Chan
// Class Name: CS20B
// Section: 4103
// Professor: Nicolai Kalisch
// Project: 2
import java.util.*;

public class Test
{
  public static void main(String[]args)
  {
    // Create a new list
    SortedList list = new SortedList();
    // Add elements
    list.add(1);
    list.add(81);
    list.add(63);
    list.add(7);
    list.add(8);
    list.add(9);
    list.add(23);
    list.add(41);
    // Print out the size of the list
    System.out.println("The list contains: " +list.size()+ " elements.");
    // Print out the list
    System.out.println("The list contains: " +list.toString());
    // Test the get() method
    System.out.println("Element at index 2: " + list.get(2));


    // Check if the contain() method works
    System.out.println("contains 81? " + list.contains(81) + "\nContains 70? " + list.contains(70));
    // Print out the list with a for loop and get(int index) method
    for(int i = 0; i < list.size(); i++)
    {
      System.out.println(list.get(i));
    }
    // Test the remove(int num) method
    System.out.println("Remove 9 from the list: " +list.remove(9));
    // Check if the list decrements
    System.out.println("The list contains: " +list.size()+ " elements.");
    // Print out to see if 9 is really removed
    System.out.println("The list contains: " +list.toString());

    for(int i = 0; i < list.size(); i++)
    {
      System.out.println(list.get(i));
    }
    /**
      Extra CREDIT
    */
    // Reverse the list
    list.reverse();
    // print out the list to see if it reverses
    System.out.println("The reversed list contains: " +list.toString());
  }

}
