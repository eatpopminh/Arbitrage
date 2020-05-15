//Final exam
//Done
//Arbitrage
import java.io.File;
import java.io.FileWriter;
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


public class main {
	final static int INF = Integer.MAX_VALUE;
	public static ArrayList<int[][]> all_path;
	
	//biggest
	public static ArrayList<ArrayList<Integer>> cycle_with_biggest_profit;
	public static double biggest_profit = 0;
	
	public static ArrayList<Integer> temp_list_of_cycle;
	
	//double
	public static ArrayList<Double> prices;
	public static double[][] OG_matrix;
	

	//int
//	public static ArrayList<Integer> price_int;
//	public static int[][] OG_matrix_int = {		{0,0,0,0,0},
//												{0,0,5,2,INF},
//												{0,-8,0,1,INF},
//												{0,INF,INF,0,-5},
//												{0,INF,3,INF,0} };

//		{	{0,0,0,0,0},
//			{0, 0,-.648613, -.327216, .0306045},
//			{0,.648614, 0, .321387, .67922},
//			{0,.327227, -.321386, 0, .357833},
//			{0,-.0305903, -.679217, -.357822, 0}};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		all_path = new ArrayList<int[][]>();
		cycle_with_biggest_profit = new ArrayList<ArrayList<Integer>>();
		temp_list_of_cycle = new ArrayList<Integer>();
		
		//Int
//		price_int = new ArrayList<Integer>();
		//double
		prices = new ArrayList<Double>();
		
		
		
		File f = new File("input.txt");
		List<String> lines = Files.readAllLines(Paths.get("input.txt"));
		int num = Integer.parseInt(lines.get(0));
//		System.out.println(lines.size());
		
		
		
		double [][] myMatrix = new double[num+1][num+1];
		//double
		OG_matrix = new double[num+1][num+1];
		
		textToMatrix(lines, myMatrix, num);
		textToMatrix(lines, OG_matrix, num);


		
		
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

		
		//From lecture but changed to have a negtaive cycle.
		int[][] myMatrix7 =  {		{0,0,0,0,0},
									{0,0,5,2,INF},
									{0,-8,0,1,INF},
									{0,INF,INF,0,-5},
									{0,INF,3,INF,0} };

	
		//FOR INTEGER
//		int[][] temp_matrix = new int[num+1][num+1];
//		
//		for(int i  = 1 ; i<=num ; i++)
//			for(int j = 1 ; j<=num ; j++)
//			{
//				temp_matrix[i][j] = INF;
//				if(i==j)
//					temp_matrix[i][j] = 0;
//			}
//		min_plus_multiplication_int(4, myMatrix7, temp_matrix);
////		System.out.println(cycle_with_biggest_profit);
////		System.out.println(biggest_profit);
		
		
		
		
		
		
//		for(int i = 1 ; i<=4 ; i++)
//			for(int j = 1;j<=4 ;j++)
//			{	
//				myMatrix4[i][j] = -Math.log(myMatrix4[i][j])/Math.log(2);
//				if(myMatrix4[i][j] ==-0)
//					myMatrix4[i][j]=0;
//			}
		
		
		
		
		//FOR DOUBLE
		double[][] temp_matrix = new double[num+1][num+1];
		for(int i  = 1 ; i<=num ; i++)
			for(int j = 1 ; j<=num ; j++)
			{
				temp_matrix[i][j] = INF;
				if(i==j)
					temp_matrix[i][j] = 0;
			}
		min_plus_multiplication(num, myMatrix, temp_matrix);
		
