package lcs;

public class LCSprintLCS {
	public static void main(String[] args) {
		String x = "abcdgh";
		String y = "abedfghr";
		System.out.println(new LCSprintLCS().lcsRetString(x, y, x.length(), y.length()));
	}
	String lcsRetString(String x, String y,int xL,int yL) {
		int[][] dpArr = new int[xL+1][yL+1];
		for (int i = 0; i < yL+1; i++) {
			dpArr[0][i] = 0;
		}
		for (int i = 0; i < xL+1; i++) {
			dpArr[i][0] = 0;
		}
		for (int i = 1; i < xL+1; i++) {
			for (int j = 1; j < yL + 1; j++) {
				if (x.charAt(i-1) == y.charAt(j-1)) {
					dpArr[i][j] = 1 + dpArr[i-1][j-1];
				}else {
					dpArr[i][j] = Math.max(dpArr[i-1][j], dpArr[i][j-1]);
				}
			}
		}
		int i = xL,j = yL;
		StringBuffer s = new StringBuffer();
		while (i >0 && j > 0) {
			if (x.charAt(i-1) == y.charAt(j-1)) {
				s.append(x.charAt(i-1));
				i--;
				j--;
			}else {
				if (dpArr[i-1][j] > dpArr[i][j-1]) {
					i--;
				}else {
					j--;
				}
			}
		}
		return s.reverse().toString();
	}
}
