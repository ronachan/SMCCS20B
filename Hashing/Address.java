// Name: Rona Chan
// Class Name: CS20B
// Section: 4103
// Professor: Nicolai Kalisch
// Project: 4
import java.util.*;

public class Address
{
  private String street;
  private String aptNr;
  private String city;
  private int zipCode;
  private String state;

  public Address(String street, String aptNr, String city, int zipCode, String state)
  {
    this.street = street;
    this.aptNr = aptNr;
    this.city = city;
    this.zipCode = zipCode;
    this.state = state;
  }
  @Override
  public String toString()
  {
    return this.street + ", " + this.aptNr + ", " + this.city
      + ", " + this.state + " " + this.zipCode;
  }
  // Should include all address fields
  @Override
  public int hashCode()
  {
    int result = 31;
    result = 31 * result + ((street == null) ? 0 : street.hashCode());
    result = 31 * result + ((aptNr == null) ? 0 : aptNr.hashCode());
    result = 31 * result + ((city == null) ? 0 : city.hashCode());
    result = 31 * result + zipCode;
    result = 31 * result + ((state == null) ? 0 : state.hashCode());
    return result;
  }
  // Should include all address fields
  @Override
  public boolean equals(Object obj)
  {
    if(obj instanceof Address)
    {
      Address address = (Address) obj;
      if((this.street.equals(address.street)) && (this.aptNr.equals(address.aptNr)) && (this.city.equals(address.city))
        && (this.zipCode == address.zipCode) && (this.state.equals(address.state)))
        {
          return true;
        }
    }
    return false;
  }
}
