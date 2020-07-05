package TIL_0705;

import java.util.*;

public class Main_bj_11052_카드구매하기 {
	static int N;
	static int[] arr;
	static int[] card;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N+1];
		card = new int[N+1];
		for(int i=1; i<=N; i++) { arr[i] = sc.nextInt(); }
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=i; j++) {
				card[i] = Math.max(card[i], card[i-j] + arr[j]);
			}
		}
//		System.out.println(Arrays.toString(card));
		System.out.println(card[N]);
	}
}
