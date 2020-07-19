package TIL_0719;
import java.util.*;
//M : 60 S, H  : 60*60
public class Solution_D3_7732_시간개념 {
	static int T;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			String start = sc.next();
			StringTokenizer st = new StringTokenizer(start, ":");
			int H = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int S = Integer.parseInt(st.nextToken());
			int start_int = 3600*H + 60*M + S;
			String end = sc.next();
			st = new StringTokenizer(end, ":");
			H = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			S = Integer.parseInt(st.nextToken());
			int end_int = 3600*H + 60*M + S;
			if(end_int >= start_int) {
				int ans = end_int - start_int;
				String s = "";
				if((ans/3600) / 10 == 0) {
					s+="0";
				}
				s+=ans/3600+"";
				s+=":";
				ans -= ans/3600 * 3600;
				if((ans/60) / 10 == 0) {
					s+="0";
				}
				s+=ans/60+"";
				s+=":";
				ans -= ans/60 * 60;
				if(ans / 10 == 0) {
					s+="0";
				}
				s+=ans+"";
				System.out.println("#"+tc+" "+s);
			}
			else {
				int jojeong = 86400-start_int;
				start_int = 0;
				int ans = end_int - start_int+jojeong;
				String s = "";
				if((ans/3600) / 10 == 0) {
					s+="0";
				}
				s+=ans/3600+"";
				s+=":";
				ans -= ans/3600 * 3600;
				if((ans/60) / 10 == 0) {
					s+="0";
				}
				s+=ans/60+"";
				s+=":";
				ans -= ans/60 * 60;
				if(ans / 10 == 0) {
					s+="0";
				}
				s+=ans+"";
				System.out.println("#"+tc+" "+s);
			}
		}
	}
}
