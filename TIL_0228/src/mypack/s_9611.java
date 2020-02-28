package mypack;

import java.util.*;

public class s_9611 {
	static int[] check;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			check = new int[10];
			int n = sc.nextInt();
			for(int i=0; i<n; i++) {
				int[] tmp = new int[4];
				for(int j=0; j<4; j++) {
					tmp[j] = sc.nextInt();
				}
				String str = sc.next();
				if(str.equals("NO")) {
					for(int j=0; j<4; j++) {
						check[tmp[j]]--;
					}
				}
				else if(str.equals("YES")){
					for(int j=0; j<4; j++) {
						check[tmp[j]]++;
					}
				}
			}
			int max =-1;
			int max_index = 0;
			for(int i=0; i<10; i++) {
				if(max < check[i]) {
					max = check[i];
					max_index = i;
				}
			}
			System.out.println("#"+tc+" "+max_index);
		}
	}
}
