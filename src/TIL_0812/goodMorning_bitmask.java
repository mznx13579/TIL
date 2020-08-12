package TIL_0812;

import java.util.Arrays;
import java.util.Scanner;

public class goodMorning_bitmask {
	static int N, R;
	static int[] input, number;
	static int totalCnt;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		input = new int[N];
		number = new int[R];
		
		for(int i=0; i<N; i++) {
			input[i] = sc.nextInt();
		}
		System.out.println("perm");
		permutation(0,0);
		
		number = new int[R];
		System.out.println("reperm");
		reperm(0,0);
		
		number = new int[R];
		System.out.println("comb");
		comb(0,0);
	}
	
	private static void permutation(int cnt, int flag) {
		if(cnt==R) {
			System.out.println(Arrays.toString(number));
			return;
		}
		for(int i=0; i<N; i++) {
			if((flag & 1<<i) != 0) continue;
			number[cnt] = input[i];
			permutation(cnt+1, flag | 1<<i);
		}
	}
	
	private static void reperm(int cnt, int flag) {
		if(cnt==R) {
			System.out.println(Arrays.toString(number));
			return;
		}
		for(int i=0; i<N; i++) {
			number[cnt] = input[i];
			reperm(cnt+1, flag | 1<<i);
		}
	}
	
	private static void comb(int cnt, int flag) {
		if(cnt==R) {
			totalCnt++;
			System.out.println(Arrays.toString(number));
			return;
		}
		for(int i=0; i<N; i++) {
			if((flag & 1<<i) != 0) continue;
			number[cnt] = input[i];
			comb(cnt+1, flag |= 1<<i);
		}
	}
}
