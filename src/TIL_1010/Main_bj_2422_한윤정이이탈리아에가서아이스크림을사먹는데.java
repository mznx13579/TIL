package TIL_1010;
import java.util.*;

public class Main_bj_2422_한윤정이이탈리아에가서아이스크림을사먹는데 {
	static int N, M;
	static int[] arr;
	static int answer;
	static class Pair {
		int x, y;
		public Pair(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	static ArrayList<Pair> al;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N];
		al = new ArrayList<Pair>();
		answer = 0;
		for(int i=0; i<M; i++) {
			int a, b;
			a  = sc.nextInt();
			b = sc.nextInt();
			a--; b--;
			if(a > b) {
				int tmp = a;
				a = b;
				b = tmp;
			}
			al.add(new Pair(a,b));
		}
		for(int i=0; i<N; i++) {
			arr[i] = i;
		}
		Combination(new int[3], 0, 0);
		System.out.println(answer);
	}
	private static void Combination(int[] ans, int idx, int r) {
		if(r == ans.length) {
			boolean isOK = true;
			for(Pair p : al) {
				int cnt = 0;
				int q = p.x; int w = p.y;
				for(int i=0; i<3; i++) {
					if(cnt == 0 && q == ans[i]) {
						cnt++;
						continue;
					}
					if(cnt == 1 && w == ans[i]) {
						cnt++;
					}
				}
				if(cnt == 2) {
					isOK = false;
					break;
				}
			}
			if(isOK == true) answer++;
			return;
		}
		if(idx == arr.length) return;
		ans[r] = arr[idx];
		Combination(ans, idx+1, r+1);
		Combination(ans, idx+1, r);
	}
}
