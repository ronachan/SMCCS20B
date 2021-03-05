// Name: Rona Chan
// Class Name: CS20B
// Section: 4103
// Professor: Nicolai Kalisch
// Project: 2
import java.util.*;

public class SortedList{
  private Node head;
  private Node tail;
  int listSize;
  // Default Constructor
  public SortedList()
  {
    head = null;
    listSize = 0;
  }
  /**
   * Inserts num at the appropriate location in the sorted list
   * @param num Integer to be added
   */
   public void add(int num)
   {
     Node current = new Node(num);
     // If the list starts off empty, the num will be the head
     if(head == null)
     {
       head = new Node(num);
       listSize++;
       return;
     }
     // check if the num is greater than the element in head
     else if(current.getElement() > head.getElement())
     {
       // insert head after current
       current.setNext(head);
       // set the new Node with int num as the new head
       head = current;
       // Increment the list Size
       listSize++;
       return;
     }
     // Use a temporary node to point to the head
     Node temp = head;
     // check to see if temp.next is not null and if the value is > the num passed through
     while(temp.getNext() != null && temp.getNext().getElement() > num)
     {
       // set temp as the next node
       temp = temp.getNext();
     }
     // Keeps the rest of the list while inserting
     current.setNext(temp.getNext());
     temp.setNext(current);
     listSize++;
   }

   /**
    * Checks if the given num already exists in the list
    * @param num Integer checked
    * @return true if num exists, false otherwise
    */
    public boolean contains(int num)
    {
      Node current = new Node();
      // use a node point to the head
      current = head;
      // Check to see if list is empty
      while(current != null)
      {
        // check for same value
        if(current.getElement() == num)
        {
          return true;
        }
        // set as next node to continue to compare
        current = current.getNext();
      }
      // false otherwise
      return false;
    }

    /**
     * Removes the num from this list
     * @param num Integer to be removed
     * @return true if found and removed, false otherwise
     */
     public boolean remove(int num)
     {
       // temporary node to point to head
       Node current = head;
       Node previous = new Node();
       // To check if the pointer to the head is the value we want to remove
       if(current.getElement() == num)
       {
         head = head.getNext();
         listSize--;
         return true;
       }
      // Since we already checked the head, check head's next
       while(current.getNext() != null)
       {
         // make previous the current (aka head, which is already checked)
         previous = current;
         // make current be the next value
         current = current.getNext();
         // if the value after head is equal to the num
         if(current.getElement() == num)
         {
           // The head will point to the next next value (skips over the node to remove)
           previous.setNext(current.getNext());
           // have current become the next node
           current = current.getNext();
           // decrement the list size
           listSize--;
           return true;
         }
         // if head's next isn't equal to num, move onto the next value
         else
         {
           current.setNext(current.getNext());
         }
       }
       return false;
     }

     /**
      * Gets the int at the given index
      * @param index Index in the list
      * @return Integer value at give index
      * @throws IndexOutOfBoundsException if invalid index is provided
      */
      public int get(int index)
      {
        // Throw an exception if index is not within range
        if(index < 0 || index > size())
        {
          throw new IndexOutOfBoundsException();
        }
        // use a temporary node to point to head
        Node temp = head;
        // Iterates to the int index passed through
        for(int i = 0; i < index; i++)
        {
          temp = temp.getNext();
        }
        // returns the value at the index passed through
        return temp.getElement();
      }

      /**
       * Counts the number of values in this list
       * @return Total integers in this list
       */
       public int size()
       {
         return listSize;
       }
       /**
        * Serializes the list to a string and returns that string
        * {0, 7, 9, 3, 1} or {} if list is empty
        * @return Serialized string of this list
        */

        @Override
        public String toString()
        {
          String printList= "";
          Node temp = new Node();
          // use the temporary node to point to the head
          temp = head;
          // As long as the list isn't empty
          while(temp != null)
          {
            // print out the value stored in temp which is pointing at head
            printList += temp.getElement() + ",";
            // set temp as the next value
            temp = temp.getNext();
          }
          // return the list printed
          return "{" + printList + "}";

        }

        /**
         * EXTRA CREDIT!
         * Reverses the order of this list:
         * If list is in ascending order, it re-orders it to descending order
         * If list is in descending order, it re-orders it to ascending order
         */
         public void reverse()
         {
           Node previous = null;
           Node current = new Node();
           // Supposedly the last node until null
           tail = null;
           // Set current as head
           current = head;
           // If the head isn't empty aka null
           while(current != null)
           {
             // set the tail as the second node
             tail=current.getNext();
             // set the current's next node as previous
             current.setNext(previous);
             // previous is the new temporary head ndoe
             previous= current;
             // current is now the second node after previous
             current=tail;
           }
           // head becomes the last node after the while loop
           head = previous;
         }

}
