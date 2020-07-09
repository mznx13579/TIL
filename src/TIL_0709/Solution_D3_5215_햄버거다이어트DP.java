package TIL_0709;
import java.util.*;
public class Solution_D3_5215_햄버거다이어트DP {
	static class Pair {
		int t, k;
		public Pair(int t, int k) {
			this.t = t;
			this.k = k;
		}
	}
	static int T, N, L;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			N = sc.nextInt();
			L = sc.nextInt();
			Pair[] arr = new Pair[N+1];
			for(int i=1; i<=N; i++) {
				int t = sc.nextInt();
				int k = sc.nextInt();
				arr[i] = new Pair(t, k);
			}
			int max = 0;
			int[][] ans = new int[N+1][L+1];
			for(int i=1; i<=N; i++) {
				for(int j=0; j<=L; j++) {
					if(j-arr[i].k >=0) {
						ans[i][j] = Math.max(ans[i-1][j], ans[i-1][j-arr[i].k]+arr[i].t);
						if(ans[i][j] > max) max = ans[i][j];
					}
					else ans[i][j] = ans[i-1][j];
				}
			}
			System.out.println("#"+tc+" "+max);
		}
	}
}