		System.out.println("DONE");
		System.out.println("------------------------------------------");
		System.out.println("BEST CYCLE");
		System.out.println(cycle_with_biggest_profit);
		System.out.println(biggest_profit);

		
		ArrayList<Integer> FINAL_ANSWER = new ArrayList<Integer>();
		int start = cycle_with_biggest_profit.get(0).get(1);
		FINAL_ANSWER.add(start);
		for(int i = 2 ; i < cycle_with_biggest_profit.get(0).size() ; i++)
		{
			if(start==(cycle_with_biggest_profit.get(0).get(i)))
			{
				break;	
			}
			FINAL_ANSWER.add(cycle_with_biggest_profit.get(0).get(i));
		}
		FINAL_ANSWER.add(start);
		System.out.println("FINAL ANSWER");
		for(int i = 0 ;i<cycle_with_biggest_profit.size() ; i++)
		{
			System.out.println(FINAL_ANSWER);
		}
		
//		System.out.println("1 Trade: " + OG_matrix[118][169]);
//		System.out.println("2 Trade: " + OG_matrix[169][265]);
//		System.out.println("3 Trade: " + OG_matrix[265][265]);
//		System.out.println("4 Trade: " + OG_matrix[265][118]);
//		System.out.println("5 Trade: " + OG_matrix[118][0]);
//		double temp1 = OG_matrix[118][169] * OG_matrix[169][265] * OG_matrix[265][265] * OG_matrix[265][118] ;
//		System.out.println("Total: " +  temp1);
//		
//		System.out.println(Math.pow(temp1, (double)1.0/4.0));
//		
//		System.out.println("DO IN REVERSE");
//		System.out.println("1 Trade: " + OG_matrix[118][265]);
//		System.out.println("2 Trade: " + OG_matrix[265][265]);
//		System.out.println("3 Trade: " + OG_matrix[265][169]);
//		System.out.println("4 Trade: " + OG_matrix[169][118]);
//
//		double temp2 = OG_matrix[118][265] * OG_matrix[265][265] * OG_matrix[265][169] * OG_matrix[169][118];
//		System.out.println("Total: " +  temp2);
//		
//		System.out.println(Math.pow(temp2, (double)1.0/4.0));
//		
//		System.out.println("------------------------------------------");
//		
//		System.out.println("1 Trade: " + OG_matrix[6][65]);
//		System.out.println("2 Trade: " + OG_matrix[65][260]);
//		System.out.println("3 Trade: " + OG_matrix[260][26]);
//		System.out.println("4 Trade: " + OG_matrix[26][117]);
//		System.out.println("5 Trade: " + OG_matrix[117][149]);
//		System.out.println("6 Trade: " + OG_matrix[149][101]);
//		System.out.println("7 Trade: " + OG_matrix[101][86]);
//		System.out.println("7 Trade: " + OG_matrix[86][105]);
//		System.out.println("8 Trade: " + OG_matrix[105][255]);
//		System.out.println("10 Trade: " + OG_matrix[255][265]);
//		System.out.println("11 Trade: " + OG_matrix[265][112]);
//		System.out.println("12 Trade: " + OG_matrix[112][6]);
//		double temp = OG_matrix[6][65]*OG_matrix[65][260]* OG_matrix[260][26]* OG_matrix[26][117]* OG_matrix[117][149]
//				* OG_matrix[149][101]* OG_matrix[101][86]* OG_matrix[86][105]* OG_matrix[105][255]* OG_matrix[255][265]* OG_matrix[265][112]* OG_matrix[112][6];
//				
//		System.out.println(temp);
//		double d = (double)1/12.0;
//		System.out.println(d);
//		System.out.println(Math.pow(temp,d));
//		
//		System.out.println("DO IN REVERSE");
//		System.out.println("1 Trade: " + OG_matrix[6][112]);
//		System.out.println("2 Trade: " + OG_matrix[112][265]);
//		System.out.println("3 Trade: " + OG_matrix[265][255]);
//		System.out.println("4 Trade: " + OG_matrix[255][105]);
//		System.out.println("5 Trade: " + OG_matrix[105][86]);
//		System.out.println("6 Trade: " + OG_matrix[86][101]);
//		System.out.println("7 Trade: " + OG_matrix[101][149]);
//		System.out.println("7 Trade: " + OG_matrix[149][117]);
//		System.out.println("8 Trade: " + OG_matrix[117][26]);
//		System.out.println("10 Trade: " + OG_matrix[26][260]);
//		System.out.println("11 Trade: " + OG_matrix[260][65]);
//		System.out.println("12 Trade: " + OG_matrix[65][6]);
//		
//		double temp3 = OG_matrix[6][112] * OG_matrix[112][265] * OG_matrix[265][255] * OG_matrix[255][105] *OG_matrix[105][86]*OG_matrix[86][101]
//		* OG_matrix[101][149]*OG_matrix[149][117]*OG_matrix[117][26]* OG_matrix[26][260]*OG_matrix[260][65]*OG_matrix[65][6];
//		
//		System.out.println("Total: " +  temp3);
//		
//		System.out.println(Math.pow(temp3, (double)1.0/12.0));
		
		
		
		
		//File writer
		FileWriter write = new FileWriter("output.txt");
		for(int i  = FINAL_ANSWER.size()-1 ; i>=0 ; i--)
		{
			write.write(Integer.toString(FINAL_ANSWER.get(i)) + "\n");
		}

        write.close();
	
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
			
