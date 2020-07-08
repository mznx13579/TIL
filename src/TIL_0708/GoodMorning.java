package TIL_0708;

import java.util.*;

public class GoodMorning {
	static int[] arr = {1,2,3};
	static boolean[] check = new boolean[arr.length];
	public static void main(String[] args) {
		System.out.println("Subset");
		Subset(new boolean[arr.length], 0);
		
		System.out.println("Permutation");
		Permutation(new int[arr.length], 0);
		
		System.out.println("Repermutation");
		Repermutation(new int[arr.length], 0);
		
		System.out.println("Combination");
		Combination(new int[arr.length-1], 0, 0);
		
		System.out.println("Recombination");
		Recombination(new int[arr.length-1], 0, 0);
	}
	private static void Recombination(int[] ans, int idx, int r) {
		if(r == ans.length) {
			System.out.println(Arrays.toString(ans));
			return;
		}
		if(idx == arr.length) return;
		ans[r] = arr[idx];
		Recombination(ans, idx, r+1);
		Recombination(ans, idx+1, r);
	}
	private static void Combination(int[] ans, int idx, int r) {
		if(r == ans.length) {
			System.out.println(Arrays.toString(ans));
			return;
		}
		if(idx == arr.length) return;
		ans[r] = arr[idx];
		Combination(ans, idx+1, r+1);
		Combination(ans, idx+1, r);
	}
	private static void Repermutation(int[] ans, int idx) {
		if(idx == ans.length) {
			System.out.println(Arrays.toString(ans));
			return;
		}
		for(int i=0; i<ans.length; i++) {
			ans[idx] = arr[i];
			Repermutation(ans, idx+1);
		}
	}
	private static void Permutation(int[] ans, int idx) {
		if(idx == ans.length) {
			System.out.println(Arrays.toString(ans));
			return;
		}
		for(int i=0; i<ans.length; i++) {
			if(!check[i]) {
				check[i] = true;
				ans[idx]=arr[i];
				Permutation(ans, idx+1);
				check[i] = false;
			}
		}
	}
	private static void Subset(boolean[] ans, int idx) {
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
		Subset(ans, idx+1);
		ans[idx] = false;
		Subset(ans, idx+1);
	}
}
