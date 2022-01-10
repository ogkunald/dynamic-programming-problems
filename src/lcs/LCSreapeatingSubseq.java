package lcs;

public class LCSreapeatingSubseq {
	public static void main(String[] args) {
		String x = "AABCABB";

		System.out.println(new LCSreapeatingSubseq().longestRepeatingSubseq(x, x.length()));
	}
	int longestRepeatingSubseq(String x,int xL) {
		String y = x;
		int yL = xL;
		int[][] dpArr = new int[xL+1][yL+1];
		for (int i = 0; i < xL+1; i++) {
			dpArr[i][0] = 0;
		}
		for (int i = 0; i < yL+1; i++) {
			dpArr[0][i] = 0;
		}
		
		for (int i = 1; i < xL+1; i++) {
			for (int j = 1; j < yL+1; j++) {
				if (x.charAt(i-1) == y.charAt(j-1) && i != j) {
					dpArr[i][j] = 1 + dpArr[i-1][j-1];
					
				}else {
					dpArr[i][j] = Math.max(dpArr[i-1][j], dpArr[i][j-1]);
				}
			}
		}
		return dpArr[xL][yL];
	}
}
