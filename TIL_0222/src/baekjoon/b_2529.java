package baekjoon;

import java.util.*;

public class b_2529 {
	static int[] arr = {0,1,2,3,4,5,6,7,8,9};
	static boolean[] check = new boolean[arr.length];
	static int n;
	static char[] cmp;
	static ArrayList<String> al;
	static String min, max;
	static boolean first;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		cmp = new char[n];
		for(int i=0; i<n; i++) {
			char c = sc.next().charAt(0);
			cmp[i] = c;
		}
		perm(new int[n+1], 0);
		System.out.println(max);
		System.out.println(min);
	}
	
	static void perm(int[] ans, int idx) {
		if(idx == ans.length) {
			boolean flag = false;
			for(int i=0; i<n; i++) {
				if(cmp[i] == '<' && ans[i] > ans[i+1]) flag = true;
				if(cmp[i] == '>' && ans[i] < ans[i+1]) flag = true;
			}
			if(flag == false) {
				String str = "";
				for(int i=0; i<n+1; i++) {
					str+= Integer.toString(ans[i]);
				}
				if(first == false) {
					min = str;
					first = true;
				}
				max = str;
				
			}
			return;
		}
		for(int i=0; i<arr.length; i++) {
			if(!check[i]) {
				check[i] = true;
				ans[idx] = i;
				perm(ans, idx+1);
				check[i] = false;
			}
		}
		
	}

}
