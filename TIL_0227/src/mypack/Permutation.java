package mypack;

import java.util.Arrays;
import java.util.Scanner;

public class Permutation {
	static boolean next_permutation(int[] a) {
		int i = a.length-1;
		while(i>0 && a[i-1] >= a[i]) i-=1;
		if(i<=0) return false;
		int j = a.length-1;
		while(a[i-1] >= a[j]) j-=1;
		swap(a, i-1, j);
		j = a.length-1;
		while(i<j) {
			swap(a,i,j);
			i+=1;
			j-=1;
		}
		return true;
	}
	static boolean prev_permutation(int[] a) {
		int i = a.length-1;
		while(i>0 && a[i-1] <= a[i]) i-=1;
		if(i<=0) return false;
		int j = a.length-1;
		while(a[i-1] <= a[j]) j-=1;
		swap(a, i-1, j);
		j = a.length-1;
		while(i<j) {
			swap(a,i,j);
			i+=1;
			j-=1;
		}
		return true;
	}
	static void swap(int[] a, int x, int y) {
		int tmp = a[x];
		a[x] = a[y];
		a[y] = tmp;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		for(int i=0; i<n; i++) a[i] = sc.nextInt();
		Arrays.sort(a);
		next_permutation(a);
		for(int i=0; i<n; i++) System.out.print(a[i]+" ");
		System.out.println();
		prev_permutation(a);
		for(int i=0; i<n; i++) System.out.print(a[i]+" ");
		System.out.println();
		do {
			for(int i=0; i<n; i++) System.out.print(a[i]+" ");
			System.out.println();
		} while (next_permutation(a));
	}
}
