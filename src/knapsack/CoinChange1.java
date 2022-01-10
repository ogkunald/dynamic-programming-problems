package knapsack;
public class CoinChange1 {
public static void main(String[] args) {
	int[] coin = {1,2,3};
	int sum = 5;
	System.out.println(new CoinChange1().coinChangeSum(coin,sum));
}
	int coinChangeSum(int[] coins, int sum){
		
		int[][] t = new int[coins.length+1][sum+1];
		for (int i = 0; i < coins.length+1; i++) {
			t[i][0] = 1;
		}
		for (int i = 1; i < sum+1; i++) {
			t[0][i] = 0;
		}
		
		for (int i = 1; i < coins.length+1; i++) {
			for (int j = 1; j < sum+1; j++) {
				if (coins[i-1] <= j) {
					t[i][j] =  t[i][j-coins[i-1]] + t[i-1][j];
				}else {
					t[i][j] = t[i-1][j];
				}
			}
		}
		return t[coins.length][sum];
	}
}
