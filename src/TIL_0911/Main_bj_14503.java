package TIL_0911;
import java.util.*;

public class Main_bj_14503 {
	static class Pair{
		int r, c;

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
		int[] dr = {-1,1,0,0};
		int[] dc = {0,0,-1,1};
		int[][] map = new int[N][M];
		int[][] visited = new int[N][M];
		Queue<Pair> q = new LinkedList<Pair>();
		int R, C, D;
		int cnt = 1;
		R = sc.nextInt();
		C = sc.nextInt();
		D = sc.nextInt();
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {
				map[r][c] = sc.nextInt();
			}
		}
		q.add(new Pair(R, C));
		visited[R][C] = 2;
		while(!q.isEmpty()) {
			Pair p = q.poll();
			for(int k=0; k<4; k++) {
				int nr = p.r+dr[k];
				int nc = p.c+dc[k];
				if(0<=nr && nr <N && 0<=nc && nc<M && map[nr][nc] == 0 && visited[nr][nc] == 0) {
					visited[nr][nc] = 2;
					cnt++;
					q.add(new Pair(nr,nc));
				}
			}
		}
		for(int r=0; r<N; r++) {
			System.out.println(Arrays.toString(visited[r]));
		}
		System.out.println(cnt);
	}
}
