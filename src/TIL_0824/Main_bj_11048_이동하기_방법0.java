package TIL_0824;
import java.util.*;

public class Main_bj_11048_이동하기_방법0 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] map = new int[N][M];
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {
				map[r][c] = sc.nextInt();
			}
		}
		int[][] ans = new int[N][M];
		ans[0][0] = map[0][0];
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {
				if(r+1 < N && ans[r][c] + map[r+1][c] > ans[r+1][c]) {
					ans[r+1][c] = ans[r][c] + map[r+1][c];
				}
				if(c+1 < M && ans[r][c] + map[r][c+1] > ans[r][c+1]) {
					ans[r][c+1] = ans[r][c] + map[r][c+1];
				}
				if(r+1 < N && c+1 <M && ans[r][c] + map[r+1][c+1] > ans[r+1][c+1]) {
					ans[r+1][c+1] = ans[r][c] + map[r+1][c+1];
				}
			}
		}
		System.out.println(ans[N-1][M-1]);
	}
}
