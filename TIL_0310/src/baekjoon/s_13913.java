package baekjoon;


import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class s_13913 {

	/*
	 * BFS
	 * 배열 100000
	 * 포인트가 가지는 인자는 
	 * 지금위치는 배열의 인덱스, 인자는 시간, 직전위치 시작은 -1로 하는게 좋을듯
	 * 각 포인트가 간적없으면 시간더하고
	 * 원하는 위치가 나오면 브레이크 한다음에
	 * 시작위치 나올떄까지 돌아감
	 * 아니면 스트링을 붙혀버리는거도 괜찮을듯 << 이걸로 ㄱ ㄱ  << 시간초과
	 * 왔던길 기록하는 배열 <<이걸로 ㄱ ㄱ 
	 */
	static int N;
	static int K;
	static class Point {
		int now;
		int t;
		Point(int now, int t){
			this.now = now;
			this.t = t;
		}
	}
	static boolean[] arr;
	static int[] from;
	static Queue<Point> q = new LinkedList<>();
	static ArrayList<Integer> al = new ArrayList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		arr = new boolean[100001];
		from = new int[100001];
		arr[N] = true;
		from[N] = -1;
		q.add(new Point(N, 0));
		while(!q.isEmpty()) {
			Point p = q.poll();
			if(p.now == K) {
				System.out.println(p.t);
				int x = from[K];
				al.add(K);
				while(x != -1) {
					al.add(x);
					x = from[x];
				}
				Collections.reverse(al);
				for(int ans : al) {
					System.out.print(ans+" ");
				}
				break;
			}
			if(0<=p.now-1 && arr[p.now-1] == false) {
				arr[p.now-1] = true;
				from[p.now-1] = p.now;
				q.add(new Point(p.now-1, p.t+1));
			}
			if(p.now+1<=100000 && arr[p.now+1] == false) {
				arr[p.now+1] = true;
				from[p.now+1] = p.now;
				q.add(new Point(p.now+1, p.t+1));
			}
			if(p.now*2<=100000 && arr[p.now*2] == false) {
				arr[p.now*2] = true;
				from[p.now*2] = p.now;
				q.add(new Point(p.now*2, p.t+1));
			}
		}
	}
}
