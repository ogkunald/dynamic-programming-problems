package knapsack;
public class CountSubsetSumKS {
	static int t[][];
	public CountSubsetSumKS(int n,int w) {
		// TODO Auto-generated constructor stub
		t = new int[n+1][w+1];
		for (int i = 0; i < n+1; i++) {
			for (int j = 0; j < w+1; j++) {
				if (i== 0) {
					t[i][j] = 0;
				}
				if (j == 0) {
					t[i][j] = 1;
				}
			}
		}
	}
	public static void main(String[] args) {
		int arr[] = {  2,3,5,6,8,10};
		int sum = 10;
		int n= 6;
		
		System.out.println(new CountSubsetSumKS(n,sum).subsetSum(arr,sum,n));
	}
	
	int subsetSum(int[] arr,int w,int n) {
		for (int i = 1; i < n+1; i++) {
			for (int j = 1; j < w+1; j++) {
				if (arr[i-1] <= j) {
					t[i][j] = t[i-1][j - arr[i-1]]  + t[i-1][j];
				}else {
					t[i][j] = t[i-1][j];
				}
			}
		}
		return t[n][w];
	}
}
