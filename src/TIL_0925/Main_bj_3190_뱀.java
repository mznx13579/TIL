package TIL_0925;
import java.util.*;

public class Main_bj_3190_뱀 {
	static int N, K, R, C, L;
	static int D;
	static int len;
	/*
	 * 
	 * ㅁㅁㅁㅁㅁㅁ
	 * ㅁㅁㅁㅁㅇㅁ
	 * ㅁㅁㅁㅇㅁㅁ
	 * ㅁㅁㅁㅁㅁㅁ
	 * ㅁㅁㅇㅁㅁㅁ
	 * ㅁㅁㅁㅁㅁㅁ
	 */
	static int time;
	static int[][] map;
	static Queue<Pair> q;
	static class Pair{
		int t; char c;
		public Pair(int t, char c) {
			super();
			this.t = t;
			this.c = c;
		}
	}
	static class GT2 {
		int r, c;
		public GT2(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	static Deque<GT2> al;
	static int[] dr = {-1,1,0,0}; //상하좌우
	static int[] dc = {0,0,-1,1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		K = sc.nextInt();
		for(int i=0; i<K; i++) {
			R = sc.nextInt();
			C = sc.nextInt();
			R--; C--;
			map[R][C] = 1;
		}
		L = sc.nextInt();
		q = new LinkedList<Pair>();
		for(int i=0; i<L; i++) {
			int t = sc.nextInt();
			char c = sc.next().charAt(0);
			q.add(new Pair(t, c));
		}
		D = 3;
		time = 0;
		al = new ArrayDeque<GT2>();
		al.add(new GT2(0,0));
		L:while(true) {
			time++;
			GT2 head = al.getFirst();
			int head_r = head.r+dr[D];
			int head_c = head.c+dc[D];
			if(head_r < 0 || head_r >= N ||head_c < 0 || head_c >= N) {
				break;
			}
			for(GT2 x : al) {
				if(head_r == x.r && head_c == x.c) break L;
			}
			if(map[head_r][head_c] == 1) {
				al.addFirst(new GT2(head_r, head_c));
				map[head_r][head_c] = 0;
			}
			else {
				al.addFirst(new GT2(head_r, head_c));
				al.removeLast();
			}
			if(q.size() == 0) continue;
			Pair p = q.peek();
			if(p.t == time) {
				p = q.poll();
				if(p.c == 'D') {
					if(D == 0) D = 3;
					else if(D == 1) D = 2;
					else if(D == 2) D = 0;
					else if(D == 3) D = 1;
				}
				else if(p.c == 'L') {
					if(D == 0) D = 2;
					else if(D == 1) D = 3;
					else if(D == 2) D = 1;
					else if(D == 3) D = 0;
				}
			}
		}
		System.out.println(time);
	}
}
