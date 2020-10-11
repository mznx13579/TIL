package TIL_1011;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main_bj_4195_친구네트워크 {
	static HashMap<String, Integer> list;
	static int[] parent, rank, relation;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int testcase = Integer.parseInt(br.readLine());
		for(int i=0; i<testcase; i++) {
			int F = Integer.parseInt(br.readLine());
			int idx = 0;
			list = new HashMap<>();
			parent = new int[100001];
			rank = new int[100001];
			relation = new int[100001];
			Arrays.fill(relation, 1);
			for(int j=0; j<F; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String name1 = st.nextToken();
				String name2 = st.nextToken();
				if(!list.containsKey(name1)) {
					list.put(name1, idx);
					parent[idx] = idx++;
				}
				if(!list.containsKey(name2)) {
					list.put(name2, idx);
					parent[idx] = idx++;
				}
				union(list.get(name1), list.get(name2));
				bw.write(relation[find(list.get(name1))]+"\n");
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
	private static void union(Integer u, Integer v) {
		int uR = find(u);
		int vR = find(v);
		if(uR == vR) return;
		if(rank[uR] > rank[vR]) {
			int tmp = uR;
			uR = vR;
			vR = tmp;
		}
		parent[uR] = vR;
		relation[vR] += relation[uR];
		if(rank[uR] == rank[vR]) rank[vR]++;
	}
	private static int find(Integer u) {
		if(parent[u] == u) return u;
		return parent[u] = find(parent[u]);
	}
}