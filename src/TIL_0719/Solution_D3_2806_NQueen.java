package TIL_0719;
import java.util.*;

public class Solution_D3_2806_NQueen {
	static int N, T;
	static int[][] map;
	static int count;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			map = new int[N][N];
			count = 0;
			go(0);
			System.out.println("#"+tc+" "+count);
		}
	}
	private static void go(int idx) {
		if(idx == N) {
			count++;
			return;
		}
		for(int c=0; c<N; c++) {
			if(map[idx][c] == 0 && isOk(idx, c)) {
				map[idx][c] = 1;
				go(idx+1);
				map[idx][c] = 0;
			}
		}
	}
	private static boolean isOk(int R, int C) {
		// 행
		for(int c=0; c<N; c++) {
			if(c == C) continue;
			if(map[R][c] == 1) return false;
		}
		// 열
		for(int r=0; r<N; r++) {
			if(r == R) continue;
			if(map[r][C] == 1) return false;
		}
		// 좌상 대각선
		int r = R-1;
		int c = C-1;
		while(r>=0 && c >= 0) {
			if(map[r][c] == 1) return false;
			r--; c--;
		}
		// 좌하 대각선
		r = R+1;
		c = C-1;
		while(r < N && c >= 0) {
			if(map[r][c] == 1) return false;
			r++; c--;
		}
		// 우상 대각선
		r = R-1;
		c = C+1;
		while(r >= 0 && c < N) {
			if(map[r][c] == 1) return false;
			r--; c++;
		}
		// 우하 대각선
		r = R+1;
		c = C+1;
		while(r < N  &&  c< N) {
			if(map[r][c] == 1) return false;
			r++; c++;
		}
		return true;
	}
	
	
}
