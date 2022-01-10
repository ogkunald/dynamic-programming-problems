package knapsack;
public class MinSubsetDiff {
public static void main(String[] args) {
    int arr[] = { 1,6,5,14 };
    int n = arr.length;
    System.out.println(
        "The minimum difference between 2 sets is "
        + new MinSubsetDiff().findMin(arr, n));
}
int findMin(int[] arr , int n) {
	int sum = 0;
	for (int i = 0; i < arr.length; i++) {
		sum += arr[i];
	}
	boolean[][] dpArr = new boolean[n+1][sum+1];
	for (int i = 0; i <= n; i++) {
		dpArr[i][0] = true;
	}
	for (int i = 1; i <= sum; i++) {
		dpArr[0][i] = false;
	}
	for (int i = 1; i < n+1; i++) {
		for (int j = 1; j < sum+1; j++) {
			if (arr[i-1] <= j) {
				dpArr[i][j] = dpArr[i-1][j-arr[i-1]] || dpArr[i-1][j];
			}else {
				dpArr[i][j] = dpArr[i-1][j];
			}
		}
	}
	int min = Integer.MAX_VALUE;
	for (int i = sum/2; i >= 0; i--) {
		if (dpArr[n][i] == true) {
			min = sum - 2*i;
			break;
		}
	}
	return min;
}
}
