// Name: Rona Chan
// Class Name: CS20B
// Section: 4103
// Professor: Nicolai Kalisch
// Project: 3
// Date: 4/28/18
import java.util.*;

public class LeafIterator implements Iterator<String>
{
  private Stack<WordNode> stack;

  public LeafIterator(WordNode root)
  {
    // Create a new Stack
    stack = new Stack<>();
    // Insert root Node if the stack is empty & root Node is null
    if(root != null)
    {
      insert(root);
    }
  }

  private void insert(WordNode root)
  {
    for (WordNode child: root.getChildren())
    {
      // If the child Node is a leaf, push aka insert into stack
      if (child.isLeaf())
      {
        stack.push(child);
      }
      else
      {
        this.insert(child);
      }
    }
  }

  public boolean hasNext()
  {
    return !stack.empty();
  }

  public String next()
  {
    return stack.pop().getWord();
  }
}
