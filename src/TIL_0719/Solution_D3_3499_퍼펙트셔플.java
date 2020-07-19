package TIL_0719;
import java.util.*;
public class Solution_D3_3499_퍼펙트셔플 {
	static int T, N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			Queue<String> q = new LinkedList<String>();
			Queue<String> q1 = new LinkedList<String>();
			Queue<String> q2 = new LinkedList<String>();
			for(int i=0; i<N; i++) {
				q.add(sc.next());
			}
			if(N % 2 == 0) {
				for(int i=0; i<N/2; i++) {
					q1.add(q.poll());
				}
				while(!q.isEmpty()) {
					q2.add(q.poll());
				}
			}
			else {
				for(int i=0; i<=N/2; i++) {
					q1.add(q.poll());
				}
				while(!q.isEmpty()) {
					q2.add(q.poll());
				}
			}
			System.out.print("#"+tc+" ");
			while(true) {
				if(!q1.isEmpty()) {
					System.out.print(q1.poll()+" ");
				}
				if(!q2.isEmpty()) {
					System.out.print(q2.poll()+" ");
				}
				if(q1.isEmpty()&& q2.isEmpty()) break;
			}
			System.out.println();
		}
	}
}
