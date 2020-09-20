import java.util.*;

public class l3 {
	public static void main(String[] args) {
		int n = 73425;
//		10007, 9, 0일때 예외처리
		int[] answer = new int[2];
		answer[0] = Integer.MAX_VALUE;
		if((int)(Math.log10(n)+1) == 1) {
			answer[0] = 0;
			answer[1] = n;
		}
		else if(n== 0) {
			answer[0] = 0;
			answer[1] = 0;
		}
		else {
			go(n, 0, answer);
		}
		System.out.println(answer[0]+" "+answer[1]);
	}

	private static void go(int n, int i, int[] answer) {
		if((int)(Math.log10(n)+1) == 1) {
			if(answer[0] > i) {
				answer[0] = i;
				answer[1] = n;
			}
			return;
		}
		String s = Integer.toString(n);
		for(int r=1; r<s.length(); r++) {
			String left = s.substring(0, r);
			String right = s.substring(r, s.length());
			if(right.charAt(0) == '0') continue;
			go(Integer.parseInt(left)+Integer.parseInt(right), i+1, answer);
		}
	}
}
