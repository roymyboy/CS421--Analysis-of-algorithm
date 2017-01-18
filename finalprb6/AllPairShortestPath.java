import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*; 
 
class AllPairShortestPath
{
    final static double INF = 99999; 
	final static int V = 11; 
	int U = 11;
    void floydWarshall(double graph[][])
    {
        double dist[][] = new double[V][V];
        int i, j, k;
        for (i = 0; i < V; i++)
            for (j = 0; j < V; j++)
                dist[i][j] = graph[i][j];
        for (k = 0; k < U; k++)
        {
            for (i = 0; i < V; i++)
            {
                for (j = 0; j < V; j++)
                {
                    if (dist[i][k] + dist[k][j] < dist[i][j])
                        dist[i][j] = dist[i][k] + dist[k][j];
                }
            }
        }
      printSolution(dist);
    }
 
    void printSolution(double dist[][])
    {
        System.out.println("D("+ U +")");
        for (int i=0; i<V; ++i)
        {
            for (int j=0; j<V; ++j)
            {
                if (dist[i][j]==INF)
                    System.out.print("INF ");
                else
                    System.out.print(round(dist[i][j], 1) +" ");
            }
            System.out.println();
        }
    }
 
   public static void main (String[] args)
    {
		double graph[][] = {
	    {0,   3.3, INF, INF, INF, INF, INF, INF,INF,INF,2.3},
    	{3.3, 0,  1.5,INF, INF, INF, INF, 2.4, 6.0, INF,INF},
     	{INF, 1.5, 0,   3.5, INF, INF, INF, 3.0,INF, INF,INF},
   	    {INF, INF, 3.5, 0,   2.4, 6.4, 4.5, INF,INF, INF,INF},
        {INF, INF, INF, 2.4, 0,   4.4, INF, INF,INF, INF,INF},
        {INF, INF, INF, 6.4, 4.4, 0,   INF, INF,INF, INF, INF},
        {INF, INF, INF, 4.5, INF, INF, 0,   2.4,INF, INF, INF},
        {INF, 4.0, 3.0, INF, INF, INF, 2.4, 0,  INF, INF, INF},
        {INF, 6.0, INF, INF, INF, INF, INF, INF,0,   4.0, INF},
        {INF, INF, INF, INF, INF, INF, INF, INF,4.0, 0,   1.2},
        {2.3,INF,INF,INF,INF,INF,INF,INF,INF,1.2,0}
		};     
        AllPairShortestPath a = new AllPairShortestPath();
 
         a.floydWarshall(graph);
    }

	public static double round(double value, int places) {
    	if (places < 0) throw new IllegalArgumentException();

    	BigDecimal bd = new BigDecimal(value);
    	bd = bd.setScale(places, RoundingMode.HALF_UP);
    	return bd.doubleValue();
	}

}
