package baekjoon;

import java.util.*;

public class b_1987 {
	static char[][] arr;
	static int R, C;
	static int dr[] = {-1,1,0,0}; 
	static int dc[] = {0,0,-1,1};
	static int max = 1;
	static boolean[][] visited;
	static HashSet<Character> s = new HashSet<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		arr = new char[R][C];
		visited = new boolean[R][C];
		for(int i=0; i<R; i++) {
			String str = sc.next();
			for(int j=0; j<C; j++) {
				arr[i][j] = str.charAt(j);
			}
		}
		for(int i=0; i<R; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
		int cnt = 0;
		visited[0][0] = true;
		if(ok(arr[0][0])) s.add(arr[0][0]);
		dfs(0,0,1);
		System.out.println(max);
	}
	static void dfs(int r, int c, int cnt) {
		if(max < cnt) max = cnt;
		for(int k=0; k<4; k++) {
			int nr = r + dr[k];
			int nc = c + dc[k];
			if(0<=nr && nr<R && 0<=nc && nc<C && !visited[nr][nc] && ok(arr[nr][nc])) {
				System.out.println(nr+" "+nc);
				visited[nr][nc] = true;
				s.add(arr[nr][nc]);
				dfs(nr,nc,cnt+1);
				visited[nr][nc] = false;
				s.remove(arr[nr][nc]);
			}
		}
	}
	static boolean ok(char x) {
		if(s.contains(x)) return false;
		return true;
	}

}
