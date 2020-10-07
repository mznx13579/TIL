package TIL_0928;
import java.util.*;

public class Main_bj_15661_스타트와링크 {
	static int n;
	static int[][] map;
	static int answer;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new int[n][n];
		answer = Integer.MAX_VALUE;
		for(int r=0; r<n; r++) {
			for(int c=0; c<n; c++) {
				map[r][c] = sc.nextInt();
			}
		}
		combination(new int[n/2], 0, 0);
		System.out.println(answer);
	}
	private static void combination(int[] ans, int idx, int r) {
		if(r == ans.length) {
			boolean[] check = new boolean[n];
			for(int i=0; i<ans.length; i++) {
				check[ans[i]] = true;
			}
			int[] link = new int[n - n/2];
			int x = 0;
			for(int i=0; i<check.length; i++) {
				if(!check[i]) {
					link[x] = i;
					x++;
				}
			}
			int startSum = 0;
			int linkSum = 0;
			for(int i=0; i<ans.length; i++) {
				for(int j=0; j<ans.length; j++) {
					if(i==j) continue;
					startSum += map[ans[i]][ans[j]];
				}
			}
			for(int i=0; i<link.length; i++) {
				for(int j=0; j<link.length; j++) {
					if(i==j) continue;
					linkSum += map[link[i]][link[j]];
				}
			}
			if(answer > Math.abs(startSum-linkSum)) {
				answer = Math.abs(startSum-linkSum);
			}
			return;
		}
		if(idx == n) return;
		ans[r] = idx;
		combination(ans, idx+1, r+1);
		combination(ans, idx+1, r);
	}
}
