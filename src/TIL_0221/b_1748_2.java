package TIL_0221;

import java.util.*;
public class b_1748_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		long now = Long.parseLong(str);
		long kizun = (long) Math.pow(10, str.length()-1);
		int len = str.length();
		long sum = 0;
		while(kizun != 0) {
			sum+= (now - kizun + 1)*len;
			now = kizun-1;
			kizun/=10;
			len-=1;
		}
		System.out.println(sum);
	}
}

