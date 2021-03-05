import java.util.*;

public class CircularArrayQueue
{
  private Object[] buffer;
  private int currentSize;
  private int head;
  private int tail;

  /**
    Constructs an empty queue
    */
    public CircularArrayQueue()
    {
      final int INITIAL_SIZE = 10;
      buffer = new Object[INITIAL_SIZE];
      currentSize = 0;
      head = 0;
      tail = 0;
    }
    /**
      checks whether this queue is empty.
      @return true if this queue is empty.
      */
      public boolean empty()
      {
        return currentSize==0;
      }
      /**
        adds an element to the tail of this queue
        @param newElement the element to add
        */
        public void add(Object newElement)
        {
          growBufferIfNecessary();
          currentSize++;
          buffer[tail] = newElement;
          tail = (tail + 1) % buffer.length;
        }
        /**
          removes an element from the head of this queue
          @return the removed element
          */
          public Object remove()
          {
            if(currentSize == 0)
            {
              throw new NoSuchElementException();
            }
            Object removed = buffer[head];
            head = (head + 1) % buffer.length;
            currentSize--;
            return removed;
          }
          /**
          grows teh buffer if the current size equals the buffer's capacity.
          */
          private void growBufferIfNecessary()
          {
            if(currentSize == buffer.length)
            {
              Object[] newBuffer = new Object[2*buffer.length];
              for(int i = 0; i < buffer.length; i++)
              {
                newBuffer[i] = buffer[(head + i) % buffer.length];
              }
              buffer = newBuffer;
              head = 0;
              tail = currentSize;
            }
          }
}
