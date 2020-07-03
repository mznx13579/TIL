package swexpert;

import java.util.*;

public class s_6692 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt();
			double sum = 0.0;
			for(int i=0; i<n; i++) {
				double p = sc.nextDouble();
				double x = sc.nextDouble();
				sum += p*x;
			}
			System.out.println("#"+tc+" "+sum);
		}
	}
}
/*TEsT2222*/
