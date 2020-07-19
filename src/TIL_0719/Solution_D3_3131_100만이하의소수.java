package TIL_0719;
import java.util.*;

public class Solution_D3_3131_100만이하의소수 {
	public static void main(String[] args) {
		boolean[] arr = new boolean[1000001];
		StringBuilder sb = new StringBuilder();
		for(int i=2; i<=1000000; i++) {
			if(arr[i] == false) sb.append(i).append(" ");
			for(int j=i+i; j<=1000000; j+=i) {
				arr[j] = true;
			}
		}
		System.out.println(sb);
	}
}
