package baekjoon;

import java.util.*;

public class b_14889 {
	static int[][] arr;
	static int[] mem;
	static boolean[] check;
	static int n;
	static ArrayList<Integer> first;
	static ArrayList<Integer> second;
	static int start;
	static int link;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		arr = new int[n][n];
		mem = new int[n];
		for(int i=0; i<n; i++) mem[i] = i;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		Comb(new int[n/2], 0, 0);
		System.out.println(min);
	}
	static void Comb(int[] ans, int idx, int r) {
		if(r == ans.length) {
			check = new boolean[n];
			for(int i=0; i<ans.length; i++) {
				check[ans[i]] = true;
			}
			first = new ArrayList<>();
			second = new ArrayList<>();
			for(int i=0; i<check.length; i++) {
				if(check[i]) first.add(i);
				else second.add(i);
			}
			
			start = 0;
			link = 0;
			for(int i=0; i<n/2; i++) {
				for(int j=0; j<n/2; j++) {
					if(i==j) continue;
					start += arr[first.get(i)][first.get(j)];
					link += arr[second.get(i)][second.get(j)];
				}
			}
			int diff = Math.abs(start-link);
			if(diff < min) min = diff;
			return;
		}
		if(idx == mem.length) return;
		ans[r] = mem[idx];
		Comb(ans, idx+1, r+1);
		Comb(ans, idx+1, r);
	}
	
}
