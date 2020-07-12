package TIL_0712;

import java.util.*;
public class Solution_D3_3307_최장증가부분수열 {
	static int T, N;
	static int[] arr;
	static int[] length;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			N = sc.nextInt();
			arr = new int[N];
			length = new int[N];
			for(int i=0; i<N; i++) {
				arr[i] = sc.nextInt();
			}
			for(int i=0; i<N; i++) {
				if(length[i] == 0) length[i] = 1;
				for(int j=0; j<i; j++) {
					if(arr[i] > arr[j] && length[i] < length[j]+1) {
						length[i] = length[j]+1;
					}
				}
			}
			Arrays.sort(length);
			System.out.println("#"+tc+" "+length[N-1]);
		}
	}
}
