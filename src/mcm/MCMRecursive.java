package mcm;

public class MCMRecursive {
	public static void main(String[] args) {
		int[] array = {40,20,30,10,30};
		System.out.println(new MCMRecursive().matrixChainMultiplication(array,1,array.length-1));
	}
	int matrixChainMultiplication(int[] array,int i,int j){
		if (i >= j) {
			return 0;
		}
		int min = Integer.MAX_VALUE;
		for (int k = i; k <= j-1; k++) {
			int tempans =   matrixChainMultiplication(array, i, k) +
							matrixChainMultiplication(array, k+1, j) +
							(array[i-1]*array[k]*array[j]);
							
			min = Math.min(min, tempans);
		}
		return min;
	}
}
