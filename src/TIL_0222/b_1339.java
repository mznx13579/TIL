package TIL_0222;

import java.util.*;

public class b_1339 {
	static HashSet<Character> s;
	static boolean[] visited;
	static int n;
	static String[] alNum;
	static long max = 0;
	static Character[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		alNum = new String[n];
		s = new HashSet<>();
		for(int i=0; i<n; i++) {
			String str = sc.next();
			alNum[i] = str;
			for(int j=0; j<str.length(); j++) {
				s.add(str.charAt(j));
			}
		}
		int cnt = s.size();
		visited = new boolean[cnt];
		arr = s.toArray(new Character[s.size()]);
		perm(new char[arr.length], 0);
		System.out.println(max);
	}
	static void perm(char[] ans, int idx) {
		if(idx == arr.length) {
			long sum = 0;
			for(int i=0; i<n; i++) {
				String tmp = alNum[i];
				long now = 0;
				for(int j=0; j<tmp.length(); j++) {
					for(int k=0; k<arr.length; k++) {
						if(tmp.charAt(j) == ans[k]) {
							now = now*10 + (9-k);
						}
					}
				}
				sum+= now;
			}
			if(max < sum) max = sum;
			return;
		}
		for(int i=0; i<s.size(); i++) {
			if(!visited[i]) {
				visited[i] = true;
				ans[idx] = arr[i];
				perm(ans, idx+1);
				visited[i] = false;
			}
		}
	}
}
