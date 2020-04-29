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
		double [][] myMatrix = new double[num][num];
		int [][] paths = new int[num][num];
		
		textToMatrix(lines, myMatrix, num);
		//printMatrix(myMatrix);

		//2 trade -> x^2 = 1.08 -> x = 1.03923. 
		//3.923% profit per trade.
		
		for(int i = 0 ; i<num ; i++)
		{
			for(int j = 0;j<num ;j++)
			{
				myMatrix[i][j] = -(Math.log(myMatrix[i][j])/Math.log(2));
			}
		}
		
		
		double[] finding_min = new double[num+1];
		boolean flag = true;
		while(flag)
		{
			double[][] temp = myMatrix;
			min_plus_multiplication(num, myMatrix, finding_min, paths);
			if(temp.equals(myMatrix));
			flag = false;
		}
		
		printMatrix(myMatrix);
		printMatrix(paths);
		
//		double[][] temp = extend_shortest_path(myMatrix);
//		printMatrix(temp);
		
	}
	public static double[][] extend_shortest_path(double[][] w)
	{
		int n = w.length;
		double[][] l = new double[n][n];
		for(int i = 0 ; i < n ; i++)
		{
			for(int j = 0 ; j < n ; j++)
			{
				l[i][j] = Integer.MAX_VALUE;
				for(int k = 0 ; k < n ; k++)
				{
					l[i][j] = Math.min(l[i][j], l[i][k] + w[k][j]);
				}
			}
		}
		return l;
	}
	public static void min_plus_multiplication(int num, double[][] myMatrix, double[] finding_min, int[][] paths)
	{
		for(int i = 0; i<num; i++) //1
		{
			//gets me the whole row
			for(int j = 0; j<num; j++) //1,2
			{
				double min = Double.MAX_VALUE;
				int index = 0;
				for(int h=0; h<num; h++)
				{
					double temp =  myMatrix[i][h] + (myMatrix[h][j]);
					//System.out.println(temp);
					if(temp<=min)
					{
						min = temp;
						index = h;
					}
					//System.out.println(myMatrix[i][h] +" + "+ myMatrix[h][j] +" = "+ temp);
					//finding_min[h+1] = temp;
				}
				paths[i][j] = index+1;
				myMatrix[i][j] = min;
//				int min_index = find_min(finding_min);
//				paths[i][j] = min_index;
				//myMatrix[i][min_index] = finding_min[min_index];
			}
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
