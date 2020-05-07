//Final exam
//Arbitrage
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import javax.swing.text.html.HTMLDocument.Iterator;

public class main {
	final static int INF = Integer.MAX_VALUE;
	
	public static ArrayList<int[][]> all_path;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		all_path = new ArrayList<int[][]>();
		
		File f = new File("input.txt");
		List<String> lines = Files.readAllLines(Paths.get("input.txt"));
		int num = Integer.parseInt(lines.get(0));
//		System.out.println(lines.size());
		
		double [][] myMatrix = new double[num+1][num+1];
		
		
		textToMatrix(lines, myMatrix, num);
		
//		double[][] matrix_OG = new double[num+1][num+1];
//		textToMatrix(lines, matrix_OG, num);
		

		//2 trade -> x^2 = 1.08 -> x = 1.03923. 
		//3.923% profit per trade.
//		for(int i = 1 ; i<=num ; i++)
//			for(int j = 1;j<=num ;j++)
//			{	
//				myMatrix[i][j] = -Math.log(myMatrix[i][j])/Math.log(2);
//				if(myMatrix[i][j] ==-0)
//					myMatrix[i][j]=0;
//			}

		//min_plus_multiplication(num, myMatrix);
		
		
		//From lecture
		int[][] myMatrix2 =  {				{0,0,0,0,0},
											{0,0,5,9,INF},
											{0,INF,0,1,INF},
											{0,INF,INF,0,2},
											{0,INF,3,INF,0} };
		//Negative CYCLE
		int[][] myMatrix3 =  {		{0,0,0,0,0},
									{0,0,4,INF,5},
									{0,INF,0,INF,5},
									{0,INF,-10,0,INF},	
									{0,INF,INF,3,0}};

		double[][] myMatrix4 = {	{0,0,0,0,0},
									{0,1.0, 1.56766, 1.25459, 0.979015}, 
									{0,0.637893, 1.0, 0.8003, 0.624503 },
									{0,0.797067, 1.24953, 1.0, 0.780336 },
									{0,1.02143, 1.60127, 1.28149, 1.0 }};
		
		//From textBook
		int[][] myMatrix5 =  {		{0,0,0,0,0,0},
									{0,0,3,8,INF,-4},
									{0,INF,0,INF,1,7},
									{0,INF,4,0,INF,INF},
									{0,2,INF,-5,0,INF},	
									{0,INF,INF,INF,6,0}};
	
		int[][] temp_matrix = new int[num+1][num+1];
		
