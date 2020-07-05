package TIL_0309;

import java.util.*;

public class b_탈출_0 {
	static int R, C;
	static char[][] map;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static Queue<Point> q1, q2;
	static int goal_r, goal_c;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		map = new char[R][C];
		q1 = new LinkedList<>();
		q2 = new LinkedList<>();
		for(int i=0; i<R; i++) {
			String str = sc.next();
			for(int j=0; j<C; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == '*') {
					q1.add(new Point(i,j,0));
				}
				if(map[i][j] == 'S') {
					q2.add(new Point(i,j,0));
				}
				if(map[i][j] == 'D') {
					goal_r = i; goal_c = j;
				}
			}
		}
		
		while(!(q1.isEmpty() && q2.isEmpty())) {
			bfsWater();
			bfsDoci();
		}
		if(map[goal_r][goal_c] == 'D') System.out.println("KAKTUS");
	}
	static void bfsWater() {
		int size = q1.size();
		while(size-->0) {
			Point p = q1.poll();
			for(int k=0; k<4; k++) {
				int nr = p.r + dr[k];
				int nc = p.c + dc[k];
				if(0<=nr && nr < R && 0<=nc && nc < C) {
					if(map[nr][nc] == '.') {
						map[nr][nc] = '*';
						q1.add(new Point(nr,nc,p.dist+1));
					}
				}
			}
		}
	}
	static void bfsDoci() {
		int size = q2.size();
		while(size-->0) {
			Point p = q2.poll();
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
						q2.add(new Point(nr,nc,p.dist+1));
					}
				}
			}
		}
	}
	static class Point {
		int r, c, dist;
		
		Point(int r, int c, int dist){
			this.r = r;
			this.c = c;
			this.dist = dist;
		}
	}
}

