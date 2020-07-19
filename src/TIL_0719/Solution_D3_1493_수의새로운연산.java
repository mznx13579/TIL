package TIL_0719;
import java.util.*;
public class Solution_D3_1493_수의새로운연산 {
	static class Pair {
		int y, x;
		public Pair(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}
	static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		arr = new int[10001];
		arr[1] = 1;
		for(int i=2; i<=10000; i++) {
			arr[i] = arr[i-1] + i-1;
		}
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int p = sc.nextInt();
			int q = sc.nextInt();
			Pair[] box = new Pair[2];
			for(int k=0; k<2; k++) {
				int index_y = -1;
				for(int i=1; i<=10000; i++) {
					if(k==0 && arr[i] > p) {
						index_y = i-1; break;
					}
					if(k==1 && arr[i] > q) {
						index_y = i-1; break;
					}
				}
				
				int xx = arr[index_y];
				int chai = -1;
				if(k == 0) {
					chai = p-xx;
				}
				else {
					chai = q-xx;
				}
				int index_x = 1;
				for(int i=0; i<chai; i++) {
					index_y--;
					index_x++;
				}
				Pair pair = new Pair(index_y, index_x);
				box[k] = pair;
			}
			Pair coor = new Pair(box[0].y + box[1].y , box[0].x + box[1].x);
			int ans = arr[coor.y + coor.x - 1];
			ans += box[0].x + box[1].x -1;
			System.out.println("#"+tc+" "+ans);
		}
	}
}
