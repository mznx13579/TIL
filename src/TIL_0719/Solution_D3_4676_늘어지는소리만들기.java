package TIL_0719;
import java.util.*;
public class Solution_D3_4676_늘어지는소리만들기 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			String str = sc.next();
			int H = sc.nextInt();
			ArrayList<Integer> al = new ArrayList<>();
			for(int h = 0; h < H; h++) {
				al.add(sc.nextInt());
			}
			Collections.sort(al);
			String ans = "";
			for(int i=0; i<=str.length(); i++) {
				if(al.size()!=0 && al.get(0) == i) {
					while(true) {
						if(al.size() == 0) break;
						int x = al.get(0);
						if(x != i) break;
						ans += "-";
						al.remove(0);
					}
				}
				if(i != str.length()) {
					ans += str.charAt(i)+"";
				}
			}
			System.out.println("#"+tc+" "+ans);
		}
	}
}
