package TIL_0714;

import java.util.*;
public class Main_bj_11053_가장긴증가하는부분수열 {
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		int[] ans = new int[N];
		Arrays.fill(ans, 1);
		int max = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<i; j++) {
				if(arr[i] > arr[j] && ans[j]+1 > ans[i]) ans[i] = ans[j]+1;
			}
		}
		for(int i=0; i<N; i++) {
			if(ans[i] > max) max = ans[i];
		}
		System.out.println(max);
	}
}
