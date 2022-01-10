package lcs;

import java.util.Arrays;

public class LcsMemozized {
	public static void main(String[] args) {
		String x = "abcdgh";
		String y = "abedfghr";
		System.out.println(new LcsMemozized().LCSMemozized(x, y, x.length(), y.length()));
	}
	int LCSMemozized(String x, String y,int xL,int yL) {
		int[][] dpArr = new int[xL+1][yL+1];
		Arrays.stream(dpArr).forEach(a -> Arrays.fill(a, -1));
		if (xL == 0 || yL == 0)
			return 0;
		if(dpArr[xL][yL] != -1)
			return dpArr[xL][yL];
		if (x.charAt(xL-1) == y.charAt(yL-1)) {
			dpArr[xL][yL] = 1 +  LCSMemozized(x, y, xL-1, yL-1);
		}else {
			dpArr[xL][yL] = Math.max(LCSMemozized(x, y, xL-1, yL), 
					LCSMemozized(x, y, xL, yL-1));
		}
		return dpArr[xL][yL];
	}
}
