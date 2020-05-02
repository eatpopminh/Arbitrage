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

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File f = new File("input.txt");
		List<String> lines = Files.readAllLines(Paths.get("input.txt"));
		int num = Integer.parseInt(lines.get(0));
//		System.out.println(lines.size());
		
		double [][] myMatrix = new double[num][num];
		int [][] paths = new int[num+1][num+1];
		
		textToMatrix2(lines, myMatrix, num);
		
//		double[][] matrix_OG = new double[num+1][num+1];
//		textToMatrix(lines, matrix_OG, num);
		
//		printMatrix(myMatrix);
		//2 trade -> x^2 = 1.08 -> x = 1.03923. 
		//3.923% profit per trade.
		for(int i = 0 ; i<num ; i++)
		{
			for(int j = 0;j<num ;j++)
			{
				myMatrix[i][j] = -Math.log(myMatrix[i][j])/Math.log(2);
				if(myMatrix[i][j] ==-0)
					myMatrix[i][j]=0;
			}
		}
		//printMatrix(myMatrix);
		
		FloydWarshell(myMatrix, num);
		
		double[] distance = new double[num];
		int[] path = new int[num]; 
		
		//FloydWarshell(myMatrix, 300);
		//System.out.println(cycleList.size());
		//printMatrix(myMatrix);
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

//	public static double[][] extend_shortest_path(double[][] w)
//	{
//		int n = w.length;
//		double[][] l = new double[n][n];
//		for(int i = 0 ; i < n ; i++)
//		{
//			for(int j = 0 ; j < n ; j++)
//			{
//				l[i][j] = Integer.MAX_VALUE;
//				for(int k = 0 ; k < n ; k++)
//				{
//					l[i][j] = Math.min(l[i][j], l[i][k] + w[k][j]);
//				}
//			}
//		}
//		return l;
//	}
	public static int min_from_colunm(int num, int[][] paths, ArrayList<Double> my_cycle_prices, double[][] matrix_OG)
	{
		
		int temp = Integer.MAX_VALUE;
		int index_of_min = 0;
		for(int i = 0 ; i<paths.length ; i++)
		{
			if(paths[i][num] < temp)
			{
				temp = paths[i][num];
				index_of_min = i;
			}
		}
		//my_cycle_prices.add(matrix_OG[index_of_min][num]);
		//System.out.println(temp);
		return temp;

		
	}
	public static void min_plus_multiplication(int num, double[][] myMatrix, int[][] paths)
	{
		double[][] temp_matrix = new double[num+1][num+1];
		int[][] temp_paths = new int[num+1][num+1];
		for(int i = 1; i<=num; i++) //1
		{
			//gets me the whole row
			for(int j = 1; j<=num; j++) //1,2
			{
//				double min = Integer.MAX_VALUE;
//				int index = 0;
				double[] array = new double[num+1];
				fill_array(array);
				for(int h=1; h<=num; h++)
				{
					double temp =  (myMatrix[i][h] + myMatrix[h][j]);
					array[h] = temp;
//					if(temp<=min)
//					{
//						min = temp;
//						index = h;
//						temp_paths[i][j] = index;
//						temp_matrix[i][j] = min;
//						
////						paths[i][j] = index;
////						myMatrix[i][j] = min;
//					}
				}
				//find_the_min(array, temp_matrix, temp_paths,i,j);
				
			}
		}
		for(int i = 1;i<=num;i++)
		{
			for(int j = 1;j<=num;j++)
			{
				myMatrix[i][j] = temp_matrix[i][j];
				paths[i][j] = temp_paths[i][j];
			}
		}
		
	}
	public static void fill_array(double[] array)
	{
		for(int i = 0;i<=array.length;i++)
		{
			array[i] = Integer.MAX_VALUE;
		}
	}
//	public static void find_the_min(double[] array, double[][] temp_matrix, int[][] paths, int i, int j)
//	{
//		double current_min = Integer.MAX_VALUE;
//		for(int g = 0 ; g<array.length ; g++)
//		{
//			if(array[g]<=)
//			
//		}
//	}
	
	
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
