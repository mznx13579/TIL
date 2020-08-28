package TIL_0828;
import java.util.*;
import java.io.*;

public class Main_bj_2294_동전2 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		Integer[] coin = new Integer[n];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			coin[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(coin, Collections.reverseOrder());
		int[] ans = new int[k+1];
		for(int i=0; i<=k; i++) ans[i] = -1;
		ans[0] = 0;
		for(int i=0; i<n; i++) {
			for(int j=1; j<=k; j++) {
				if(j-coin[i] >= 0 && ans[j-coin[i]] != -1) {
					if(ans[j] == -1 || ans[j] > ans[j-coin[i]]+1) ans[j] = ans[j-coin[i]]+1;
				}
			}
		}
		System.out.println(ans[k]);
	}
}
