package TIL_1007;
// 1은 한방향 2는 두방향 3은 직각 4는 세방향 5는 다섯방향
// 4개 2개 4개 4개 1개
import java.util.*;

public class Main_bj_15683_감시 {
	static int N, M;
	static int[][] map;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static class CCTV {
		int x, y, type, dir;

		public CCTV(int x, int y, int type) {
			super();
			this.x = x;
			this.y = y;
			this.type = type;
			this.dir = 0;
		}
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] a = new int[n][m];
		ArrayList<CCTV> cctv = new ArrayList<>();
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				a[i][j] = sc.nextInt();
				if(a[i][j] >= 1 && a[i][j] <= 5) {
					cctv.add(new CCTV(i, j, a[i][j]));
				}
			}
		}
		System.out.println(go(a, cctv, 0));
	}
	private static int go(int[][] a, ArrayList<CCTV> cctv, int index) {
		if(index == cctv.size()) {
			int n = a.length, m = a[0].length;
			int[][] b = new int[n][m];
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					b[i][j] = a[i][j];
				}
			}
			for(CCTV c : cctv) {
				int what = c.type;
				int x = c.x, y = c.y;
				int dir = c.dir;
				if(what == 1) {
					check(a,b,x,y,dir);
				} else if(what == 2) {
					check(a,b,x,y,dir);
					check(a,b,x,y,(dir+2)%4);
				} else if(what == 3) {
					check(a,b,x,y,dir);
					check(a,b,x,y,(dir+1)%4);
				} else if(what == 4) {
					check(a,b,x,y,dir);
					check(a,b,x,y,(dir+1)%4);
					check(a,b,x,y,(dir+2)%4);
				} else if(what == 5) {
					check(a,b,x,y,dir);
					check(a,b,x,y,(dir+1)%4);
					check(a,b,x,y,(dir+2)%4);
					check(a,b,x,y,(dir+3)%4);
				}
 			}
			int cnt = 0;
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					if(b[i][j] == 0) cnt+=1;
				}
			}
			return cnt;
		}
		int ans = 100;
		for(int i=0; i<4; i++) {
			cctv.get(index).dir = i;
			int temp = go(a,cctv, index+1);
			if(ans > temp) {
				ans = temp;
			}
		}
		return ans;
	}
	private static void check(int[][] a, int[][] b, int x, int y, int dir) {
		int n = a.length, m = a[0].length;
		int i = x, j = y;
		while(0<=i && i < n && 0<= j && j<m) {
			if(a[i][j] == 6) break;
			b[i][j] = a[x][y];
			i += dr[dir];
			j += dc[dir];
		}
	}
}
