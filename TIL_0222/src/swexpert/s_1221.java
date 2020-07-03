package swexpert;

import java.util.*;

public class s_1221 {
	static HashMap<Integer, String> m1;
	static HashMap<String, Integer> m2;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		m1 = new HashMap<>();
		m1.put(0, "ZRO");
		m1.put(1, "ONE");
		m1.put(2, "TWO");
		m1.put(3, "THR");
		m1.put(4, "FOR");
		m1.put(5, "FIV");
		m1.put(6, "SIX");
		m1.put(7, "SVN");
		m1.put(8, "EGT");
		m1.put(9, "NIN");
		m2 = new HashMap<>();
		m2.put("ZRO",0);
		m2.put("ONE",1);
		m2.put("TWO",2);
		m2.put("THR",3);
		m2.put("FOR",4);
		m2.put("FIV",5);
		m2.put("SIX",6);
		m2.put("SVN",7);
		m2.put("EGT",8);
		m2.put("NIN",9);
		for(int tc = 1; tc <= T; tc++) {
			String ss = sc.next();
			int n = sc.nextInt();
			int[] arr = new int[n];
			for(int i=0; i<n; i++) {
				String str = sc.next();
				arr[i] = m2.get(str);
			}
			Arrays.sort(arr);
			System.out.println("#"+tc);
			for(int i=0; i<n; i++) {
				System.out.print(m1.get(arr[i]));
				System.out.print(" ");
			}
		}
	}
}
