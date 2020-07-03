package mypack;
import java.util.*;

public class 방향전환 {
	static class Pair {
		int r; int c; int dir;
		Pair(int r, int c, int dir){
			this.r = r; this.c = c; this.dir = dir;
		}
	}
	static int[][] dist;
	static int[] dr = {1,-1,0,0};
	static int[] dc = {0,0,-1,1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			dist = new int[201][201];
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			int min = Integer.MAX_VALUE;
			x1+=100; y1+=100; x2+=100; y2+=100;
			Queue<Pair> q = new LinkedList<>();
			q.add(new Pair(x1, y1, 0));
			q.add(new Pair(x1, y1, 1));
			dist[x1][y1] = 1;
			while(!q.isEmpty()) {
				Pair p = q.remove();
				int r = p.r;
				int c = p.c;
				if(r == x2 && c == y2) break;
				int dir = p.dir;
				if(dir == 0) {
					for(int k=0; k<2; k++) {
						int nr = r + dr[k];
						int nc = c + dc[k];
						if(0<=nr && nr <201 && 0<=nc && nc<201 && (dist[nr][nc] == 0 || dist[nr][nc] > dist[r][c]+1)) {
							dist[nr][nc] = dist[r][c]+1;
							q.add(new Pair(nr, nc, 1));
						}
					}
				}
				else if(dir == 1) {
					for(int k=2; k<4; k++) {
						int nr = r + dr[k];
						int nc = c + dc[k];
						if(0<=nr && nr <201 && 0<=nc && nc<201 && (dist[nr][nc] == 0 || dist[nr][nc] > dist[r][c]+1)) {
							dist[nr][nc] = dist[r][c]+1;
							q.add(new Pair(nr, nc, 0));
						}
					}
				}
			}
			
			System.out.println("#"+tc+" "+(dist[x2][y2]-1));
		}
	}
}
