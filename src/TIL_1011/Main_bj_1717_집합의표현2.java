package TIL_1011;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_bj_1717_집합의표현2 {
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		arr = new int[n+1];
		for(int i=1; i<=n; i++) arr[i] = i;
		for(int i=0; i<m; i++) {
			int c, a, b;
			st = new StringTokenizer(br.readLine());
			c = Integer.parseInt(st.nextToken());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			if(c == 0) {
				int x = find(a);
				int y = find(b);
				union(x, y);
			} else if(c == 1) {
				int x = find(a);
				int y = find(b);
				if( x == y) sb.append("YES\n");
				else sb.append("NO\n");
			}
		}
		System.out.println(sb);
	}
	private static void union(int x, int y) {
		if( x == y) return;
		arr[x] = y;
	}
	private static int find(int num) {
		if(num == arr[num]) {
			return num;
		}
		return arr[num] = find(arr[num]);
	}
}
