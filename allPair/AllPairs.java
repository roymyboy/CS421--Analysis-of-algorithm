/**
 * The program implements two algorithm to solve the all-pairs, shortest-path problem for sirect graphs,
 * The program uses the SLOW-ALL-PAIRS-SHORTEST-PATHS and FASTER-ALL-PAIRS-SHORTEST-PATHS algorithm.
 * @author Utsav Roy
 */ 

import java.io.*;
import java.util.*;

public class AllPairs {

	/*boolean to keep track of NULL negative cycle*/
	private static boolean isNegative = false; 
	
	/**
 	* function to print out usage message if enough argument in not passed in to the command line
 	* @return void
 	*/  
	private static void usage(){
		System.out.println("AllPairs <file name>");
	}

	/**
 	* function to find the shortest path from the final matrix
 	* @param W, final table
 	* @return shortest, shortest path of the graph 
 	*/
	private static int searchSortestPath(int [][] W) {
		int shortest = 0;

		for (int i = 0; i < W.length; i++) {
			for (int j = 0; j < W.length; j++) {
				if ( i == j && W[i][j] != 0) {
					isNegative = true;
					break;
				}
				if (W[i][j] < shortest) {
					shortest = W[i][j];
				}
			}
		}
	return shortest;
	}

	/**
 	* function to compute the shortest-path weights by extending shortest path edge 
 	* by edge
 	* @param W, is the matrix containing input
 	* @return list has the shortest-path weights 
 	*/ 
	private static int[][] SlowAllPairsShortestPaths(int[][] W) {
		int n = W.length;
		int [][] list = W;
	
		for(int m = 1; m < n-1; m++){
			list = ExtendShortestPaths(list, W);
			
		}
		return list; 
	}

	/**
	 * function to compute the shortest-path but with a better run time than that of 
	 * slow_all_pair_shortest_path
	 * @param W, is the matrix containing input
	 * @return list has the shortest-path weights
	 */
	private static int[][] FasterAllPairsShortestPaths(int[][] W) {
		int n = W.length;
		int [][] list = W;
		int m = 1;

		while (m < n-1){
			list = ExtendShortestPaths(list, list);
			m = 2 * m;
		}
		return list;
	}

	/**
 	* function which is extended by all-pair-shortest-path that computes all the
 	* series of matrices and contains the actual shortest-path  	 
 	* @param L the given matrix 
 	* @param W given inout matrix
 	* @return lp, the final matrix that contains the actual shortest path weights 
 	*/
	private static int[][] ExtendShortestPaths(int[][] L, int[][] W) {
		int n = L.length;
		int lP[][] = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				lP[i][j] = Integer.MAX_VALUE;
				for (int k = 0; k < n; k++) {
					int total = 0;
					if(L[i][k] == Integer.MAX_VALUE || W[k][j] == Integer.MAX_VALUE){
						total = Integer.MAX_VALUE;
					} else {
						total = L[i][k] + W[k][j];
					}
					lP[i][j] = Math.min(lP[i][j], total);
				}
			}
		}
		return lP;
	}

	/**
 	* function to print out the final result of the computed shortest path with its runtime
	* @param grapgh  
	* @return void 
 	*/  
	public static void printResult(int graph[][]){
             System.out.println("Running slow all pairs...");
             long runTime = System.currentTimeMillis();
             SlowAllPairsShortestPaths(graph);
             System.out.println("     ...time: " + ((System.currentTimeMillis() - runTime)) + " milliseconds.");
             System.out.println("Running faster all pairs...");
             runTime = System.currentTimeMillis();
             int [][]finalTableFaster = FasterAllPairsShortestPaths(graph);
             System.out.println("     ...time: " + ((System.currentTimeMillis() - runTime)) + " milliseconds.");
             int shortestPath = searchSortestPath(finalTableFaster);
             if (isNegative) {
                 System.out.println("shortest path: NULL");
             } else {
                 System.out.println("shortest path: " + shortestPath);
             }

	}

	/**
 	* function to scan the given matrix as an input
 	* @param args command line argument
 	* @return void
 	*/ 
	public static void scanAndPrint(String[] args) throws FileNotFoundException {
	 if (args.length != 1) {
             usage();
         } else {
             Scanner scan = new Scanner(new File(args[0]));
             int v = scan.nextInt();
             int e = scan.nextInt();
             int graph[][] = new int[v][e];
             for (int i = 0; i<graph.length; i++){
                 for(int j = 0; j < graph.length; j++){
                     graph[i][j] = Integer.MAX_VALUE;
                 }
             }
             
             while(scan.hasNext()){
                 int end = scan.nextInt();
                 int top = scan.nextInt();
                 int weight = scan.nextInt();
                 graph[end][top] = weight;
             }
             
             for(int i = 0; i < v; i ++){
                 graph[i][i] = 0; 

			}
             scan.close();
             printResult(graph);
		}
	}
	
	/**! \brief 
 	* main 
 	*/  
	public static void main(String[] args) throws FileNotFoundException {	
		scanAndPrint(args); //Scan, read, analyze and print the result
	}
}
