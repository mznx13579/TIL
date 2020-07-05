package TIL_0223;
import java.util.*;

public class b_17144 {
	static int[][] arr;
	static int n, m, t;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,1,-1};
	
	static int[] drUpper = {0,-1,0,1,0};
	static int[] dcUpper = {-1,0,1,0,-1};
	
	static int[] drDown = {0,1,0,-1,0};
	static int[] dcDown = {-1,0,1,0,-1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		t = sc.nextInt();
		arr = new int[n][m];
		int upperR=0;
		int upperC=0;
		int downR =0;
		int downC =0;
		boolean sideFlag = false;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				arr[i][j] = sc.nextInt();
				if(arr[i][j] == -1 && sideFlag == false) {
					upperR = i; upperC = j;
					sideFlag = true;
				}
				if(arr[i][j] == -1 && sideFlag == true) {
					downR = i; downC = j;
				}
			}
		}
		
		while(t != 0) {
			t--;
			int[][] tmp = new int[n][m];
			for(int r = 0; r < n; r++) {
				for(int c = 0; c < m; c++) {
					if(arr[r][c] == 0) continue;
					int cnt = 0;
					int share = arr[r][c]/5;
					for(int k=0; k<4; k++) {
						int nr = r + dr[k];
						int nc = c + dc[k];
						if(0<=nr && nr < n && 0 <= nc && nc < m && arr[nr][nc] != -1) {
							tmp[nr][nc] += share;
							cnt++;
						}
					}
					arr[r][c] -= share * cnt;
				}
			}
			for(int r=0; r<n; r++) {
				for(int c = 0; c<m; c++) {
					tmp[r][c] += arr[r][c];
				}
			}
			arr = tmp;
			int dir = 0;
			int nowR = upperR;
			int nowC = upperC;
			while(true) {
				
				int nr = nowR + drUpper[dir];
				int nc = nowC + dcUpper[dir];
				if(nr < 0 || nr > upperR || nc < 0 || nc >= m) {
					dir++;
					if(dir >= 5) break;
					nr = nowR + drUpper[dir];
					nc = nowC + dcUpper[dir];
				}
				if(nr == upperR && nc == upperC) {
					arr[nowR][nowC] = 0;
					break;
				}
				if(arr[nowR][nowC] == -1) arr[nr][nc] = 0;
				else {
					arr[nowR][nowC] = arr[nr][nc];
				}
				nowR = nr;
				nowC = nc;
			}
			
			dir = 0;
			nowR = downR;
			nowC = downC;
			while(true) {
				int nr = nowR + drDown[dir];
				int nc = nowC + dcDown[dir];
				if(nr < downR || nr >=n || nc < 0 || nc >=m) {
					dir++;
					if(dir >= 5) break;
					nr = nowR + drDown[dir];
					nc = nowC + dcDown[dir];
				}
				if(nr == downR && nc == downC) {
					arr[nowR][nowC] = 0;
					break;
				}
				if(arr[nowR][nowC] == -1) arr[nr][nc] = 0;
				else {
					arr[nowR][nowC] = arr[nr][nc];
				}
				nowR = nr;
				nowC = nc;
			}
		}
		int sum =0;
		for(int r=0; r<n; r++) {
			for(int c=0; c<m; c++) {
				if(arr[r][c] == -1) continue;
				sum += arr[r][c];
			}
		}
		System.out.println(sum);
		
	}
}

