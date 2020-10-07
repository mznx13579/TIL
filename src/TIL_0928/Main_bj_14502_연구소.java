package TIL_0928;
import java.util.*;

public class Main_bj_14502_연구소 {
	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static int ans;
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
	static Queue<Pair> q;
	static ArrayList<Pair> hole;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		ans=0; hole = new ArrayList<>();
		q = new LinkedList<>();
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {
				map[r][c] = sc.nextInt();
				if(map[r][c] == 2) q.add(new Pair(r,c));
				if(map[r][c] == 0) hole.add(new Pair(r,c));
			}
		}
		makeWall(new Pair[3], 0, 0);
		System.out.println(ans);
	}
	private static void makeWall(Pair[] ans, int idx, int remain) {
		if(remain == ans.length) {
			int[][] copy = new int[N][M];
			for(int r=0; r<N; r++) {
				for(int c=0; c<M; c++) {
					copy[r][c] = map[r][c];
				}
			}
			for(int i=0; i<3; i++) {
				Pair p = ans[i];
				copy[p.r][p.c] = 1; 
			}
			goCount(copy);
			return;
		}
		if(idx == hole.size()) return;
		ans[remain] = hole.get(idx);
		makeWall(ans, idx+1, remain+1);
		makeWall(ans, idx+1, remain);
	}
	private static void goCount(int[][] copy) {
		visited = new boolean[N][M];
		Queue<Pair> cq = new LinkedList<Pair>();
		for(Pair p : q) {
			visited[p.r][p.c] = true;
			cq.add(p);
		}
		while(!cq.isEmpty()) {
			Pair p = cq.poll();
			for(int k=0; k<4; k++) {
				int nr = p.r+dr[k];
				int nc = p.c+dc[k];
				if(0<=nr && nr <N && 0<=nc && nc < M) {
					if(copy[nr][nc] == 0 && visited[nr][nc]==false) {
						visited[nr][nc] = true;
						copy[nr][nc] = 1;
						cq.add(new Pair(nr, nc));
					}
				}
			}
		}
		int cnt = 0;
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {
				if(copy[r][c] == 0) cnt++;
			}
		}
		if(ans < cnt) ans = cnt;
	}
}
