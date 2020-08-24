package TIL_0824;
import java.util.*;

public class Main_bj_11048_이동0 {
	static int[] dr = {1,1,0};
	static int[] dc = {1,0,1};
	static class Pair {
		int r;
		int c;
		public Pair(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] map = new int[N][M];
		int[][] ans = new int[N][M];
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {
				map[r][c] = sc.nextInt();
			}
		}
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(0,0));
		ans[0][0] = map[0][0];
		while(!q.isEmpty()) {
			Pair p = q.poll();
			for(int k=0; k<3; k++) {
				int nr = p.r + dr[k];
				int nc = p.c + dc[k];
				if(0<=nr && nr < N && 0<=nc && nc < M) {
					q.add(new Pair(nr,nc));
					if(ans[p.r][p.c]+map[nr][nc] > ans[nr][nc]) {
						ans[nr][nc] = ans[p.r][p.c]+map[nr][nc];
					}
				}
			}
		}
		for(int r=0; r<N; r++) {
			System.out.println(Arrays.toString(ans[r]));
		}
		System.out.println(ans[N-1][M-1]);
		//메모리초과
		
	}
}
