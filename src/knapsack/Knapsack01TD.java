package knapsack;
public class Knapsack01TD {
	static int t[][];
	public Knapsack01TD(int n,int w) {
		// TODO Auto-generated constructor stub
		this.t = new int[n+1][w+1];
		for (int i = 0; i < n+1; i++) {
			for (int j = 0; j < w+1; j++) {
				if (i==0 || j==0) {
					t[i][j] = 0;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int weights[] = {  1, 2, 3, 8, 7, 4};
		int value[] = { 20, 5, 10, 40, 15, 25 };
		int w = 10;
		int n= 6;
		
		System.out.println(new Knapsack01TD(6,10).knapsack(weights, value, w, n));
	}
	int knapsack(int[] weights,int[] value,int w,int n) {
		for (int i = 1; i < n+1; i++) {
			for (int j = 1; j < w+1; j++) {

				if (weights[i-1] <= j) {
					t[i][j]=Math.max(value[i-1] + t[i-1][j- weights[i-1]], t[i-1][j]);
				}
				else {
					t[i][j] = t[i-1][j];
				}
			}
		}
		return t[n][w];
	}
}
