// Name: Rona Chan
// Class Name: CS20B
// Section: 4103
// Professor: Nicolai Kalisch
// Project: 4
import java.util.*;

public class FurnitureBusiness
{
  private HashMap<Customer, List<Furniture>> map;

  public FurnitureBusiness()
  {
    map = new HashMap();
  }
  /**
    * Returns the entire HashMap
    * gives access to map outside of FurnitureBusiness
    */
  public HashMap<Customer, List<Furniture>> getMap()
  {
    return map;
  }
  /**
    * Called when customer purchases new furniture. It tracks the
    * purchsed furniture in the private map. If the customer does not yet exist
    * in the map, put the customer as a key and an empty list as a value. If the
    * customer already exists, get the list for that customer and add the given
    * furniture f to the list.
    */
  public void purchase(Customer c, Furniture f)
  {
      if(map.containsKey(c))
      {
        map.get(c).add(f);
      }
      else
      {
        List<Furniture> furnitureList = new ArrayList<Furniture>();
        map.put(c, furnitureList);
        furnitureList.add(f);
      }
  }
  /**
    * Checks if the given customer has bought the furniture f
    * @return true if customer has bought furniture, false otherwise
    */
  public boolean hasBought(Customer c, Furniture f)
  {
    // does customer exist?
    if(map.containsKey(c))
    {
      //
      if(map.get(c).contains(f))
      {
        return true;
      }
    }
    return false;
  }
  /**
    * Gets the purchased furniture for the given customer
    * @return List of furniture bought by given customer
    */
  public List<Furniture>getPurchases(Customer c)
  {
    // Should it only return the furniture names?
    return map.get(c);
  }
  /**
    * Computes the total money the given customer has spent on furniture
    * @return Total money spent (add the price of each furniture piece bought)
    */
  public int moneySpent(Customer c)
  {
    int eachPrice = 0;
    for(int i=0; i < map.get(c).size(); i++)
    {
      eachPrice += map.get(c).get(i).getPrice();
    }
    return eachPrice;
  }
}
