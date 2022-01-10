package lcs;

public class LcSubstring {
	public static void main(String[] args) {
		String x = "abcdgh";
		String y = "abedfghr";
		System.out.println(new LcSubstring().lcSubstring(x, y, x.length(), y.length()));
	}
	int lcSubstring(String x, String y,int xL,int yL) {
		int[][] dpArr = new int[xL+1][yL+1];
		for (int i = 0; i < xL+1; i++) {
			dpArr[i][0] = 0;
		}
		for (int i = 0; i < yL+1; i++) {
			dpArr[0][i] = 0;
		}
		for (int i = 1; i < xL+1; i++) {
			for (int j = 1; j < yL+1; j++) {
				if (x.charAt(i-1) == y.charAt(j-1)) {
					dpArr[i][j] = 1 + dpArr[i-1][j-1];
				}else {
					dpArr[i][j] = 0;
				}
			}
		}
		int MAX = Integer.MIN_VALUE;
		for (int i = 0; i < dpArr.length; i++) {
			for (int j = 0; j < dpArr[0].length; j++) {
				MAX = dpArr[i][j] > MAX ? dpArr[i][j]: MAX;
			}
		}
		return MAX;
	}
}
