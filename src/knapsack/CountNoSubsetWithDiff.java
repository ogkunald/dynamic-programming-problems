package knapsack;
public class CountNoSubsetWithDiff {
public static void main(String[] args) {
	int[] arr = {1,1,2,3};
	System.out.println(new CountNoSubsetWithDiff().findCountOfSubsetDiff(arr, arr.length,1));
}
int findCountOfSubsetDiff(int[] arr,int n,int diff) {
	int sum = 0;
	for (int i = 0; i < arr.length; i++) {
		sum += arr[i];
	}
	sum = (diff +sum)/2;
	int[][] dpArr = new int[n+1][sum+1];
	for (int i = 0; i < n; i++) {
		dpArr[i][0] = 1;
	}
	for (int i = 1; i < sum; i++) {
		dpArr[0][i] = 0;
	}
	for (int i = 1; i < n+1; i++) {
		for (int j = 1; j < sum+1; j++) {
			if (arr[i-1] <= j) {
				dpArr[i][j] = dpArr[i-1][j-arr[i-1]] + dpArr[i-1][j];
			}else {
				dpArr[i][j] = dpArr[i-1][j];
			}
		}
	}
	return dpArr[n][sum];
}
}
