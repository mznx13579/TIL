package swexpert;

import java.util.*;

public class s_7985 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			System.out.print("#"+tc+" ");
			int k = sc.nextInt();
			int e = (int) (Math.pow(2, k)-1);
			int[] a = new int[e+1];
			for(int i=1; i<=e; i++) {
				a[i] = sc.nextInt();
			}
			a[0] = -1;
			int n = (e+1)/2;
			while(n != 0) {
				for(int i=0; i<=e; i+=n) {
					if(a[i] != -1) {
						System.out.print(a[i]+" ");
						a[i] = -1;
					}
				}
				n/=2;
				System.out.println();
			}
		}
	}
}