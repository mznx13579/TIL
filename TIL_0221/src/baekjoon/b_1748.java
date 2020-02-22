package baekjoon;

import java.util.*;
public class b_1748 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		long now = Long.parseLong(str);
		int len = str.length();
		long sum = 0;
		for(int i=1; i<len; i++) {
			sum += (long) (9*Math.pow(10, i-1))*i;
		}
		sum += (now - Math.pow(10, len-1) +1)*len;
		System.out.println(sum);
	}
}
