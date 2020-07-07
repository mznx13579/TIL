package TIL_0706;

import java.util.*;

public class Main_bj_3055_탈출 {
	static char[][] map;
	static int R, C;
	static class Pair {
		int r, c;
		public Pair(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		map = new char[R][C];
		Queue<Pair> water = new LinkedList<>();
		Queue<Pair> viber = new LinkedList<>();
		for(int r=0; r<R; r++) {
			String str = sc.next();
			for(int c=0; c<C; c++) {
			}
		}
	}
}
