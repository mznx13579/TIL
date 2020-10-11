package TIL_1011;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_bj_10775_공항 {
	static int G;
	static int[] parent, rank;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		G = Integer.parseInt(br.readLine());
		int P = Integer.parseInt(br.readLine());
		int count = 0;
		boolean stop = false;
		
		parent = new int[G+1];
		rank = new int[G+1];
		for(int i=1; i<=G; i++) parent[i] = i;
		for(int i=0; i<P; i++) {
			int g = Integer.parseInt(br.readLine());
			int p = Find(g);
			if(p != 0) {
				Union(p, p-1);
				count++;
			} else break;
		}
		bw.write(count + " ");
		bw.flush();
		bw.close();
		br.close();
	}
	private static void Union(int u, int v) {
		int uR = Find(u);
		int vR = Find(v);
		parent[uR] = vR;
	}
	private static int Find(int u) {
		if(parent[u] == u) return u;
		return parent[u] = Find(parent[u]);
	}
}
