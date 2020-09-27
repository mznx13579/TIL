package TIL_0927;
import java.util.*;

public class Main_bj_2933_미네랄 {
	static int R, C, N, T;
	static int[][] map;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static class Pair {
		int r, c;

		public Pair(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
	}
	static int cluster;
	static int isup;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		map = new int[R][C];
		for(int r=0; r<R; r++) {
			String str = sc.next();
			for(int c=0; c<C; c++) {
				if(str.charAt(c) == 'x') {
					map[r][c] = 1;
				}
			}
		}
		N = sc.nextInt();
		for(int i=0; i<N; i++) {
			T = sc.nextInt();
			int tr = R - T;
			if(i%2 == 0) {
				for(int c=0; c<C; c++) {
					if(map[tr][c] != 0) {
						map[tr][c] = 0;
						break;
					}
				}
			}
			else {
				for(int c=C-1; c>=0; c--) {
					if(map[tr][c] != 0) {
						map[tr][c] = 0;
						break;
					}
				}
			}
			makeCluster();
			checkCluster();
		}
		
	}

	private static void checkCluster() {
		int[] limit = new int[C];
		Arrays.fill(limit, -1);
		for(int c=0; c<C; c++) {
			int cnt = 0;
			boolean isOk = false;
			for(int r=0; r<R; r++) {
				if(map[r][c] != 0) {
					if(isOk == true && cnt >0) {
						cnt = 0;
					}
					else isOk= true;
				}
				if(map[r][c] == 0 &&isOk == true) {
					cnt++;
				}
			}
			if(cnt != 0 )limit[c] = cnt;
		}
		System.out.println();
		System.out.println(Arrays.toString(limit));
	}

	private static void makeCluster() {
		boolean[][] visited = new boolean[R][C];
		cluster = 0;
		for(int r=0; r<R; r++) {
			for(int c=0; c<C; c++) {
				if(visited[r][c] == false && map[r][c] != 0) {
					cluster++;
					Queue<Pair> q = new LinkedList<Pair>();
					q.add(new Pair(r, c));
					visited[r][c] = true;
					map[r][c] = cluster;
					while(!q.isEmpty()) {
						Pair p = q.poll();
						for(int k=0; k<4; k++) {
							int nr = p.r + dr[k];
							int nc = p.c + dc[k];
							if(0<=nr && nr < R && 0<=nc && nc < C && visited[nr][nc] == false && map[nr][nc] != 0) {
								visited[nr][nc] = true;
								map[nr][nc] = cluster;
								q.add(new Pair(nr,nc));
							}
						}
					}
				}
			}
		}
		System.out.println();
		for(int r=0; r<R; r++) {
			System.out.println(Arrays.toString(map[r]));
		}
	}
}
