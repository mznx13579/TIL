package TIL_0707;
import java.util.*;

public class BubbleSort {
	static int[] arr = {4,3,8,1,5,7,6,2};
	public static void main(String[] args) {
		Bubble();
	}
	private static void Bubble() {
		for(int i=arr.length-1; i>=0; i--) {
			for(int j=0; j<i; j++) {
				if(arr[j] > arr[j+1]) {
					int tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
	}
}
