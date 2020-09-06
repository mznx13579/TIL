package TIL_0906;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main_bj_12886_돌그룹 {
	static class Pair {
		int A, B;
		public Pair(int a, int b) {
			super();
			A = a;
			B = b;
		}
	}
	static boolean[][] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int ans = 0;
		int sum = A+B+C;
		int dochak = sum/3;
		visited = new boolean[1501][1501];
		if(sum % 3 != 0) System.out.println(0);
		else {
			Queue<Pair> q = new LinkedList<>();
			visited[A][B] = true;
			q.add(new Pair(A, B));
			while(!q.isEmpty()) {
				Pair p = q.poll();
				if(p.A == dochak && p.B == dochak) {
					ans = 1;
					break;
				}
				int[] arr = {p.A, p.B, sum-p.A-p.B};
				for(int i=0; i<3; i++) {
					for(int j=0; j<3; j++) {
						if(arr[i] < arr[j]) {
							int[] x = {p.A, p.B, sum-p.A-p.B};
							x[i] += arr[i];
							x[j] -= arr[i];
							if(!visited[x[i]][x[j]]) {
								visited[x[i]][x[j]] = true;
								q.add(new Pair(x[i],x[j]));
							}
						}
					}
				}
			}
			System.out.println(ans);
		}
	}
	
}
/*
 *a.b.c개
 *모든 그룹에 있는 돌의 개수 같게
 *크기가 같지 않은 두그룹
 *작은 쪽 X, 큰쪽 Y
 *X + X, Y - X;
 *같은 돌로 만들 수 있으면 1 아니면 0
 *10 15 35
 *10 , 15 35
 *15 + 15 45 - 15
 * */