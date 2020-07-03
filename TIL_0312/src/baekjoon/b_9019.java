package baekjoon;
/*
 * D, S, L, R
 * 0-9999까지 4자릿수를 나타냄
 * d1 d2 d3 d4
 * int number = (((d1*10+d2)*10+d3)*10+d4); 임
 * D : number *2; if number >9999 , mod 10000
 * S : number -1; if number == -1 , number = 9999;
 * L : ((((d2*10)+d3)*10+d4)*10+d1);
 * R : ((((d4*10)+d1)*10+d2)*10+d3);
 * 
 * A->B로 하기 위한 명령어는?
 * 어디서 왔는지, 어떻게 왔는지를 저장
 * 
 */

import java.util.*;
public class b_9019 {
	static int T;
	static int[] from;
	static char[] how;
	static Queue<Integer> q;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for(int tc = 1; tc <=T; tc++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			from = new int[10000];
			how = new char[10000];
			q = new LinkedList<>();
			Arrays.fill(from, -1);
			from[A] = -2;
			how[A] = ' ';
			q.add(A);
			while(!q.isEmpty()) {
				int now = q.poll();
				if(now == B) {
					String str = "";
					while( B != A) {
						str += how[B];
						B = from[B];
					}
					for(int i=str.length()-1; i>=0; i--) {
						System.out.print(str.charAt(i));
					}
					System.out.println();
					break;
					
					
				}
				if(from[(now*2)%10000] == -1) {
					from[(now*2)%10000] = now;
					how[(now*2)%10000] = 'D';
					q.add((now*2)%10000);
				}
				if(now-1 == -1) {
					if(from[9999] == -1) {
						from[9999] = now;
						how[9999] = 'S';
						q.add(9999);
					}
				}
				else {
					if(from[now-1] == -1) {
						from[now-1] = now;
						how[now-1] = 'S';
						q.add(now-1);
					}
				}
				int left = (now%1000)*10 + now/1000;
				if(from[left] == -1) {
					from[left] = now;
					how[left] = 'L';
					q.add(left);
				}
				int right = (now/10) + (now%10)*1000;
				if(from[right] == -1) {
					from[right] = now;
					how[right] = 'R';
					q.add(right);
				}
			}
		}
	}
	/*
	static int[] makeDs(int num) {
		int[] tmp = {0,0,0,0};
		int len = (int) Math.log10(num)+1;
		for(int i=0; i<len; i++) {
			tmp[3-i] = num%10;
			num/=10;
		}
		return tmp;
	}
	static int makeLeft(int[] ds) {
		return ((((ds[1]*10)+ds[2])*10+ds[3])*10+ds[0]);
	}
	static int makeRight(int[] ds) {
		return ((((ds[3]*10)+ds[0])*10+ds[1])*10+ds[2]);
	}*/
}