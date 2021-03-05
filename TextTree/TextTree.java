// Name: Rona Chan
// Class Name: CS20B
// Section: 4103
// Professor: Nicolai Kalisch
// Project: 3
// Date: 4/28/18
import java.util.*;

public class TextTree implements Iterable<String>
{
  // Variable Declarations
  private int height;
  private int numOfNodes;
  private WordNode root;

  public TextTree()
  {
    // Initialize variables
    height = 0;
    numOfNodes = 1;
    root = new WordNode("");
  }
  // Accpets a single sentence as String and breaks it up into words at each
  // space then inserted into the tree such that they define a path starting
  // at level 2.
  public boolean add(String sentence)
  {
    WordNode current = root;
    WordNode parent = root;
    int tempHeight = 0;
    String[] words = sentence.split(" ");
    // if the tree already has the sentence, no need to add so false
    if (this.contains(sentence))
    {
      return false;
    }
    for(int i = 0; i < words.length; i++)
    {
      // i.e. goodnode.search(morning) != goodnode, so current = morningnode
      while(i < words.length && (current = parent.search(words[i])) != parent)
      {
        // current is addressed as the new parent
        parent = current;
        // increment through words[]
        ++i;
      }
      // if the word is the same as the parent, add the word as child
      parent = current.addChild(words[i]);
      this.numOfNodes++;
      tempHeight++;
    }
    if (tempHeight > this.height)
    {
      this.height = tempHeight;
    }

    return true;
  }
  // Checks to see if the sentence already exists
  public boolean contains(String sentence)
  {
    WordNode current;
    WordNode parent = root;
    String[] words = sentence.split(" ");

    for(int i = 0; i < words.length; i++)
    {
      // use helper function
      current = parent.search(words[i]);

      if (parent == current)
      {
        return false;
      }
      parent = current;
    }
    return true;
  }
  // Returns the height of the tree
  public int height()
  {
    return height;
  }
  // Returns the size of the tree
  public int size()
  {
    return numOfNodes;
  }
  // returns an instance of LeafIterator
  public Iterator<String> iterator()
  {
    return new LeafIterator(this.root);
  }
}
