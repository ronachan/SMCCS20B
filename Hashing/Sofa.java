// Name: Rona Chan
// Class Name: CS20B
// Section: 4103
// Professor: Nicolai Kalisch
// Project: 4
import java.util.*;

public class Sofa implements Furniture
{
  private String name;
  private int modelNr;
  private int price;

  public Sofa(String name1, int modelNr1, int price1)
  {
    this.name = name1;
    this.modelNr = modelNr1;
    this.price = price1;
  }
  // Returns the item name
  public String getName()
  {
    return name;
  }
  // Returns the Model Number
  public int getModelNr()
  {
    return modelNr;
  }
  // Returns the item price
  public int getPrice()
  {
    return price;
  }
  // Exclude price
  @Override
  public int hashCode()
  {
    int result = 31;
    result = 31 * result + ((name == null) ? 0 : name.hashCode());
    result = 31 * result + modelNr;
    return result;
  }
  @Override
  public String toString()
  {
    return "Item: " + this.name + " Model Number: " + this.modelNr + " Price: $" + this.price;
  }
  // Exclude price
  @Override
  public boolean equals(Object obj)
  {
    if(obj instanceof Sofa)
    {
      Sofa s = (Sofa) obj;
      if((this.name.equals(s.name)) && (this.modelNr == s.modelNr))
      {
        return true;
      }
    }
    return false;
  }
}
