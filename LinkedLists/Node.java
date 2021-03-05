// Name: Rona Chan
// Class Name: CS20B
// Section: 4103
// Professor: Nicolai Kalisch
// Project: 2
import java.util.*;

public class Node{
  private int element;
  private Node next;
  // Default Constructor
  public Node()
  {

  }
  // Constructor with int
  public Node(int value)
  {
    element = value;
  }
  public int getElement()
  {
    return element;
  }
  // setter
  public void setNext(Node nextNode)
  {
    next = nextNode;
  }
  // getter
  public Node getNext()
  {
    return next;
  }
  // Tests whether or not next is null
  boolean hasNext()
  {
    if(next == null)
    {
      return false;
    }
    else
    {
      return true;
    }
  }
}
