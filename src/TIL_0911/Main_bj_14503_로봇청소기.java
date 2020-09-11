package TIL_0911;
import java.util.*;

public class Main_bj_14503_로봇청소기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] a = new int[n][m];
		int x = sc.nextInt();
		int y = sc.nextInt();
		int dir = sc.nextInt();
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				a[i][j] = sc.nextInt();
			}
		}
		int cnt = 0;
		int[] dx = {-1,0,1,0};
		int[] dy = {0,1,0,-1};
		while(true) {
			if(a[x][y] == 0) {
				a[x][y] = 2;
			}
			if(a[x+1][y] != 0 && a[x-1][y] != 0 && a[x][y-1] != 0 && a[x][y+1] !=0) {
				if(a[x-dx[dir]][y-dy[dir]] == 1) {
					break;
				} else {
					x-= dx[dir];
					y-=dy[dir];
				}
			} else {
				dir = (dir+3) %4;
				if(a[x+dx[dir]][y+dy[dir]] == 0) {
					x+=dx[dir];
					y += dy[dir];
				}
			}
		}
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(a[i][j] == 2) {
					cnt+=1;
				}
			}
		}
		System.out.println(cnt);
	}
}
