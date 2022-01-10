package knapsack;
public class RodCuttingUB {
	public static void main(String[] args) {
		int price[] = { 1   ,5  , 8 ,  9  ,10 , 17 , 17,  20};
		int length = 8;
		System.out.println(new RodCuttingUB().cuttingRod(price,length));
	}
	int cuttingRod(int[] price,int length) {
		int len[] = new int[length];
		for (int i = 0; i < len.length; i++) {
			len[i] = i+1;
		}
		int n = length;
		int w = length;
		int[][] t  = new int[n+1][w+1];
		for (int i = 0; i <= n; i++) {
			t[i][0] = 0;
		}
		for (int i = 0; i <= w; i++) {
			t[0][i] = 0;
		}

		for (int i = 1; i < n+1; i++) {
			for (int j = 1; j < w+1; j++) {
				if (len[i-1] <= j) {
					t[i][j] = Math.max(price[i-1]+t[i][j-len[i-1]], t[i-1][j]);
				}else {
					t[i][j] = t[i-1][j];
				}
			}
		}
		return t[n][w];
	}
	
}
