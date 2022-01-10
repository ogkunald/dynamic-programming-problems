package lcs;

public class LcsRecursive {
	public static void main(String[] args) {
		String x = "abcdgh";
		String y = "abedfghr";
		System.out.println(new LcsRecursive().LCS(x, y, x.length(), y.length()));
	}
	int LCS(String x,String y,int xL,int yL) {
		
		if (xL == 0 || yL == 0) {
			return 0;
		}
		if (x.charAt(xL-1) == y.charAt(yL-1)) {
			return 1 + LCS(x, y, xL-1, yL-1);
		}else {
			return Math.max(LCS(x, y, xL-1, yL), LCS(x, y, xL, yL-1));
		}
		
	}
}
