package mypack;

import java.util.*;
public class 초콜릿과건포도 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc<=T; tc++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] arr = new int[n][m];
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			int cnt =0;
			int min = Integer.MAX_VALUE;
			int[][] ans = new int[n][m];
			if(n<=m) {
			//왼쪽에서 오른쪽 
			
			for(int i=0; i<n; i++) {
				ans[i][0] = arr[i][0];
			}
			for(int j=1; j<m; j++) {
				for(int i=0; i<n; i++) {
					ans[i][j] = ans[i][j-1] + arr[i][j];
					cnt+=ans[i][j];
				}
			}
			for(int i=0; i<n; i++) {
				cnt+=ans[i][m-1];
			}
			for(int i=0; i<n; i++) {
				System.out.println(Arrays.toString(ans[i]));
			}

			System.out.println();
			System.out.println(cnt);
			if(min > cnt) min = cnt;
			
			//오른쪽에서 왼쪽  
			cnt=0;
			ans = new int[n][m];
			for(int i=0; i<n; i++) {
				ans[i][m-1] = arr[i][m-1];
			}
			for(int j=m-2; j>=0; j--) {
				for(int i=0; i<n; i++) {
					ans[i][j] = ans[i][j+1] + arr[i][j];
					cnt+=ans[i][j];
				}
			}
			for(int i=0; i<n; i++) {
				cnt+=ans[i][0];
			}
			for(int i=0; i<n; i++) {
				System.out.println(Arrays.toString(ans[i]));
			}
			System.out.println();
			System.out.println(cnt);
			if(min > cnt) min = cnt;
			}
			else {
			//위에서 아래  

			for(int j=0; j<m; j++) {
				ans[0][j] = arr[0][j];
			}
			for(int i=1; i<n; i++) {
				for(int j=0; j<m; j++) {
					ans[i][j] = ans[i-1][j] + arr[i][j];
					cnt+=ans[i][j];
				}
			}
			for(int j=0; j<m; j++) {
				cnt+=ans[n-1][j];
			}
			for(int i=0; i<n; i++) {
				System.out.println(Arrays.toString(ans[i]));
			}
			System.out.println();
			System.out.println(cnt);
			if(min > cnt) min = cnt;
			
			//아래에서 위  
			cnt = 0;
			ans = new int[n][m];
			for(int j=0; j<m; j++) {
				ans[n-1][j] = arr[n-1][j];
			}
			for(int i=n-2; i>=0; i--) {
				for(int j=0; j<m; j++) {
					ans[i][j] = ans[i+1][j] + arr[i][j];
					cnt+=ans[i][j];
				}
			}
			for(int i=0; i<n; i++) {
				System.out.println(Arrays.toString(ans[i]));
			}

			System.out.println();
			System.out.println(cnt);
			if(min > cnt) min = cnt;
			}
			System.out.println(min);
		}
	}
}
