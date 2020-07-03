package mypack;

import java.util.*;
public class goodMorning {
	static char[] arr = {'A','B','C'};
	public static void main(String[] args) {
		System.out.println("subset");
		subset(new boolean[arr.length], 0);
		
		System.out.println("permutation");
		permutation(new char[arr.length], new boolean[arr.length], 0);
		
		System.out.println("repermutation");
		repermutation(new char[arr.length], 0);
		
		System.out.println("combinatipn");
		combination(new char[arr.length-1], 0, 0);
		
		System.out.println("recombination");
		recombination(new char[arr.length-1], 0, 0);
	}
	static void subset(boolean[] ans, int idx) {
		if(idx == arr.length) {
			for(int i=0; i<arr.length; i++) {
				if(!ans[i]) {
					System.out.print(arr[i]+" ");
				}
			}
			System.out.println();
			return;
		}
		ans[idx] = true;
		subset(ans, idx+1);
		ans[idx] = false;
		subset(ans, idx+1);
	}
	static void permutation(char[] ans, boolean[] visited, int idx) {
		if(idx == ans.length) {
			System.out.println(Arrays.toString(ans));
			return;
		}
		for(int i=0; i<ans.length; i++) {
			if(!visited[i]) {
				visited[i] = true;
				ans[idx] = arr[i];
				permutation(ans, visited, idx+1);
				visited[i] = false;
			}
		}
	}
	static void repermutation(char[] ans, int idx) {
		if(idx == ans.length) {
			System.out.println(Arrays.toString(ans));
			return;
		}
		for(int i=0; i<ans.length; i++) {
			ans[idx] = arr[i];
			repermutation(ans, idx+1);
		}
	}
	static void combination(char[] ans, int idx, int r) {
		if(r == ans.length) {
			System.out.println(Arrays.toString(ans));
			return;
		}
		if(idx == arr.length) return;
		ans[r] = arr[idx];
		combination(ans, idx+1, r+1);
		combination(ans, idx+1, r);
	}
	static void recombination(char[] ans, int idx, int r) {
		if(r == ans.length) {
			System.out.println(Arrays.toString(ans));
			return;
		}
		if(idx == arr.length) return;
		ans[r] = arr[idx];
		recombination(ans, idx, r+1);
		recombination(ans, idx+1, r);
	}
}
