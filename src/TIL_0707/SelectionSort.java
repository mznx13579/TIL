package TIL_0707;
import java.util.*;
public class SelectionSort {
	static int[] arr = {4,3,8,1,5,7,6,2};
	public static void main(String[] args) {
		Selection();
	}
	private static void Selection() {
		for(int i=0; i<arr.length; i++) {
			int x = 0;
			int min = Integer.MAX_VALUE;
			for(int j=i; j<arr.length; j++) {
				if(min > arr[j]) {
					min = arr[j];
					x=j;
				}
			}
			int tmp = arr[i];
			arr[i] = arr[x];
			arr[x] = tmp;
		}
		System.out.println(Arrays.toString(arr));
	}
}
