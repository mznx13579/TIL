package TIL_0706;

import java.util.*;

public class Main_bj_13549_숨바꼭질3 {
	static int N, K;
	static int[] arr = new int[100001];
	static boolean[] visited = new boolean[100001];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		ArrayDeque<Integer> q = new ArrayDeque<>();
		q.addFirst(N);
		visited[N] = true;
		while(!q.isEmpty()) {
			int x = q.poll();
			if(x==K) break;
			if((x * 2 <= 100000) && visited[2*x] == false) {
				q.addFirst(2*x);
				arr[2*x] = arr[x];
				visited[2*x] = true;
			}
			if(x-1>=0 && visited[x-1] == false) {
				q.addLast(x-1);
				arr[x-1] = arr[x]+1;
				visited[x-1] = true;
			}
			if(x+1 <= 100000 && visited[x+1] == false) {
				q.addLast(x+1);
				arr[x+1] = arr[x]+1;
				visited[x+1] = true;
			}
		}
		System.out.println(arr[K]);
	}
}
