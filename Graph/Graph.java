// Name: Rona Chan
// Class Name: CS20B
// Section: 4103
// Professor: Nicolai Kalisch
// Project: 5

import java.util.*;

public class Graph
{
  private int[][] matrix;

  public Graph(int[][] adjacencyMatrix)
  {
    this.matrix = adjacencyMatrix;
  }
  /**
    * Checks if an edge exists between two nodes
    * @param from Start node
    * @param to End node
    * @return true if edge exists, false otherwise
    */
  public boolean hasEdge(Integer from, Integer to)
  {
    if(matrix[from][to] != 0)
    {
      return true;
    }
    else
    {
      return false;
    }
  }
  /**
    * Returns the weight of the specified edge
    * @param from Start node
    * @param to End node
    * @return weight if edge exists, 0 otherwise
    */
  public int weight(Integer from, Integer to)
  {
    return matrix[from][to];
  }
  /**
    * Returns a list of outgoing edges that start at the given node
    * @param from Start node
    * @return List of edges (may create edges based on adjacency matrix)
    */
  public List<Edge> getOutgoingEdges(Integer from)
  {
    List<Edge> edgeList = new ArrayList<Edge>();
    for(int i = 0; i < matrix.length; i++)
    {
      if(matrix[from][i]!=0)
      {
        Edge edge = new Edge(from, i, matrix[from][i]);
        edgeList.add(edge);
      }
    }
    return edgeList;
  }
  /**
    * Returns a list of all nodes in the graph
    * @return List of ints that represent the nodes in the graph
    */
  public List<Integer> getNodes()
  {
    List<Integer> nodesList = new ArrayList<Integer>();
    for(int i = 0; i<matrix.length; i++)
    {
      nodesList.add(i);
    }
    return nodesList;
  }
  /**
    * Returns a serialized format of the graph, e.g. the adjacency matrix
    * A matrix consists of [aij] entries, return each and every one in rows
    * @return serialized graph
    */
  public String toString()
  {
    String matrixEntries = "";
    for(int i = 0; i < matrix.length; i++)
    {
      for(int j = 0; j <matrix.length; j++)
      {
        matrixEntries += matrix[i][j];
      }
    }
    return matrixEntries;
  }
}
