package TIL_0722;
import java.util.*;

public class Main_bj_9019_DSLR {
	static int T, A, B;
	static boolean[] visited;
	static char[] commend;
	static int[] from;
	static Queue<Integer> q;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			visited = new boolean[10000];
			commend = new char[10000];
			from = new int[10000];
			q = new LinkedList<Integer>();
			A = sc.nextInt();
			B = sc.nextInt();
			visited[A] = true;
			commend[A] = 'x';
			from[A] = -1;
			q.add(A);
			String ans = "";
			L :while(!q.isEmpty()) {
				int x = q.poll();
				if( x == B) {
					int now = x;
					while(true) {
						ans+=commend[now]+"";
						now = from[now];
						if(now == -1) {
							ans = ans.substring(0,ans.length()-1);
							break L;
						}
					}
				}
				//D
				int target = x * 2;
				if( target > 9999) target %= 10000;
				if(!visited[target]) {
					visited[target] = true;
					commend[target] = 'D';
					from[target] = x;
					q.add(target);
				}
				//S
				target = x-1;
				if(target == -1) target = 9999;
				if(!visited[target]) {
					visited[target] = true;
					commend[target] = 'S';
					from[target] = x;
					q.add(target);
				}
				//L
				target = (x%1000)*10 + x/1000;
				if(!visited[target]) {
					visited[target] = true;
					commend[target] = 'L';
					from[target] = x;
					q.add(target);
				}
				//R
				target = (x/10) + (x%10)*1000;
				if(!visited[target]) {
					visited[target] = true;
					commend[target] = 'R';
					from[target] = x;
					q.add(target);
				}
			}
			String x = "";
			for(int i=ans.length()-1; i>=0; i--) {
				x+=ans.charAt(i)+"";
			}
			System.out.println(x);
		}
	}
}
/*
 * D: 2배로 바꾸고 9999보다 클떄는 10000으로 나눈 나머지 
 * S: N-1, 0일땐 9999가 저장
 * L: 1 2 3 4 -> 2 3 4 1, 1000 -> 0001
 * R: 1 2 3 4 -> 4 1 2 3, 1000 -> 0100
 * */
 