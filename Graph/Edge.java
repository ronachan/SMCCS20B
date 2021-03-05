// Name: Rona Chan
// Class Name: CS20B
// Section: 4103
// Professor: Nicolai Kalisch
// Project: 5

import java.util.*;
import java.lang.Comparable;

public class Edge implements Comparable<Edge>
{
  Integer from;
  Integer to;
  int weight;

  public Edge(Integer from, Integer to, int weight)
  {
    this.from = from;
    this.to = to;
    this.weight = weight;
  }
  public Integer getFrom()
  {
    return from;
  }
  public Integer getTo()
  {
    return to;
  }
  public int getWeight()
  {
    return weight;
  }
  public int hashCode()
  {
    int result = 31;
    result = 31 * result + to;
    result = 31 * result + from;
    result = 31 * result + weight;
    return result;
  }
  // REMEMBER TO CHECK FOR NULL U DUMBASS
  public boolean equals(Object obj)
  {
    if(obj instanceof Edge)
    {
      Edge edge = (Edge) obj;
      if((this.from.equals(edge.from)) && (this.to.equals(edge.to)) && (this.weight == edge.weight))
      {
        return true;
      }
      if(edge.equals(null))
      {
        return false;
      }
    }
    return false;
  }
  @Override
  public int compareTo(Edge edge)
  {
    if(this.weight < edge.weight)
    {
      return -1;
    }
    if(this.weight == edge.weight)
    {
      return 0;
    }
    else
    {
      return 1;
    }
  }
  public String toString()
  {
    return "From: " + this.from + " To: " + this.to + " Weight: " + this.weight;
  }

}
