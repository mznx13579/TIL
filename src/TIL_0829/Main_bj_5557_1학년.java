package TIL_0829;

import java.util.Scanner;

public class Main_bj_5557_1학년 {
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int[] arr = new int[N-1];
		long[][] d = new long[N-1][21];
		int dap = -1;
		for(int i=0; i<N; i++) {
			if(i == N-1) dap = sc.nextInt();
			else arr[i] = sc.nextInt();
		}
		d[0][arr[0]] = 1;
		for(int r=1; r<N-1; r++) {
			for(int c=0; c<=20; c++) {
				if(c+arr[r]<=20 && d[r-1][c+arr[r]]!=0) {
					d[r][c] += d[r-1][c+arr[r]];
				}
				if(0<=c-arr[r] && d[r-1][c-arr[r]]!=0) {
					d[r][c] += d[r-1][c-arr[r]];
				}
			}
		}
		System.out.println(d[N-2][dap]);
	}

}
