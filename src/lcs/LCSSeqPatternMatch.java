package lcs;

public class LCSSeqPatternMatch {
	public static void main(String[] args) {
		String a = "AXY";
		String b = "ABSDSXSDAY";
		System.out.println(new LCSSeqPatternMatch().sequencePatternMatching(a, b, a.length(), b.length()));
	}
	boolean sequencePatternMatching(String x,String y,int xL,int yL) {
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
					dpArr[i][j] = Math.max(dpArr[i-1][j], dpArr[i][j-1]);
				}
			}
		}	
		return (dpArr[xL][yL] == x.length())?true:false;
	}
}
