// Name: Rona Chan
// Class Name: CS20B
// Section: 4103
// Professor: Nicolai Kalisch
// Project: 4
import java.util.*;

public class Table implements Furniture
{
  private String name;
  private int modelNr;
  private int price;

  public Table(String name1, int modelNr1, int price1)
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
  // REturns the item price
  public int getPrice()
  {
    return price;
  }
  // Returns the model number
  public int getModelNr()
  {
    return modelNr;
  }
  @Override
  public String toString()
  {
    return "Item: " + this.name + " Model Number: " + this.modelNr + " Price: $" + this.price;
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
  // Exclude price
  @Override
  public boolean equals(Object obj)
  {
    if(obj instanceof Table)
    {
      Table t = (Table) obj;
      if((this.name.equals(t.name)) && (this.modelNr == t.modelNr))
      {
        return true;
      }
    }
    return false;
  }
}
