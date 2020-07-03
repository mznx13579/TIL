package baekjoon;

import java.util.*;

public class b_13460 {
	static class Pair {
		int r;
		int c;
		Pair(int r, int c){
			this.r = r;
			this.c = c;
		}
	}
	static int n; static int m;
	static char[][] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new char[n][m];
		for(int i=0; i<n; i++) {
			String tmp = sc.next();
			for(int j=0; j<m; j++) {
				map[i][j] = tmp.charAt(j);
			}
		}
	}

}
