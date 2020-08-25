package TIL_0826;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_bj_9095_123더하기 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		int[] ans = new int[12];
		ans[1] = 1;
		ans[2] = 2;
		ans[3] = 4;
		for(int i=4; i<12; i++) {
			ans[i] = ans[i-1]+ans[i-2]+ans[i-3];
		}
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			sb.append(ans[n]).append('\n');
		}
		System.out.println(sb);
	}
}
