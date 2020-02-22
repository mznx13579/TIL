package swexpert;

import java.util.*;

public class s_8931 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<Integer> s = new Stack<>();
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int k = sc.nextInt();
			for(int i=0; i<k; i++) {
				int n = sc.nextInt();
				if(n == 0) s.pop();
				else s.push(n);
			}
			int sum = 0;
			while(!s.isEmpty()) 
				sum += s.pop();
			System.out.println("#"+tc+" "+sum);
		}
	}
}
