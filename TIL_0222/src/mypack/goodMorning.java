package mypack;

import java.util.Arrays;

public class goodMorning {
	static char[] arr = {'A','B','C'};
	static boolean[] check = new boolean[arr.length];
	public static void main(String[] args) {
		System.out.println("powerSet");
		powerSet(new boolean[arr.length], 0);
		
		System.out.println("permutation");
		perm(new char[arr.length], 0);

		System.out.println("repermutation");
		rePerm(new char[arr.length], 0);
		
		System.out.println("combination");
		comb(new char[arr.length-1], 0, 0);
		
		System.out.println("recombination");
		reComb(new char[arr.length-1], 0, 0);
		
	}
	
	static void powerSet(boolean[] ans, int idx) {
		if(idx == arr.length) {
			for(int i=0; i<arr.length; i++) {
				if(!ans[i]) {
					System.out.print(arr[i]);
				}
			}
			System.out.println();
			return;
		}
		ans[idx] = true;
		powerSet(ans, idx+1);
		ans[idx] = false;
		powerSet(ans, idx+1);
	}
	
	static void perm(char[] ans, int idx) {
		if(idx == ans.length) {
			System.out.println(Arrays.toString(ans));
			return;
		}
		for(int i=0; i<ans.length; i++) {
			if(!check[i]) {
				ans[idx] = arr[i];
				check[i] = true;
				perm(ans, idx+1);
				check[i] = false;
				
			}
		}
	}
	
	static void rePerm(char[] ans, int idx) {
		if(idx == arr.length) {
			System.out.println(Arrays.toString(ans));
			return;
		}
		for(int i=0; i<arr.length; i++) {
			ans[idx] = arr[i];
			rePerm(ans, idx+1);
			
		}
	}
	
	static void comb(char[] ans, int idx, int r) {
		if(r == ans.length) {
			System.out.println(Arrays.toString(ans));
			return;
		}
		if(idx == arr.length) return;
		ans[r] = arr[idx];
		comb(ans, idx+1, r+1);
		comb(ans, idx+1, r);
	}
	
	static void reComb(char[] ans, int idx, int r) {
		if(r == ans.length) {
			System.out.println(Arrays.toString(ans));
			return;
		}
		if(idx == arr.length) return;
		ans[r] = arr[idx];
		reComb(ans, idx, r+1);
		reComb(ans, idx+1, r);
	}
}
