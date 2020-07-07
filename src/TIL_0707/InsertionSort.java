package TIL_0707;
import java.util.*;
public class InsertionSort {	
	static int[] arr = {4,3,8,1,5,7,6,2};
	public static void main(String[] args) {
		Insertion();
	}
	private static void Insertion() {
		for(int i=1; i<arr.length; i++) {
			int pivot = arr[i];
			int index = i-1;
			while(index>=0 && pivot < arr[index]) {
				arr[index+1] = arr[index];
				index--;
			}
			arr[index+1] = pivot;
		}
		System.out.println(Arrays.toString(arr));
	}
}
