import java.util.*;

public class l4 {
	
	public static void main(String[] args) {
		int[][] maze = {{0, 1, 0, 0, 0, 0}, {0, 1, 0, 1, 1, 0}, {0, 1, 0, 0, 1, 0}, {0, 1, 1, 1, 1, 0}, {0, 1, 0, 0, 0, 0}, {0, 0, 0, 1, 1, 0}};
		int answer = 0;
		int[] wr = {0,-1,-1,-1, 0, 1,1,1};
		int[] wc = {1, 1, 0,-1,-1,-1,0,1};
		//동 동북, 북, 북서, 서, 남서,남, 남동;
		int dir = 0;// 0 : 남  2: 동  4 : 북  6: 서
		int[] dr = {1,0,0,0,-1,0,0,0};
		int[] dc = {0,0,1,0,0,0,-1,0};
		int r = 0;
		int c = 0;
		int n = maze.length;
		if(maze[0][1] == 1) dir = 0;
		else if(maze[1][0] == 1) dir = 2;
		while(true) {
			System.out.println(r+" "+c);
			if(r == n-1 && c == n-1) {
				break;
			}
			answer++;
			for(int k=dir; k<dir+2; k++) {
				int wnr = r + wr[k];
				int wnc = c + wc[k];
				if(wnr < 0 || wnr >=n || wnc < 0 || wnc >= n || maze[wnr][wnc] == 1) {
					if(k==dir) {
						//앞으로
						break;
					}
					else {
						dir+=2;
						dir%=8;
						break;
					}
				}
			}
			int nr = r + dr[dir];
			int nc = c + dc[dir];
			if(nr < 0 || nr >= n || nc < 0 || nc >= n || maze[nr][nc] == 1) {
				for(int z = 0; z < 8; z+=2) {
					nr = r + dr[z];
					nc = c + dc[z];
					int wxr = r + wr[z];
					int wxc = c + wc[z];
					if(0<=nr && nr < n && 0<=nc && nc < n && maze[nr][nc] == 0 ) {
						if(wxr < 0 || wxr >=n || wxc < 0 || wxc >= n || maze[wxr][wxc] == 1) {
							dir = z;
							break;
						}
					}
				}
			}
			r = nr;
			c = nc;
		}
		System.out.println(answer);
	}
}
