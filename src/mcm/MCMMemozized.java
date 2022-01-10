package mcm;

public class MCMMemozized {
	public static void main(String[] args) {
		int[] array = {40,20,30,10,30};
		System.out.println(new MCMMemozized().mcmMemozized(array,1,array.length-1));
	}
	int mcmMemozized(int[] array,int i,int j){
		int[][] dpArr = new int[1001][1001];
		for (int k = 0; k < dpArr.length; k++) {
			for (int k2 = 0; k2 < dpArr[0].length; k2++) {
				dpArr[k][k2] = -1;
			}
		}
		if (i>= j) 
			return 0;
		if(dpArr[i][j] != -1)
			return dpArr[i][j];
		int min = Integer.MAX_VALUE;
		for (int k = i; k <= j-1; k++) {
			int tempans = 	mcmMemozized(array,i,k) + 
							mcmMemozized(array,k+1,j) +
							(array[i-1]*array[k]*array[j]);
			min = Math.min(tempans, min);
		}
		return dpArr[i][j] = min;
		
	}
}
