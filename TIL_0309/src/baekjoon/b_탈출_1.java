package baekjoon;
import java.util.*;

public class b_탈출_1 {
	static int R, C;
	static char[][] map;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static Queue<Point> q;
	static int goal_r, goal_c;
	static Point ddoci;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		map = new char[R][C];
		q = new LinkedList<>();
		for(int i=0; i<R; i++) {
			String str = sc.next();
			for(int j=0; j<C; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == '*') {
					q.add(new Point(i, j, 0, true));
				}
				if(map[i][j] == 'S') {
					ddoci = new Point(i, j, 0, false);
				}
				if(map[i][j] == 'D') {
					goal_r = i;
					goal_c = j;
				}
			}
		}
		q.add(ddoci);
		while(!q.isEmpty()) {
			Point p = q.poll();
			if(p.isWater) {
				for(int k=0; k<4; k++) {
					int nr = p.r + dr[k];
					int nc = p.c + dc[k];
					if(0<=nr && nr < R && 0<=nc && nc < C) {
						if(map[nr][nc] == '.') {
							map[nr][nc] = '*';
							q.add(new Point(nr,nc,p.dist+1, true));
						}
					}
				}
			}
			else {
				if(p.r == goal_r && p.c == goal_c) {
					System.out.println(p.dist);
					return;
				}
				for(int k=0; k<4; k++) {
					int nr = p.r + dr[k];
					int nc = p.c + dc[k];
					if(0<=nr && nr < R && 0<=nc && nc < C) {
						if(map[nr][nc] == '.' || map[nr][nc] =='D') {
							map[nr][nc] = 'S';
							q.add(new Point(nr,nc,p.dist+1, false));
						}
					}
				}
			}
		}
		if(map[goal_r][goal_c] == 'D') System.out.println("KAKTUS");
	}
	static class Point {
		int r, c, dist;
		boolean isWater;
		Point(int r, int c, int dist, boolean isWater){
			this.r = r;
			this.c = c;
			this.dist = dist;
			this.isWater = isWater;
		}
	}
}

