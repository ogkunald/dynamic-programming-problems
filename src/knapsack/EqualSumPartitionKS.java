package knapsack;

public class EqualSumPartitionKS {

	public static void main(String[] args) {
		int arr[] = {  5,2,5,2,2,2 };
		new EqualSumPartitionKS().equalSubsetSum(arr);
	}
	void equalSubsetSum(int[] arr) {
		int sum = 0;
		int n = arr.length;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		if (sum % 2 != 0) {
			System.out.println(-1);
		}else {
		System.out.println(new SubsetSumKS(n, sum/2).subsetSum(arr, sum/2, n));
		}
	}
}
