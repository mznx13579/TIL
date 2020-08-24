package TIL_0824;

import java.util.*;

public class Main_bj_1890_점프 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] map = new int[N][N];
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				map[r][c] = sc.nextInt();
			}
		}
		long[][] way = new long[N][N];
		way[0][0] = 1;
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				if(r == N-1 && c == N-1) continue;
				int reach = map[r][c];
				if(r+reach < N) {
					way[r+reach][c] += way[r][c];
				}
				if(c+reach < N) {
					way[r][c+reach] += way[r][c];
				}
			}
		}
		System.out.println(way[N-1][N-1]);
	}
}
