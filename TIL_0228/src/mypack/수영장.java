package mypack;

import java.util.*;

public class 수영장 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc<=T; tc++) {
			int[] cost = new int[4];
			for(int i=0; i<4; i++) cost[i] = sc.nextInt();
			int[] plan = new int[13];
			for(int i=1; i<=12; i++) plan[i] = sc.nextInt();
			int[] oneMonth = new int[13];
			for(int i=1; i<=12; i++) oneMonth[i] = Math.min(cost[1], plan[i] * cost[0]);
			int[] threeMonth = new int[13];
			for(int i=1; i<=12; i++) {
				threeMonth[i] = threeMonth[i-1] + oneMonth[i];
				if(i - 3 >=0) {
					if(threeMonth[i] > threeMonth[i-3] + cost[2])
						threeMonth[i] = threeMonth[i-3] + cost[2];
				}
			}
			int ans = Math.min(threeMonth[12], cost[3]);
			System.out.println("#"+tc+" "+ans);
		}
	}
}