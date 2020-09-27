package TIL_0927;
import java.util.*;
public class Main_bj_2933_미네랄solution {
	static class Pair {
		int first, second;
		public Pair(int first, int second) {
			super();
			this.first = first;
			this.second = second;
		}
	}
	static char[][] a;
	static boolean[][] c;
	static int n, m;
	static ArrayList<Pair> group = new ArrayList<>();
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		a = new char[n][];
		c = new boolean[n][m];
		for(int i=0; i<n; i++) {
			a[i] = sc.next().toCharArray();
		}
        int k = sc.nextInt();
        for (int i=0; i<k; i++) {
            int height = n - sc.nextInt();
            if (i%2 == 0) {
                for (int j=0; j<m; j++) {
                    if (a[height][j] == 'x') {
                        a[height][j] = '.';
                        break;
                    }
                }
            } else {
                for (int j=m-1; j>=0; j--) {
                    if (a[height][j] == 'x') {
                        a[height][j] = '.';
                        break;
                    }
                }
            }
            simulate();
        }
        for (int i=0; i<n; i++) {
            System.out.println(a[i]);
        }
	}
	private static void simulate() {
		for(int i=0; i<n; i++) {
			Arrays.fill(c[i], false);
		}
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(a[i][j] == '.') continue;
				if(c[i][j]) continue;
				group.clear();
				dfs(i, j);
				int[] low = new int[m];
				Arrays.fill(low, -1);
				for(Pair p : group) {
					low[p.second] = Math.max(low[p.second], p.first);
					a[p.first][p.second] = '.';
				}
				int lowes = n;
				for(int x, y=0; y<m; y++) {
					if(low[y] == -1) continue;
					for(x=low[y]; x<n && a[x][y] =='.'; x++) {
						
					}
				}
			}
		}
	}
	private static void dfs(int x, int y) {
		if(a[x][y] == '.') return;
		if(c[x][y]) return;
		c[x][y] = true;
		group.add(new Pair(x,y));
		for(int k=0; k<4; k++) {
			int nx = x+dx[k];
			int ny = y+dy[k];
			if(0<=nx && nx < n && 0<=ny && ny < m) {
				dfs(nx,ny);
			}
		}
	}
}
