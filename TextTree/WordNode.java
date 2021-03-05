// Name: Rona Chan
// Class Name: CS20B
// Section: 4103
// Professor: Nicolai Kalisch
// Project: 3
// Date: 4/28/18
import java.util.*;

public class WordNode
{
  // Variable Declarations
  private String word;
  private List<WordNode> children;

  // Default Constructor
  public WordNode()
  {
    this.word = "";
    this.children = new ArrayList<WordNode>();

  }
  public WordNode(String newWord)
  {
    this.word = newWord;
    this.children = new ArrayList<WordNode>();
  }
  // Creates a new child node containing the new word and adds to the list
  public WordNode addChild(String newWord)
  {
    WordNode child = new WordNode(newWord);
    this.children.add(child);
    return child;
  }
  // checks if the node is a leaf
  public boolean isLeaf()
  {
    return children.isEmpty();
  }
  // returns the word of the WordNode
  public String getWord()
  {
    return this.word;
  }
  // returns the children list
  public List<WordNode> getChildren()
  {
    return this.children;
  }
  // Helper function: finds if a String word is child of current node and
  // returns it
  public WordNode search(String searchWord)
  {
    for(int i = 0; i < children.size(); i++)
    {
      if(children.get(i).getWord().equals(searchWord))
      {
        return children.get(i);
      }
    }
    return this;
  }
}
