package knapsack;
public class SubsetSumKS {
	static boolean t[][];
	public SubsetSumKS(int n,int w) {
		// TODO Auto-generated constructor stub
		this.t = new boolean[n+1][w+1];
		for (int i = 0; i < n+1; i++) {
			for (int j = 0; j < w+1; j++) {
				if (i== 0) {
					t[i][j] = false;
				}
				if (j == 0) {
					t[i][j] = true;
				}
			}
		}
	}
	public static void main(String[] args) {
		int arr[] = {  2,3,7,8,10};
		int sum = 13;
		int n= 5;
		
		System.out.println(new SubsetSumKS(n,sum).subsetSum(arr,sum,n));
	}
	
	boolean subsetSum(int[] arr,int w,int n) {
		for (int i = 1; i < n+1; i++) {
			for (int j = 1; j < w+1; j++) {
				if (arr[i-1] <= j) {
					t[i][j] = t[i-1][j - arr[i-1]] || t[i-1][j];
				}else {
					t[i][j] = t[i-1][j];
				}
			}
		}
		return t[n][w];
	}
}
