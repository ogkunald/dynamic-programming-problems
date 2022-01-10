package knapsack;
public class KnapsackUB {
public static void main(String[] args) {
	int weights[] = {  1, 2, 3, 8, 7, 4};
	int value[] = { 20, 5, 10, 40, 15, 25 };
	int w = 10;
	int n= 6;
	
	System.out.println(new KnapsackUB().knapsack(weights, value, w, n));

}
int knapsack(int[] weights,int[] value,int w,int n) {
	
	int[][] t = new int[n+1][w+1];
	for (int i = 0; i <= n; i++) {
		t[i][0] = 0;
	}
	for (int i = 1; i <= w; i++) {
		t[0][i] = 0;
	}
	
	for (int i = 1; i < n+1; i++) {
		for (int j = 1; j < w+1; j++) {

			if (weights[i-1] <= j) {
				t[i][j]=Math.max(value[i-1] + t[i][j- weights[i-1]], t[i-1][j]);
			}
			else {
				t[i][j] = t[i-1][j];
			}
		}
	}
	return t[n][w];
	
}
}
