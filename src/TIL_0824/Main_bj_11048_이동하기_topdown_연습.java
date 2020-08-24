package TIL_0824;

import java.util.Scanner;

public class Main_bj_11048_이동하기_topdown_연습 {
	static int[][] map;
	static int[][] ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		map = new int[n][m];
		ans = new int[n][m];
		for(int r=0; r<n; r++) {
			for(int c=0; c<m; c++) {
				map[r][c] = sc.nextInt();
				ans[r][c] = -1;
			}
		}
		System.out.println(go(n-1,m-1));
	}
	private static int go(int r, int c) {
		if(r < 0 || c < 0) {
			return 0;
		}
		if(ans[r][c] >= 0) {
			return ans[r][c];
		}
		ans[r][c] = Math.max(go(r, c-1), go(r-1,c)) + map[r][c];
		return ans[r][c];
	}
}
