package baekjoon;

import java.util.*;

public class b_9663 {
	static boolean[][] arr;
	static int n;
	static int cnt;
	static int[] dr = {-1,-1,-1};
	static int[] dc = {-1,0,1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		arr = new boolean[n][n];
		go(0);
		System.out.println(cnt);
	}
	static void go(int idx) {
		if(idx == n) {
			cnt++;
			return;
		}
		for(int i=0; i<n; i++) {
			if(isPossible(idx, i)) {
				arr[idx][i] = true;
				go(idx+1);
				arr[idx][i] = false;
			}
		}
	}
	static boolean isPossible(int r, int c) {
		//내 위로 퀸이 있는지 검사. 퀸을 만나면 return false;
		for(int i=r; i>=0; i--) {
			if(arr[i][c] == true) return false;
		}
		//내 왼쪽 위로 퀸이 있는지 검사
		for(int i=r, j=c; i>=0 && j>=0; i--, j--) {
			if(arr[i][j] == true) return false;
		}
		//내 오른쪽 위로 퀸이 있는지 검사
		for(int i=r, j=c; i>=0 && j<arr[i].length; i--, j++) {
			if(arr[i][j] == true) return false;
		}
		return true;
	}
}