			//looking for negative cycle
			for(int w = 1 ; w<=num ;w++)
			{
				if(sol[w][w]<0)
				{
					steps = w;
//					System.out.println("HELLO " +w);
//					printMatrix(sol);
//					for(int i = 0 ; i<all_path.size() ; i++)
//					{
//						System.out.println("------------------");
//						printMatrix(all_path.get(i));	
//					}
//					//System.out.println("Cycle Length: " + g);
//					temp_list_of_cycle.add(paths[w][w]);
//					printPath(w,paths[w][w],g,num);
//					temp_list_of_cycle.add(0,w);
//					//System.out.println("First: " + w + " -> " +paths[w][w]);
//					
////					for(int q = 1; q<=num;q++)
////						for(int e = 1; e<=num;e++)
////								System.out.println(OG_matrix[q][e]);
////					prices.add(OG_matrix[w][w]);
//					
//					calculate_price_double();
//					temp_list_of_cycle = new ArrayList<Integer>();
//					prices = new ArrayList<Double>();
	
					if(w!=paths[w][w])
					{
						printPaths2_double(w, paths[w][w], g, num);
						if(temp_list_of_cycle.get(0)!=paths[w][w])
							temp_list_of_cycle.add(0,paths[w][w]);
						temp_list_of_cycle.add(0,w);
						temp_list_of_cycle.add(0,0);
						
						//Important PRINTS
						System.out.println(temp_list_of_cycle);
						System.out.println("First: " + w + " -> " +paths[w][w]);
			
									
						calculate_price_double();
						temp_list_of_cycle = new ArrayList<Integer>();
						prices = new ArrayList<Double>();
					}
					
				}	
			}
			//System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		}
//		for(int i = 0 ; i<all_path.size();i++)
//		{
//			int[][] temp = all_path.get(i);
//			System.out.println();
//			printMatrix(temp);
//		}
		//printMatrix(sol);
//		printMatrix(paths);
//		System.out.println(paths[6][6]);
//		System.out.println(paths[6][65]);
//		System.out.println(paths[6][260]);
		
//		System.out.println(paths[17][31]);
//		System.out.println(OG_matrix[17][31]);
//		System.out.println(OG_matrix[31][17]);

	}
	public static void calculate_price_double()
	{
		//Forward
//		for(int  i = 0 ; i<temp_list_of_cycle.size()-1 ; i++)
//		{
//			prices.add(OG_matrix[temp_list_of_cycle.get(i)][temp_list_of_cycle.get(i+1)]);
//		}
		//Backward
		for(int  i = temp_list_of_cycle.size()-1 ; i>0 ; i--)
		{
			prices.add(OG_matrix[temp_list_of_cycle.get(i)][temp_list_of_cycle.get(i-1)]);
		}
		

		int prices_size = prices.size();
		for(int i = 0 ; i<prices_size ; i++)
		{
			if(prices.get(i)==0)
			{
				prices.remove(i);
				i=i-1;
				prices_size = prices.size();
			}
		}
		
		//System.out.println("BOB: "+ prices);
		
		double first = prices.get(0);
		for(int i  = 1 ; i<prices.size() ; i++)
		{
			first*=prices.get(i);
		}
		
		
		double priceSize = prices.size();
		
		double nth = (double)1/priceSize;
		
		//System.out.println(first + "//" + nth);
		
		double temp = Math.pow(first, nth);
		System.out.println(temp);
		

		
			if(temp>biggest_profit)
			{
				cycle_with_biggest_profit.clear();
				biggest_profit = temp;
				cycle_with_biggest_profit.add(temp_list_of_cycle);
			}

		
	}
	public static void printPaths2_double(int start, int end, int steps, int num)
	{
		int temp_end = end;
		//System.out.println("all Path size: "+all_path.size());;
		for(int i = all_path.size()-1 ; i>=0 ; i--)
		{
			int[][] temp = all_path.get(i);
			temp_list_of_cycle.add(temp[start][temp_end]);
			temp_end = temp[start][temp_end];
			
		}
	}
//	public static void printPath(int start, int end, int steps, int num)
//	{
//		if(steps<0)//start==end)
//			return;
//		
//		int last_index = -1;
//		int[][] temp_array = new int[num+1][num+1];
//		
//		for(int i = 0 ; i<steps ; i++)
//		{
//			temp_array = all_path.get(i);
//			
//		}
//		//System.out.println(temp_array[start][end]);
//		temp_list_of_cycle.add(temp_array[start][end]);
//		
//		printPath(start, temp_array[start][end], steps-1, num);
//	}
	
	
	
	//INTEGER
