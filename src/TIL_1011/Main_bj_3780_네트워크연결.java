package TIL_1011;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main_bj_3780_네트워크연결 {
	static int T,N;
	static int[] parent, dist, rank;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			parent = new int[N+1];
			dist = new int[N+1];
			rank = new int[N+1];
			for(int i=1; i<=N; i++) parent[i] = i;
			while(true) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String order = st.nextToken();
				if(order.equals("O")) break;
				else if(order.equals("E")) {
					int x = Integer.parseInt(st.nextToken());
					int p = find(x);
					System.out.println(dist[x]);
				} else {
					int n1 = Integer.parseInt(st.nextToken());
					int n2 = Integer.parseInt(st.nextToken());
					Union(n1, n2);
				}
			}
		}
	}
	private static void Union(int n1, int n2) {
		parent[n1] = n2;
		dist[n1] = (Math.abs(n1-n2)%1000);
		
		
	}
	private static int find(int x) {
		if(parent[x] == x) return x;
		else {
			int tmp = find(parent[x]);
			dist[x] += dist[parent[x]];
			parent[x] = tmp;
			return parent[x];
		}
	}
}
