//Final exam
//Arbitrage
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File f = new File("input.txt");
		List<String> lines = Files.readAllLines(Paths.get("input.txt"));
		int num = Integer.parseInt(lines.get(0));
//		System.out.println(lines.size());
		double [][] myMatrix = new double[num+1][num+1];
		int [][] paths = new int[num+1][num+1];
		textToMatrix(lines, myMatrix, num);
		
		double[][] matrix_OG = new double[num+1][num+1];
		textToMatrix(lines, matrix_OG, num);
		again(num, myMatrix, paths);
//		printMatrix(myMatrix);
		//2 trade -> x^2 = 1.08 -> x = 1.03923. 
		//3.923% profit per trade.
//		for(int i = 1 ; i<=num ; i++)
//		{
//			for(int j = 1;j<=num ;j++)
//			{
//				myMatrix[i][j] = -(Math.log(myMatrix[i][j])/Math.log(2));
//				if(myMatrix[i][j] ==-0)
//					myMatrix[i][j]=0;
//			}
//		}
//		printMatrix(myMatrix);
		
		printMatrix(myMatrix);
		
		
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
				double min = Integer.MAX_VALUE;
				int index = 0;
				for(int h=1; h<=num; h++)
				{
					double temp =  (myMatrix[i][h] + myMatrix[h][j]);
					if(temp<=min)
					{
						min = temp;
						index = h;
						temp_paths[i][j] = index;
						temp_matrix[i][j] = min;
						
//						paths[i][j] = index;
//						myMatrix[i][j] = min;
					}
				}
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
	public static void again(int num, double[][] myMatrix, int[][] paths)
	{
		double[] dist = new double[num+1];
		int[] p = new int[num+1];
		
		for(int i = 0 ;i<num+1;i++)
		{
			dist[i]=Integer.MAX_VALUE;
			p[i]=-1;
		}
		dist[0] = 0;
		for (int k = 1; k < num; k++)  //iterate (vertex-1)
            for (int u = 1; u < num+1; u++) 
                for (int v = 1; v < num+1; v++)
                	relax(u,v,myMatrix, dist,p);
	}
	 private static void relax(int u, int v, double[][] myMatrix , double[] dist, int[] p) {
	        double weight = myMatrix[u][v];
	        if (u == v || weight == -1) return; //no conversion
	        weight = -Math.log(weight);
	        if (dist[v] > dist[u] + weight) {
	            dist[v] = dist[u] + weight;
	            p[v] = u;
	        }
	    }
	public static int find_min(double[] finding_min)
	{
		int index = 1;
		double temp = finding_min[1];
		double adding_all = 0;
		for(int i = 1 ;i<finding_min.length ;i++)
		{
			adding_all =- finding_min[i];
			if(finding_min[i]<=temp)
			{
				temp = finding_min[i];
				index = i;
			}
		}
		//System.out.println("Adding them all up: " + adding_all);
		return index;
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
}
