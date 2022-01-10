package knapsack;
import java.util.Arrays;

public class KnapsackZeroOne {
	static Integer t[][];
	public KnapsackZeroOne(int n,int w) {
		// TODO Auto-generated constructor stub
		this.t = new Integer[n+1][w+1];
		for (Integer[] row:t) {
			Arrays.fill(row, -1);
		}
	}
public static void main(String[] args) {
	int weights[] = {  1, 2, 3, 8, 7, 4};
	int value[] = { 20, 5, 10, 40, 15, 25 };
	int w = 10;
	int n= 6;
	
	System.out.println(new KnapsackZeroOne(6,10).knapsack(weights, value, w, n));
}
int knapsack(int[] weights,int[] value,int w,int n) {
	if (w == 0 || n==0) { 
		return 0;
	}
	if (t[n][w] != -1) {
		return t[n][w];
	}
	if (weights[n-1] <= w) {
		return t[n][w] =Integer.max((value[n-1] + knapsack(weights, value, w-weights[n-1], n-1)), knapsack(weights, value, w, n-1));
	}else {
		return t[n][w] =knapsack(weights, value, w, n-1);
	}
}
}
