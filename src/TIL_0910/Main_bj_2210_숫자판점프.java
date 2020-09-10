package TIL_0910;

import java.util.*;

public class Main_bj_2210_숫자판점프 {
	static int[][] map;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static HashSet<String> set;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		set = new HashSet<>();
		map = new int[5][5];
		for(int r=0; r<5; r++) {
			for(int c=0; c<5; c++) {
				map[r][c] = sc.nextInt();
			}
		}
		for(int r=0; r<5; r++) {
			for(int c=0; c<5; c++) {
				go(r, c, 0, Integer.toString(map[r][c]));
			}
		}
		System.out.println(set.size());
	}
	private static void go(int r, int c, int i, String s) {
		if(i == 5) {
			s += Integer.toString(map[r][c]);
			if(set.contains(s) == false) set.add(s);
			return;
		}
		
		for(int k=0; k<4; k++) {
			int nr = r + dr[k];
			int nc = c + dc[k];
			if(0<=nr && nr < 5 && 0<=nc && nc < 5) {
				go(nr, nc, i+1, s+Integer.toString(map[nr][nc]));
			}
		}
	}
}
