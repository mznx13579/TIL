package TIL_0725;
import java.util.*;
public class Solution_D3_7675_통역사성경이 {
	static int T, N;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			int[] ans = new int[N];
			int n = 0;
			int cnt = 0;
			while(true) {
				if(n == N) break;
				String str = sc.next();
				boolean flag = false;
				if(str.charAt(str.length()-1) == '!'
						|| str.charAt(str.length()-1) == '?'
						|| str.charAt(str.length()-1) == '.') 
					flag = true;
				boolean itIsName = false;
				if(65<=str.charAt(0) && str.charAt(0)<=90) itIsName = true;
				if(itIsName == false && flag == false) continue;
				if(flag == false && str.length()>1) {
					for(int i=1; i<str.length(); i++) {
						if(str.charAt(i)<97 || str.charAt(i)>122) {
							itIsName= false;
							break;
						}
					}
				} else {
					for(int i=1; i<str.length()-1; i++) {
						if(str.charAt(i)<97 || str.charAt(i)>122) {
							itIsName = false;
							break;
						}
					}
				}
				if(itIsName == true) cnt++;
				if(flag == true) {
					ans[n] = cnt;
					n++; cnt = 0;
				}
			}
			System.out.print("#"+tc+" ");
			for(int i=0; i<N; i++) {
				System.out.print(ans[i]+" ");
			}
			System.out.println();
		}
	}
}
