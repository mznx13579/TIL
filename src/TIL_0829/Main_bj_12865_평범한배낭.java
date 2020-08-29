package TIL_0829;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_bj_12865_평범한배낭 {
	static int N, K, W, V;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		int[] weight = new int[N];
		int[] value = new int[N];
		int[] ans = new int[K+1];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			weight[i] = w;
			value[i] = v;
		}
		for(int i=0; i<N; i++) {
			for(int j=K; j-weight[i]>=0; j--) {
				ans[j] = Math.max(ans[j], ans[j-weight[i]]+value[i]);
			}
		}
		System.out.println(ans[K]);
	}
}
