// Name: Rona Chan
// Class Name: CS20B
// Section: 4103
// Professor: Nicolai Kalisch
// Project: 4
import java.util.*;

public class Customer
{
  private long id;
  private String name;
  private Date customerSince;
  private Address address;
  //private GregorianCalendar calendar;

  public Customer(long id, String name, Date date, Address address)
  {
    this.id = id;
    this.name = name;
    this.customerSince = date;
    //this.calendar.setTime(date);
    this.address = address;
  }
  @Override
  public String toString()
  {
    return "Name: " + this.name + "\nID Number: " + this.id + "\nCustomer Since: " + this.customerSince
      +"\nAddress: " + this.address;
  }
  // Should include id, name, and address
  @Override
  public int hashCode()
  {
    int result = 31;
    result = 31 * result + ((name == null) ? 0 : name.hashCode());
    result = 31 * result + (int) id;
    result = 31 * result + ((address == null) ? 0: address.hashCode());
    return result;
  }
  // Should include id, name, and address
  @Override
  public boolean equals(Object obj)
  {
    if(obj instanceof Customer)
    {
      Customer c = (Customer) obj;
      if(((this.id >= c.id)) && (this.name.equals(c.name)) && (this.address.equals(c.address)))
      {
        return true;
      }
    }
    return false;
  }
}
