package mypack;
import java.util.*;
public class 벌꿀채취 {
	static int n;
	static int m;
	static int C;
	static int[][] arr;
	static boolean[][] visited;
	static int max;
	static int max_r, max_c;
	static int _ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc<=T; tc++) {
			max=0;
			max_r=0; max_c=0;
			_ans = 0;
			n = sc.nextInt();
			m = sc.nextInt();
			C = sc.nextInt();
			arr = new int[n][n];
			visited = new boolean[n][n];
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			int[] tmp = new int[m];
			for(int i=0; i<n; i++) {
				for(int j=0; j<=n-m; j++) {
					tmp = new int[m];
					for(int k=j; k<j+m; k++) {
						tmp[k-j] = arr[i][k];
					}
					PowerSet(tmp, new boolean[tmp.length], 0, i, j);
				}
			}
			for(int i=0; i<m; i++) {
				visited[max_r][max_c+i] = true;
			}
			_ans+= max;
			max = 0; max_r=0; max_c=0;
			for(int i=0; i<n; i++) {
				for(int j=0; j<=n-m; j++) {
					tmp = new int[m];
					for(int k=j; k<j+m; k++) {
						if(visited[i][k] == true) {
							tmp = new int[m];
							break;
						}
						tmp[k-j] = arr[i][k];	
					}
					PowerSet(tmp, new boolean[tmp.length], 0, i, j);
				}
			}
			for(int i=0; i<m; i++) {
				visited[max_r][max_c+i] = true;
			}
			_ans+=max;
			System.out.println("#"+tc+" "+_ans);
		}
	}
	static void PowerSet(int[] tmp, boolean[] ans, int idx, int r, int c) {
		if(idx == ans.length) {
			int cnt = 0;
			for(int i=0; i<ans.length; i++) {
				if(!ans[i]) {
					cnt+=tmp[i];
				}
			}
			if(cnt > C) return;
			int sum = 0;
			for(int i=0; i<ans.length; i++) {
				if(!ans[i]) {
					sum += tmp[i]*tmp[i];
				}
			}
			if(max < sum) {
				max = sum;
				max_r = r; max_c = c;
			}
			return;
		}
		ans[idx] = true;
		PowerSet(tmp, ans, idx+1, r, c);
		ans[idx] = false;
		PowerSet(tmp, ans, idx+1, r, c);
	}
}