//	public static void min_plus_multiplication_int(int num, int[][] myMatrix,int[][] temp_matrix)
//	{
//		
//		int steps = 0;
//		int[][] paths = new int[num+1][num+1];
//		int[][] sol = new int[num+1][num+1];
//
//		for(int g = 1 ; g<=num ; g++)
//		{
//			for(int i = 1; i<=num; i++) 
//			{
//				for(int j = 1; j<=num; j++) 
//				{
//					int current_smallest = INF;
//					for(int k = 1; k<=num; k++)
//					{
//						if((myMatrix[k][j]!=INF && myMatrix[k][j]!=INF) && 
//								(temp_matrix[i][k]!=INF && temp_matrix[i][k]!=INF) &&
//								temp_matrix[i][k] + myMatrix[k][j] <= current_smallest)
//						{
//							current_smallest = temp_matrix[i][k] + myMatrix[k][j];
//							sol[i][j] =  current_smallest;
//							paths[i][j] = k;
//							
//						}
//					}
//					if(sol[i][j]==0 && i!=j)
//						sol[i][j] = INF;
//				}	
//			}
//			int[][] temp_to_add_allpath = new int[num+1][num+1];
//			for(int a = 1 ; a<=num ; a++)
//				for(int b = 1 ; b<=num ; b++)
//					temp_to_add_allpath[a][b] = paths[a][b];
////			temp_to_add_allpath = paths.clone();
//			all_path.add(temp_to_add_allpath);
//			
//			//Move sol to temp_matrix
//			for(int a = 1 ; a<=num ; a++)
//				for(int b = 1 ; b<=num ; b++)
//					temp_matrix[a][b] = sol[a][b];
//
//			
//			
//			//Detect negative in the diaganol
//			for(int w = 1 ; w<=num ;w++)
//			{
//				if(sol[w][w]<0)
//				{
//					steps = w;
//					System.out.println("First in my negative cycle: " + w);
//					printMatrix(sol);
//					for(int i = 0 ; i<all_path.size() ; i++)
//					{
//						System.out.println("------------------");
//						printMatrix(all_path.get(i));
//						
//					}
//					System.out.println("Cycle Length: " + g);
//					
//					//temp_list_of_cycle.add(paths[w][w]);
//					//printPaths(w,paths[w][w],g,num);
//					if(w!=paths[w][w])
//					{
//						printPaths2(w, paths[w][w], g, num);
//						if(temp_list_of_cycle.get(0)!=paths[w][w])
//							temp_list_of_cycle.add(0,paths[w][w]);
//						temp_list_of_cycle.add(0,w);
//						temp_list_of_cycle.add(0);
//						System.out.println(temp_list_of_cycle);
//						
//	//					temp_list_of_cycle.add(0,w);
//						System.out.println("First: " + w + " -> " +paths[w][w]);
//	//					
//	//					//price_int.add(OG_matrix_int[w][w]);
//	//					
//						calculate_price_int();
//						temp_list_of_cycle = new ArrayList<Integer>();
//						price_int = new ArrayList<Integer>();
//					}
//					
//				}	
//			}
//			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
//		}
//
//	}
//	public static void printPaths2(int start, int end, int steps, int num)
//	{
//		int temp_end = end;
//		System.out.println("all Path size: "+all_path.size());;
//		for(int i = all_path.size()-1 ; i>=0 ; i--)
//		{
//			int[][] temp = all_path.get(i);
//			temp_list_of_cycle.add(temp[start][temp_end]);
//			temp_end = temp[start][temp_end];
//			
//		}
//	}
//	public static void printPaths(int start, int end, int steps, int num)
//	{
//		if(steps<0 )//|| start==end)
//		{
//			return;
//		}
//		int last_index = -1;
//		int[][] temp_array = new int[num+1][num+1];
//		for(int i = 0 ; i<steps-1 ; i++)
//		{
//			temp_array = all_path.get(i);
//		}
//		System.out.println("^^^ "+temp_array[start][end]);
//		temp_list_of_cycle.add(temp_array[start][end]);
//		//price_int.add(OG_matrix_int[start][end]);
//		printPaths(start, temp_array[start][end], steps-1, num);
//	}
//	public static void calculate_price_int()
//	{
//
//		System.out.println(temp_list_of_cycle);
//		//System.out.println(temp_list_of_cycle.size());
//		for(int  i = 0 ; i<temp_list_of_cycle.size()-2 ; i++)
//		{
//			price_int.add(OG_matrix_int[temp_list_of_cycle.get(i)][temp_list_of_cycle.get(i+1)]);
//		}
//		
//		System.out.println("BOB: "+ price_int);
//		
//		int price_size = price_int.size();
//		for(int i = 0 ; i<price_size ; i++)
//		{
//			if(price_int.get(i)==0)
//			{
//				price_int.remove(i);
//				i=i-1;
//				price_size = price_int.size();
//			}
//		}
//		System.out.println("BOB2: "+ price_int);
//
//		int first = price_int.get(0);
//		for(int i  = 1 ; i<price_int.size() ; i++)
//		{
//			first*=price_int.get(i);
//		}
//		double priceSize=price_int.size();
//		double nth = (1/priceSize);
//		
//		double temp = Math.pow(first, nth);
//		System.out.println(first);
//		System.out.println(nth);
//		System.out.println(temp);
//		if(temp>=biggest_profit)
//		{
//			cycle_with_biggest_profit.clear();
//			biggest_profit = temp;
//			cycle_with_biggest_profit.add(temp_list_of_cycle);
//		}
//		
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
	
}
