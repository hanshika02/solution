package week8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class tree{
    
        	private static int[][] getTriangle(String fileName, int depth) throws Exception {
		int[][] triangle = new int[depth][];
		FileReader fr = new FileReader(fileName);
		BufferedReader br = new BufferedReader(fr);

		String s;
		int i = 0;
		while ((s = br.readLine()) != null) {
			triangle[i] = new int[i + 1];
			int j = 0;
			Scanner tokens = new Scanner(s);
			while (tokens.hasNext()) {
				int value = tokens.nextInt();
				triangle[i][j++] = value;
			}
			i++;
		}

		return triangle;
	}
                
	private static void findMax(int[][] triangle, int depth) {
		int[] previous = null;
		for(int i = 1; i < depth; i++) {
			int[] last = triangle[depth - i];
			previous = calculateRowMaximal(triangle[(depth - i) - 1], last);
			//printValues(previous);
		}
		System.out.println("\tresult = " + previous[0]);
	}
	
	private static int[] calculateRowMaximal(int[] previous, int[] last) {
		for (int i = 0; i < previous.length; i++) {
			previous[i] = previous[i] + (Math.max(last[i], last[i + 1]));
		}
		return previous;
	}

	public static void main(String args[]) throws Throwable {
		String fileName = "//home/hanshika/triangle.txt";
		int depth = 100;
		int[][] triangle = getTriangle(fileName, depth);
		findMax(triangle, depth);
	}
}
