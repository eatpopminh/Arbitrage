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
	public static ArrayList<int[]> all_list_of_cycle;
	public static ArrayList<Integer> temp_list_of_cycle;
	public static ArrayList<Integer> profit_per_trade;
	public static int[][] OG_matrix = {		{0,0,0,0,0},
											{0,0,5,2,INF},
											{0,-8,0,1,INF},
											{0,INF,INF,0,-5},
											{0,INF,3,INF,0} };
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		all_path = new ArrayList<int[][]>();
		all_list_of_cycle = new ArrayList<int[]>();
		temp_list_of_cycle = new ArrayList<Integer>();
		profit_per_trade = new ArrayList<Integer>();
		
		
		
		File f = new File("input.txt");
		List<String> lines = Files.readAllLines(Paths.get("input.txt"));
		int num = Integer.parseInt(lines.get(0));
//		System.out.println(lines.size());
		
		double [][] myMatrix = new double[num+1][num+1];
		
		
		textToMatrix(lines, myMatrix, num);
		

		//OG_matrix = new int[num+1][num+1];
		//textToMatrix(lines, OG_matrix, num);
		
		
		//2 trade -> x^2 = 1.08 -> x = 1.03923. 
		//3.923% profit per trade.
		for(int i = 1 ; i<=num ; i++)
			for(int j = 1;j<=num ;j++)
			{	
				myMatrix[i][j] = -Math.log(myMatrix[i][j])/Math.log(2);
				if(myMatrix[i][j] ==-0)
					myMatrix[i][j]=0;
			}


		
		
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
									{0, 0,-.648613, -.327216, .0306045},
									{0,.648614, 0, .321387, .67922},
									{0,.327227, -.321386, 0, .357833},
									{0,-.0305903, -.679217, -.357822, 0}};
		
		//From textBook
		int[][] myMatrix5 =  {		{0,0,0,0,0,0},
									{0,0,3,8,INF,-4},
									{0,INF,0,INF,1,7},
									{0,INF,4,0,INF,INF},
									{0,2,INF,-5,0,INF},	
									{0,INF,INF,INF,6,0}};
		//graph with many negative cycle.
		int[][] myMatrix6 = {	{0,0,0,0,0,0,0,0,0},
								{0,0,4,4,INF,INF,INF,INF,INF},
								{0,INF,0,INF,INF,INF,INF,INF,INF},
								{0,INF,INF,INF,INF,4,-2,INF,INF},
								{0,3,INF,2,0,INF,INF,INF,INF},
								{0,INF,INF,INF,1,0,INF,-2,INF},
								{0,INF,3,INF,INF,-3,0,INF,INF},
								{0,INF,INF,INF,INF,INF,2,0,2},
								{0,INF,INF,INF,INF,-2,INF,INF,0}};
		
		//From lecture but changed to have a negtaive cycle.
		int[][] myMatrix7 =  {		{0,0,0,0,0},
									{0,0,5,2,INF},
									{0,-8,0,1,INF},
									{0,INF,INF,0,-5},
									{0,INF,3,INF,0} };

	
		int[][] temp_matrix = new int[num+1][num+1];
		
		for(int i  = 1 ; i<=num ; i++)
			for(int j = 1 ; j<=num ; j++)
			{
				temp_matrix[i][j] = INF;
				if(i==j)
					temp_matrix[i][j] = 0;
			}
		min_plus_multiplication(4, myMatrix7, temp_matrix);
		//printPaths(1,2,5,num);
		
		
//		double[][] temp_matrix = new double[num+1][num+1];
//		for(int i  = 1 ; i<=num ; i++)
//			for(int j = 1 ; j<=num ; j++)
//			{
//				temp_matrix[i][j] = INF;
//				if(i==j)
//					temp_matrix[i][j] = 0;
//			}
//		min_plus_multiplication(4, myMatrix4, temp_matrix);
		
		
		
		
		
		
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

	public static void min_plus_multiplication(int num, double[][] myMatrix, double[][] temp_matrix)
	{
		
		int steps = 0;
		int[][] paths = new int[num+1][num+1];
		double[][] sol = new double[num+1][num+1];

		for(int g = 1 ; g<=num ; g++)
		{
			for(int i = 1; i<=num; i++) 
			{
				for(int j = 1; j<=num; j++) 
				{
					double current_smallest = INF;
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
			if(sol[g][g]<0)
			{
				steps = g;
				break;
			}
		}
	
		printMatrix(sol);
		printMatrix(paths);
		printPath(3,paths[3][3],steps,num);

	}
	public static void printPath(int start, int end, int steps, int num)
	{
		if(steps<0)//start==end)
			return;
		int last_index = -1;
		int[][] temp_array = new int[num+1][num+1];
		for(int i = 0 ; i<steps ; i++)
		{
			temp_array = all_path.get(i);
			
		}
		System.out.println(temp_array[start][end]);
		
		printPath(start, temp_array[start][end],steps-1, num);
	}
	public static void min_plus_multiplication(int num, int[][] myMatrix,int[][] temp_matrix)
	{
		
		int steps = 0;
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

			
			
			//Detect negative in the diaganol
			for(int w = 1 ; w<=num ;w++)
			{
				if(sol[w][w]<0)
				{
					steps = w;
					System.out.println("HELLO " +w);
					printMatrix(sol);
					for(int i = 0 ; i<all_path.size() ; i++)
					{
						System.out.println("------------------");
						printMatrix(all_path.get(i));
						
					}
					System.out.println("Cycle Length: " + g);
					printPaths(w,paths[w][w],g,num);
					System.out.println("asda"+"/"+paths[w][w]);
					temp_list_of_cycle.add(paths[w][w]);
					
					
					temp_list_of_cycle = new ArrayList<Integer>();
					
				}	
			}
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		}
//		for(int w = 1 ; w<=num ;w++)
//			if(sol[w][w]<0)
//			{
//				steps = w;
//				System.out.println("HELLO " + w);
//				printMatrix(sol);
//				for(int i = 0 ; i<all_path.size() ; i++)
//				{
//					System.out.println("------------------");
//					printMatrix(all_path.get(i));
//				}
//				printPaths(w,paths[w][w],4,num);	
//			}
		
	
//		for(int i = 0 ; i<all_path.size() ; i++)
//		{
//			System.out.println("------------------");
//			printMatrix(all_path.get(i));
//		}
//		printMatrix(sol);
		//printMatrix(paths);
	
	
	}
	public static void printPaths(int start, int end, int steps, int num)
	{
		if(steps<0 )//|| start==end)
		{
			//System.out.println(end);
			return;
		}
		int last_index = -1;
		int[][] temp_array = new int[num+1][num+1];
		for(int i = 0 ; i<steps ; i++)
		{
			temp_array = all_path.get(i);
		}
		System.out.println(start+" / "+temp_array[start][end]);
		temp_list_of_cycle.add(temp_array[start][end]);
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
	
}