		for(int i  = 1 ; i<=num ; i++)
			for(int j = 1 ; j<=num ; j++)
			{
				temp_matrix[i][j] = INF;
				if(i==j)
					temp_matrix[i][j] = 0;
			}
		min_plus_multiplication(5, myMatrix5, temp_matrix);
		printPaths(1,2,5,num);
//		printMatrix(temp_matrix);
//		for(int i = 2 ; i<=num+1 ; i++)
//			temp_matrix = min_plus_multiplication(4, myMatrix2, temp_matrix);
//		printMatrix(temp_matrix);
		//FloydWarshell(myMatrix3, 4);
//		if(myMatrix2[1][4]==INF)
//		{
//			System.out.println("INF");
//		}
//		if(4<=INF)
//			System.out.println("WTF");
//		int[][] paths = new int[5][5];
//		int[][] temp_matrix = {		{0,0,0,0,0},
//									{0,0,5,9,INF},
//									{0,INF,0,1,INF},
//									{0,INF,INF,0,2},
//									{0,INF,3,INF,0} };
		
//		for(int i = 1;i<=4;i++)
//		{
//			for(int j = 1;j<=4;j++)
//			{
//				temp_matrix[i][j] = INF;
//				for(int k = 1 ; k<=4;k++)
//				{
//					if((temp_matrix[i][k] != INF && temp_matrix[k][j] != INF) &&
//							(myMatrix[i][k] != INF && myMatrix[k][j] != INF))
//					temp_matrix[i][j] = Math.min(temp_matrix[i][j], myMatrix2[i][k] + temp_matrix[k][j]);
//				}
//			}
//			printMatrix(temp_matrix);
//		}

		
//		boolean flag = true;
//		int count = 1;
//		while(flag)
//		{
//			count++;
//			double[][] temp = myMatrix;
//			min_plus_multiplication(num, myMatrix, paths);
//			if(Arrays.equals(temp, myMatrix));
//			{
//				flag = false;
//			}
//		}
//		System.out.println(count);
//		boolean flag = true;
//		while(flag)
//		{
//			min_plus_multiplication(num, myMatrix, paths);
//			
//			int temp = Integer.MAX_VALUE;
//			for(int i = 0 ;i<300 ; i++)
//			{
//				Math.min(temp,paths[i][112]);
//			}
//			if(temp==265)
//			{
//				flag=false;
//				System.out.println("done");
//			}
//		}
//		min_plus_multiplication(num, myMatrix, paths);
//		
//		//again(num,myMatrix,paths);
//		
////		for(int i = 0 ;i<150 ; i++)
////		{
////			min_plus_multiplication(num, myMatrix,  paths);
////		}
//		System.out.println("min-plus mul");
//
//		
//		System.out.println("-------------------------------");
//		printMatrix(myMatrix);
//		printMatrix(paths);
//		System.out.println("-------------------------------");
//		
////		for(int i = 1 ;i<=num ; i++)
////		{
////			System.out.println(myMatrix[i][i] + " " + paths[i][i]);
////		}
//
//		for(int i = 1 ;i<=num;i++)
//		{
//			System.out.println(paths[i][112]);
//		}
//		//System.out.println("for real"+temp12);
//		
//		ArrayList<Double> my_cycle_prices = new ArrayList<Double>();
//		ArrayList<Integer> my_cycle_paths = new ArrayList<Integer>();
//		int diagonal_index = 0;
//		for(int i = 0 ; i <5 ; i++)
//		{
//			if(myMatrix[i][diagonal_index]<0)
//			{
//				my_cycle_prices.add(matrix_OG[i][diagonal_index]);
//				my_cycle_paths.add(diagonal_index+2);
//				
//				
//				int temp = diagonal_index+2;
//				do
//				{
////					System.out.println(diagonal_index+2);
////					System.out.println(paths[i-1][diagonal_index]);
//				
//					temp = min_from_colunm(temp, paths, my_cycle_prices, matrix_OG);
//					my_cycle_paths.add(temp);
//					
//					System.out.println(temp);
////					System.out.println(myMatrix[i][diagonal_index] + " " + paths[i-1][diagonal_index] + 
////							" OG Matrix: "+ matrix_OG[i][diagonal_index]);
//					//min_from_colunm(matrix_OG, paths, diagonal_index+2);
//					
//				}
//				while(temp!=diagonal_index+2);
//				
//				
//			}
//			
//			diagonal_index++;
//		}
//		double[][] temp = extend_shortest_path(myMatrix);
//		printMatrix(temp);
		
//			int[] temp_array = new int[] {6,112,0,0,0,0,0,0};
//			System.out.println("my Path from 6->: " + (paths[3][4]));
//			System.out.println("get OG number from 6->: " + myMatrix[4][4]);
//			
//			int temp2 = Integer.MAX_VALUE;
//			for(int i = 1 ; i<num ; i++)
//			{
//				System.out.println(paths[i-1][temp_array[1]]);
//				if(paths[i][temp_array[1]] <= temp2)
//				{
//					
//					temp2 = paths[i-1][temp_array[1]];
//					temp_array[2] = temp2;
//				}
//				
//			}
//			System.out.println(temp_array[0]);
//			System.out.println(temp_array[1]);
//			System.out.println(temp_array[2]);
			
			
			
			
			
	}
	public static void FloydWarshell(int[][] adjMatrix, int N)
	{
		// cost[] and parent[] stores shortest-path
		// (shortest-cost/shortest route) information
		int[][] cost = new int[N+1][N+1];
		int[][] path = new int[N+1][N+1];

		// initialize cost[] and parent[]
		for (int u = 1; u <= N; u++)
		{
			for (int v = 1; v <= N; v++)
			{
				// initally cost would be same as weight
				// of the edge
				cost[u][v] = adjMatrix[u][v];
				path[u][v] = v;
				
				cost[v][v] = 0;
				path[v][v] = v;
//				if (v == u)
//					path[v][v] = 0;
//				else if (cost[v][u] != Integer.MAX_VALUE)
//					path[u][v] = v;
//				else
//					path[v][u] = -1;
			}
		}

		// run Floyd-Warshell
		for (int k = 1; k <= N; k++)
			for (int u = 1; u <= N; u++)
			{
				for (int v = 1; v <= N; v++)
				{
					// If vertex k is on the shortest path from v to u,
					// then update the value of cost[v][u], path[v][u]

					if (cost[u][k] != INF && cost[k][v] != INF
							&& (cost[u][k] + cost[k][v] < cost[u][v]))
					{
						cost[u][v] = cost[u][k] + cost[k][v];
						path[u][v] = path[u][k];
					}
				}

				// if diagonal elements become negative, the
				// graph contains a negative weight cycle
//				if (cost[k][k] < 0)
//				{
//					System.out.println("Negative Weight Cycle Found!!");
//					printMatrix(cost);
//					System.out.println("------------------------------");
//					printMatrix(path);
//					return;
//				}
			}
		printMatrix(cost);
		System.out.println("------------------------------");
		printMatrix(path);
		// Print the shortest path between all pairs of vertices
		//printSolution(cost, path, N);
	}

	

	public static void ISS(double[][] myMatrix, int num)
	{
		double[] dist = new double[num+1];
		int[] p = new int[num+1];
		
	
		for(int j  = 1 ; j<=num;j++)
		{
			dist[j] = INF;
			p[j] = -1;
		}
		dist[0] = 0;
		
		for(int i = 1; i<num; i++) //1
		{
			for(int j = 1; j<=num; j++) //1,2
			{
				for(int k = 1; k<=num; k++)
				{
					if(dist[k] > dist[j] + myMatrix[j][k])
					{
						dist[k] = dist[j] + myMatrix[j][k];
						p[k] = j;
					}
					
				}
			}
		}
		
		for(int j = 1; j<=num; j++) //1
		{
			for(int k = 1; k<=num; k++) //1,2
			{
				if(dist[k] < dist[j] + myMatrix[j][k])
				{
					dist[k] = -INF;
					System.out.println("NC");
//					for(int i = 1; i<=num;i++)
//					{
//						System.out.println(p[i]);
//					}
					//return;
				}
			}
		}
		
		for(int i  = 1 ; i<=num ; i++)
		{
			if(dist[i] == -INF)
			{
				backtrack(i,p,dist);
			}
		}
		// printMatrix(dist);
		 System.out.println("DONE");
	}
	public static void backtrack(int i, int[] path, double[] dist)
	{
		if(path[i]!=-1 && dist[i]!=-INF)
		{
			dist[path[i]] = -INF;
			backtrack(path[i],path,dist);
		}
		else 
			return;
	}

	public static void min_plus_multiplication(int num, double[][] myMatrix)
	{
		double[][] temp_matrix = new double[num+1][num+1];
		int[][] temp_paths = new int[num+1][num+1];
		
		for(int i = 1 ; i<num ; i++)
			for(int j = 1 ; j<=num ; j++)
			temp_matrix[i][j] = myMatrix[i][j];
		
		for(int i = 1; i<=num; i++) //1
		{
			for(int j = 1; j<=num; j++) //1,2
			{
				double current_smallest = Double.MAX_VALUE;
				for(int k = 1; k<=num; k++)
				{
					if(temp_matrix[i][k] + myMatrix[k][j] <= current_smallest)
					{
						current_smallest = temp_matrix[i][k] + myMatrix[k][j];
						
						temp_matrix[i][j] = current_smallest;
						temp_paths[i][j] = k;
					}
					
				}
			}
		}
	
//		printMatrix(temp_matrix);
//		printMatrix(temp_paths);
		System.out.println(temp_paths[5][5]);
		System.out.println(temp_paths[5][217]);
		System.out.println(temp_paths[5][241]);
		System.out.println(temp_paths[5][281]);
		System.out.println(temp_paths[5][284]);
		System.out.println(temp_paths[5][299]);
		System.out.println(temp_paths[5][19]);
		System.out.println(temp_paths[5][270]);
		System.out.println(temp_paths[5][284]);

	}
	public static void min_plus_multiplication(int num, int[][] myMatrix,int[][] temp_matrix)
	{
		
		
		int[][] paths = new int[num+1][num+1];
		int[][] sol = new int[num+1][num+1];

		for(int g = 1 ; g<=num ; g++)
		{
			for(int i = 1; i<=num; i++) 
			{
				for(int j = 1; j<=num; j++) 
				{
					int current_smallest = INF;
					for(int k = 1; k<=num; k++)
					{
						if((myMatrix[k][j]!=INF && myMatrix[k][j]!=INF) && 
								(temp_matrix[i][k]!=INF && temp_matrix[i][k]!=INF) &&
								temp_matrix[i][k] + myMatrix[k][j] <= current_smallest)
						{
							current_smallest = temp_matrix[i][k] + myMatrix[k][j];
							sol[i][j] =  current_smallest;
							paths[i][j] = k;
							
						}
					}
					if(sol[i][j]==0 && i!=j)
						sol[i][j] = INF;
				}	
			}
			int[][] temp_to_add_allpath = new int[num+1][num+1];
			for(int a = 1 ; a<=num ; a++)
				for(int b = 1 ; b<=num ; b++)
					temp_to_add_allpath[a][b] = paths[a][b];
			all_path.add(temp_to_add_allpath);
			
			//Move sol to temp_matrix
			for(int a = 1 ; a<=num ; a++)
				for(int b = 1 ; b<=num ; b++)
				temp_matrix[a][b] = sol[a][b];
		}
	
		//printMatrix(sol);
		for(int i = 0 ; i<all_path.size() ; i++)
		{
			System.out.println("------------------");
			printMatrix(all_path.get(i));
		}
	
	
	}
	public static void printPaths(int start, int end, int steps, int num)
	{
		if(start==end || steps<0)
			return;
		int last_index = -1;
		int[][] temp_array = new int[num+1][num+1];
		for(int i = 0 ; i<steps ; i++)
		{
			temp_array = all_path.get(i);
			
		}
		System.out.println(temp_array[start][end]);
		printPaths(start, temp_array[start][end], steps-1, num);
	}
	

	public static void printMatrix(double matrix[][])
	{
		//start at i=1 if you dont want to see the zerosssss.
		for(int i = 0 ; i< matrix.length ; i++)
		{
			for(int j = 0 ; j <matrix[i].length ;j++)
			{
				System.out.print(matrix[i][j]);
				System.out.print(" , ");
			}
			System.out.println();
		}
	}
	public static void printMatrix(int matrix[][])
	{
		for(int i = 0 ; i< matrix.length ; i++)
		{
			for(int j = 0 ; j <matrix[i].length ;j++)
			{
				System.out.print(matrix[i][j]);
				System.out.print(" , ");
			}
			System.out.println();
		}
	}
	public static void textToMatrix(List<String> lines, double matrix[][], int num)
	{
		int h = 1, k = 1;
		String temp = "";
		
		for(int i = 1;i<num+1;i++)
		{
			for(int j = 0; j<lines.get(i).length() ;j++)
			{
				if(lines.get(i).toCharArray()[j]==' ')
				{
					matrix[h][k] = Double.parseDouble(temp.trim());
					k++;
					temp = "";
				}
				else
				{
					temp += lines.get(i).toCharArray()[j];
				}
			}
			k=1;
			h++;
		}
	}
	public static void textToMatrix2(List<String> lines, double matrix[][], int num)
	{
		int h = 0, k = 0;
		String temp = "";
		
		for(int i = 1;i<num+1;i++)
		{
			for(int j = 0; j<lines.get(i).length() ;j++)
			{
				if(lines.get(i).toCharArray()[j]==' ')
				{
					matrix[h][k] = Double.parseDouble(temp.trim());
					k++;
					temp = "";
				}
				else
				{
					temp += lines.get(i).toCharArray()[j];
				}
			}
			k=0;
			h++;
		}
	}
	public static void FloydWarshell(double[][] adjMatrix, int N)
	{
		// cost[] and parent[] stores shortest-path
		// (shortest-cost/shortest route) information
		double[][] cost = new double[N][N];
		int[][] path = new int[N][N];

		// initialize cost[] and parent[]
		for (int v = 0; v < N; v++)
		{
			for (int u = 0; u < N; u++)
			{
				// initally cost would be same as weight
				// of the edge
				cost[v][u] = adjMatrix[v][u];

				if (v == u)
					path[v][u] = 0;
				else if (cost[v][u] != Integer.MAX_VALUE)
					path[v][u] = v;
				else
					path[v][u] = -1;
			}
		}
	
		// run Floyd-Warshell
		for (int k = 0; k < 4; k++)
		{
			for (int v = 0; v < N; v++)
			{
				for (int u = 0; u < N; u++)
				{
					// If vertex k is on the shortest path from v to u,
					// then update the value of cost[v][u], path[v][u]

					if (cost[v][k] != Integer.MAX_VALUE && cost[k][u] != Integer.MAX_VALUE && (cost[v][k] + cost[k][u] < cost[v][u]))
					{
						cost[v][u] = cost[v][k] + cost[k][u];
						path[v][u] = path[k][u];
					}
				}
				
				if(cost[v][v]<0)
				{
					for(int c = 0 ; c<N ; c++)
					{
					
						System.out.println(cost[c][c] + " / "+ c + " -> " + cost[c][c]);
		
					}
				}
				// if diagonal elements become negative, the
				// graph contains a negative weight cycle
//				if (cost[v][v] < 0)
//				{
//					System.out.println("Negative Weight Cycle Found!! index is at: " + v + " " + path[v][v]);
//					printSolution(cost, path, N);
//					
//					System.out.println(cost[v][v]);
//					
//					return;
//				}
			}
		}
		
		// Print the shortest path between all pairs of vertices
		printSolution(cost, path, N);
	}

	// Function to print the shortest cost with path
	// information between all pairs of vertices
	private static void printSolution(double[][] cost, int[][] path, int N)
	{
//		for (int v = 0; v < N; v++)
//		{
//			for (int u = 0; u < N; u++)
//			{
//				System.out.print(path[v][u]);
//				System.out.print(" ");
//			}
//			System.out.println();
//		}
		for (int v = 0; v < N; v++)
		{
			for (int u = 0; u < N; u++)
			{
				System.out.print(cost[v][u]);
				System.out.print(" ");
			}
			System.out.println();
		}
		
		for (int v = 0; v < N; v++)
		{
			for (int u = 0; u < N; u++)
			{
				if (u != v && path[v][u] != -1)
				{
					System.out.print("Shortest Path from vertex " + v +
							" to vertex " + u + " is (" + v + " ");
					printPath(path, v, u);
					System.out.println(u + ")");
				}
			}
		}
	}
	private static void printPath(int[][] path, int v, int u)
	{
		if (path[v][u] == v)
			return;

		printPath(path, v, path[v][u]);
		System.out.print(path[v][u] + " ");
	}
}
