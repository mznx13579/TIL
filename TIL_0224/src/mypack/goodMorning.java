package mypack;

import java.util.*;

public class goodMorning {
	static char[] arr = {'A','B','C'};
	static boolean[] visited = new boolean[arr.length];
	
	public static void main(String[] args) {
		System.out.println("PowerSet");
		PowerSet(new boolean[arr.length], 0);
		
		System.out.println("Permutation");
		Permutation(new char[arr.length], 0);
		
		System.out.println("Repermutation");
		Repermutation(new char[arr.length], 0);
		
		System.out.println("Combination");
		Combination(new char[arr.length-1], 0, 0);
		
		System.out.println("Recombination");
		Recombination(new char[arr.length-1], 0, 0);
		
	}
	
	static void PowerSet(boolean[] ans, int idx) {
		if(idx == ans.length) {
			for(int i=0; i<ans.length; i++) {
				if(!ans[i]) {
					System.out.print(arr[i]+" ");
				}
			}
			System.out.println();
			return;
		}
		ans[idx] = true;
		PowerSet(ans, idx+1);
		ans[idx] = false;
		PowerSet(ans, idx+1);
	}
	
	static void Permutation(char[] ans, int idx) {
		if(idx == ans.length) {
			System.out.println(Arrays.toString(ans));
			return;
		}
		for(int i=0; i<arr.length; i++) {
			if(!visited[i]) {
				visited[i] = true;
				ans[idx] = arr[i];
				Permutation(ans, idx+1);
				visited[i] = false;
			}
		}
	}
	
	static void Repermutation(char[] ans, int idx) {
		if(idx == ans.length) {
			System.out.println(Arrays.toString(ans));
			return;
		}
		for(int i=0; i<arr.length; i++) {
			ans[idx] = arr[i];
			Repermutation(ans, idx+1);
		}
	}
	
	static void Combination(char[] ans, int idx, int r) {
		if(r == ans.length) {
			System.out.println(Arrays.toString(ans));
			return;
		}
		if(idx == arr.length) return;
		ans[r] = arr[idx];
		Combination(ans, idx+1, r+1);
		Combination(ans, idx+1, r);
	}
	
	static void Recombination(char[] ans, int idx, int r) {
		if(r == ans.length) {
			System.out.println(Arrays.toString(ans));
			return;
		}
		if(idx == arr.length) return;
		ans[r] = arr[idx];
		Recombination(ans, idx, r+1);
		Recombination(ans, idx+1, r);
	}
}
