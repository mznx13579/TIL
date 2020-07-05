package TIL_0705;

import java.util.*;
public class Main_bj_16194_카드구매하기2 {
	static int N;
	static int[] arr;
	static int[] card;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N+1];
		card = new int[N+1];
		for(int i=1; i<=N; i++) {
			arr[i] = sc.nextInt();
		}
		for(int i=1; i<=N; i++) {
			card[i] = 1000*10000;
		}
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=i; j++) {
				card[i] = Math.min(card[i], card[i-j] + arr[j]);
			}
		}
		System.out.println(card[N]);
	}
}
