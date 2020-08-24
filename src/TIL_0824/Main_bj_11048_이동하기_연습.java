package TIL_0824;
import java.util.*;

public class Main_bj_11048_이동하기_연습 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] map = new int[n][m];
		for(int r=0; r<n; r++) {
			for(int c=0; c<m; c++) {
				map[r][c] = sc.nextInt();
			}
		}
		int[][] ans = new int[n][m];
		ans[0][0] = map[0][0];
		for(int r=0; r<n; r++) {
			for(int c=0; c<m; c++) {
				if(r+1 < n &&  c+1 < m && ans[r+1][c+1] < ans[r][c]+map[r+1][c+1]) {
					ans[r+1][c+1] = ans[r][c] + map[r+1][c+1];
				}
				if(r+1 < n && ans[r+1][c] < ans[r][c]+map[r+1][c]) {
					ans[r+1][c] = ans[r][c] + map[r+1][c];
				}
				if(c+1 < m && ans[r][c+1] < ans[r][c]+map[r][c+1]) {
					ans[r][c+1] = ans[r][c] +map[r][c+1];
				}
			}
		}
		System.out.println(ans[n-1][m-1]);
	}
}
