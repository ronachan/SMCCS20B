// Name: Rona Chan
// Class Name: CS20B
// Section: 4103
// Professor: Nicolai Kalisch
// Project: 4
import java.util.*;
import java.text.SimpleDateFormat;

public class Test
{
  public static void main(String[]args) throws Exception
  {
    FurnitureBusiness business = new FurnitureBusiness();
    List<Furniture> furnitureList = new ArrayList<Furniture>();
    // Create 3 customers
    Customer c1 = new Customer(123456789, "Jon", new Date(2015,07,28),
      new Address("2365 23rd St", "Apt 2", "Santa Monica", 90405, "California"));
    Customer c2 = new Customer(123456788, "Anna", new Date(2016,05,14),
      new Address("5464 Sunset Park Way", "Apt T", "Santa Monica", 90064, "California"));
    Customer c3 = new Customer(123456787, "David", new Date(2017,06,05),
      new Address("4524 Nasa Cir", null, "Elk Grove", 95757, "California"));

    // Create 5 different furniture objects ( at least 1 of each)
    Sofa sofa = new Sofa("sofa", 100, 250);
    Recliner recliner = new Recliner("recliner", 101, 150);
    Table table = new Table("table", 102, 100);
    Chair chair = new Chair("chair", 103, 50);
    Chair spinChair = new Chair("Gaming Chair", 104, 200);

    // Customer 1's Purchases
    business.purchase(c1, sofa);
    business.purchase(c1, table);
    business.purchase(c1, spinChair);
    business.purchase(c1, sofa);

    // Customer 2's purchase
    business.purchase(c2, chair);

    // Customer 3's purchase
    business.purchase(c3, recliner);

    // Insert all purchases into a list
    furnitureList.add(sofa);
    furnitureList.add(recliner);
    furnitureList.add(table);
    furnitureList.add(chair);
    furnitureList.add(spinChair);

    // For loop to iterate over all three customers
    for(Map.Entry<Customer, List<Furniture>> pair : business.getMap().entrySet())
    {
      Customer c = pair.getKey();

      // Print out Customer attributes
      System.out.println("\nCustomer " +c.toString());
      for(Furniture f : furnitureList)
      {
        // Print out furniture attributes
        System.out.println(f.toString());
        // Use hasBought(..)
        System.out.println("Purchased Previously? " + business.hasBought(c, f));
      }
    }
    // For loop to iterate over each customer
    // getPurchases(..)
    // moneySpent(..)
    for(Map.Entry<Customer, List<Furniture>> pair : business.getMap().entrySet())
    {
      Customer c = pair.getKey();
      System.out.println("\nCustomer " +c.toString());
      System.out.println("Purchases: " + business.getPurchases(c));
      System.out.println("Total Amount Spent: $" + business.moneySpent(c));
      System.out.println(" ");
    }
  }
}
