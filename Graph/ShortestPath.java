// Name: Rona Chan
// Class Name: CS20B
// Section: 4103
// Professor: Nicolai Kalisch
// Project: 5

import java.util.*;

public class ShortestPath
{
  public int totalWeightSP(Graph graph, int from, int to)
  {
    // set as super big number --> infinite
    int min = Integer.MAX_VALUE;
    int graphSize = graph.getNodes().size();
    int dist[] = new int[graphSize];

    for(int i = 0; i < dist.length; i++)
    {
      // Set as infinity
      dist[i] = min;
      // The starting node always has a distance of 0
      dist[from] = 0;
    }
    // Helps to track edges by comparing the edges' weights
    Comparator<Integer> compareEdges = new Comparator<Integer>()
    {
      public int compare(Integer u, Integer v)
      {
        if(dist[u] < dist[v])
        {
          return -1;
        }
        else if(dist[u] == dist[v])
        {
          return 0;
        }
        else
        {
          return 1;
        }
      }
    };
    PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>(compareEdges);

    for(int i = 0; i < dist.length; i++)
    {
      pQueue.add(i);
    }

    while(!pQueue.isEmpty())
    {
      int n = pQueue.remove();
      // Create a new list of edges
      List<Edge> edgeList = graph.getOutgoingEdges(n);
      // Checks every edge in edgeList
      for(Edge edge : edgeList)
      {
        // Checks for the existence of To edge
        if(pQueue.contains(edge.getTo()))
        {
          // Compare and update the shortest distance
          if(dist[n] + edge.getWeight() < dist[edge.getTo()])
          {
            dist[edge.getTo()] = dist[n] + edge.getWeight();
          }
          // Remove and update the shortest edge back into PQueue
          pQueue.remove(edge.getTo());
          pQueue.add(edge.getTo());
        }
      }
    }
    return dist[to];
  }

  public static void main(String[]args)
  {
    int matrix[][] =
                    {{0, 5, 2, 0, 0, 0, 0},
                     {5, 0, 0, 1, 0, 0, 0},
                     {2, 0, 0, 2, 0, 0, 8},
                     {0, 1, 2, 0, 2, 1, 0},
                     {0, 0, 0, 2, 0, 0, 3},
                     {0, 0, 0, 1, 0, 0, 0},
                     {0, 0, 8, 0, 3, 0, 0}};
    Graph graph = new Graph(matrix);
    ShortestPath sp = new ShortestPath();
    System.out.println("Shortest Distance/Path " +sp.totalWeightSP(graph,0,graph.getNodes().size()-1));
    for(int i = 0; i < graph.getNodes().size()-1; i++)
    {
      System.out.println(graph.getOutgoingEdges(i));
    }
    System.out.println("Graph: " +graph.toString());
    System.out.println("Graph's Nodes: " +graph.getNodes());
  }
}
