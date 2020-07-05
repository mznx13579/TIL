package TIL_0312;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class b_1525 {
	static class Point {
		int r, c, cnt;
		int[][] now;
		Point(int r, int c, int cnt, int[][] arr){
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			now = new int[3][3];
			for(int i=0; i<3; i++) {
				for(int j=0; j<3; j++) {
					now[i][j] = arr[i][j];
				}
			}
		}
	}
	static Queue<Point> q = new LinkedList<>();
	static int s_r, s_c;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int[][] correct = {{1,2,3},{4,5,6},{7,8,9}};
	static boolean[][] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] arr = new int[3][3];
		visited = new boolean[3][3];
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				int z = sc.nextInt();
				if(z == 0) {
					z = 9;
					s_r = i; 
					s_c = j;
				}
				arr[i][j] = z;
				visited[i][j] = true;
			}
		}
		q.add(new Point(s_r,s_c,checkCnt(arr),arr.clone()));
		while(!q.isEmpty()) {
			Point p = q.poll();
			if(checkCnt(p.now) == 9 && p.r == 2 && p.c ==2) {
				System.out.println(p.cnt);
				return;
			}
			for(int k=0; k<4; k++) {
				int nr = p.r + dr[k];
				int nc = p.c + dc[k];
				if(0<=nr && nr < 3 && 0 <= nc && nc < 3 ) {
					int[][] tmp = p.now.clone();
					int t = tmp[p.r][p.c];
					tmp[p.r][p.c]= tmp[nr][nc];
					tmp[nr][nc] = t;
					int cC = checkCnt(tmp);
					if(cC > p.cnt) {
						visited[nr][nc] = true;
						q.add(new Point(nr,nc, cC, tmp.clone()));
					}
				}
			}
		}
		System.out.println(-1);
	}
	static int checkCnt(int[][] now) {
		int c = 0;
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				if(now[i][j] == correct[i][j]) c++;
			}
		}
		return c;
	}
	static void swap(int[][] pnt, int y, int x, int a, int b) {
		int tmp = pnt[y][x];
		pnt[y][x] = pnt[a][b];
		pnt[a][b] = tmp;
	}
}
