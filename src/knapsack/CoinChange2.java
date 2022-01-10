package knapsack;
public class CoinChange2 {
	public static void main(String[] args) {
		int[] coins = {1,2,3};
		int sum = 5;
		System.out.println(new CoinChange2().coinChangeMin(coins,sum));
	}
	int coinChangeMin(int[] coins,int sum) {
		
		int[][] t = new int[coins.length+1][sum+1];
		for (int i = 0; i < sum+1; i++) {
			t[0][i] = Integer.MAX_VALUE-1;
		}
		for (int i = 1; i < coins.length+1; i++) {
			t[i][0] = 0;
		}
		for (int i = 1,j=1; j < sum+1; j++) {
			if (j % coins[0] == 0 ) {
				t[i][j] = j / coins[0];
			}else {
				t[i][j]  = Integer.MAX_VALUE-1;
			}
		}
		for (int i = 2; i < coins.length+1; i++) {
			for (int j = 0; j < sum+1; j++) {
				if (coins[i-1] <= j) {
					t[i][j] = Math.min(1 + t[i][j-coins[i-1]], t[i-1][j]);
				}else {
					t[i][j] = t[i-1][j];
				}
			}
		}
		return t[coins.length][sum];
	}
}
