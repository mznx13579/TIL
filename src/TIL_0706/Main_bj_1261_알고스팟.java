package TIL_0706;

import java.util.*;

public class Main_bj_1261_알고스팟 {
	static int N, M;
	static int[][] map;
	static class Pair {
		int r, c;
		public Pair(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int[][] wall;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		map = new int[N][M];
		wall = new int[N][M];
		for(int r=0; r<N; r++) {
			String str = sc.next();
			for(int c=0; c<M; c++) {
				map[r][c] = Integer.parseInt(str.charAt(c)+"");
			}
		}
		
		ArrayDeque<Pair> q = new ArrayDeque<>();
		q.add(new Pair(0,0));
		map[0][0] = -1;
		while(!q.isEmpty()) {
			Pair p = q.poll();
			for(int k=0; k<4; k++) {
				int nr = p.r + dr[k];
				int nc = p.c + dc[k];
				if(0<=nr && nr < N && 0<=nc && nc < M && map[nr][nc] == 0 && wall[nr][nc] == 0) {
					q.addFirst(new Pair(nr, nc));
					wall[nr][nc] = wall[p.r][p.c];
					map[nr][nc] = -1;
				}
				if(0<=nr && nr < N && 0<=nc && nc < M && map[nr][nc] == 1 && wall[nr][nc] == 0) {
					q.addLast(new Pair(nr, nc));
					map[nr][nc] = -1;
					wall[nr][nc] = wall[p.r][p.c]+1;
				}
			}
		}
		System.out.println(wall[N-1][M-1]);
	}
}
