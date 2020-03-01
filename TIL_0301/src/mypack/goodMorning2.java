package mypack;
import java.util.*;

public class goodMorning2 {
	static boolean next_permutation(int[] arr) {
		int i = arr.length-1;
		while(i>0 && arr[i-1] >= arr[i]) i-=1;
		if(i<=0) return false;
		int j = arr.length-1;
		while(arr[i-1] >= arr[j]) j-=1;
		swap(arr,i-1, j);
		j = arr.length-1;
		while(i<j) {
			swap(arr,i, j);
			i+=1;
			j-=1;
		}
		return true;
	}
	static boolean prev_permutation(int[] arr) {
		int i = arr.length-1;
		while(i>0 && arr[i-1] <= arr[i]) i-=1;
		if(i<=0) return false;
		int j = arr.length-1;
		while(arr[i-1] <= arr[j]) j-=1;
		swap(arr, i-1, j);
		j = arr.length-1;
		while(i<j) {
			swap(arr, i, j);
			i+=1;
			j-=1;
		}
		return true;
	}
	
	static void swap(int[] arr, int x, int y) {
		int tmp = arr[x];
		arr[x] = arr[y];
		arr[y] = tmp;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		next_permutation(arr);
		System.out.println(Arrays.toString(arr));
		prev_permutation(arr);
		System.out.println(Arrays.toString(arr));
		
		do {
			System.out.println(Arrays.toString(arr));
		} while (next_permutation(arr));
	}
}
