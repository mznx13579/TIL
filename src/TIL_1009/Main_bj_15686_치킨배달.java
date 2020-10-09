package TIL_1009;
import java.util.*;

public class Main_bj_15686_치킨배달 {
	static class Pair {
		int r, c;

		public Pair(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
	}
	static int n, m;
	static ArrayList<Pair> kfc;
	static ArrayList<Pair> home;
	static int[][] map;
	static int ans = Integer.MAX_VALUE;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][n];
		home = new ArrayList<>();
		kfc = new ArrayList<>();
		for(int r=0; r<n; r++) {
			for(int c=0; c<n; c++) {
				map[r][c] = sc.nextInt();
				if(map[r][c] == 1) home.add(new Pair(r,c));
				if(map[r][c] == 2) kfc.add(new Pair(r,c));
			}
		}
		go(new int[m], 0, 0);
		System.out.println(ans);
	}
	private static void go(int[] arr, int idx, int r) {
		if(r == m) {
			int sum = 0;
			for(int i=0; i<home.size(); i++) {
				Pair h = home.get(i);
				int minDist = Integer.MAX_VALUE;
				for(int j=0; j<arr.length; j++) {
					Pair k = kfc.get(arr[j]);
					int dist = Math.abs(k.r - h.r) + Math.abs(k.c - h.c);
					if(minDist > dist) minDist = dist;
				}
				sum += minDist;
			}
			if(ans > sum) ans = sum;
			return;
		}
		if(idx == kfc.size()) return;
		arr[r] = idx;
		go(arr, idx+1, r+1);
		go(arr, idx+1, r);
		
	}
}
