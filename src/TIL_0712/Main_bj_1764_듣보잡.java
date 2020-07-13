package TIL_0712;

import java.util.*;
public class Main_bj_1764_듣보잡 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N, M;
		N = sc.nextInt();
		M = sc.nextInt();
		HashSet<String> set = new HashSet<>();
		for(int i=0; i<N; i++) {
			String str = sc.next();
			set.add(str);
		}
		ArrayList<String> al = new ArrayList<>();
		for(int i=0; i<M; i++) {
			String str = sc.next();
			if(set.contains(str)) {
				al.add(str);
			}
		}
		Collections.sort(al);
		System.out.println(al.size());
		for(String s : al) {
			System.out.println(s);
		}
	}
}
