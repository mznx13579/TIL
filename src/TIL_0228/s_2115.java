package TIL_0228;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class s_2115 {
	static int N, M, C;
	static int[][] map, maxMap;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			maxMap = new int[N][N];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			makeMaxMap();
			System.out.println("#"+t+" "+getMaxBenefit());
		}
	}

	private static void makeMaxMap() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<=N-M; j++) {
				makeMaxSubset(i, j, 0, 0, 0);
			}
		}
	}
	//i : 행위치, j : 열위치 , cnt :  고려한 원소수  
	//sum : 부분집합에  속한 원소의 합
	//powSum : 부분집합에 속한 원소의 이익
	private static void makeMaxSubset(int i, int j, int cnt, int sum, int powSum) {
		if(sum > C) return; //부분집합의 합이 목표량 C를 초과하면 리턴 
		if(cnt == M) {
			if(maxMap[i][j-M]<powSum) {
				maxMap[i][j-M] = powSum;
			}
			return;
		}
		//선택
		makeMaxSubset(i, j+1, cnt+1, sum+map[i][j], powSum+map[i][j]*map[i][j]);
		//비선택  
		makeMaxSubset(i, j+1, cnt+1, sum, powSum);
	}
	
	private static int getMaxBenefit() {
		int max = 0, temp = 0;
		//1. 일꾼 A 기준 선
		for(int i=0; i<N; i++) {
			for(int j = 0; j<=N-M; j++) {
				//2. 일꾼 B 선택  
				//같은 행 기준 선택 
				for(int j2 = j+M; j2<=N-M; j2++) {
					temp = maxMap[i][j] + maxMap[i][j2];
					if(max < temp) {
						max = temp;
					}
				}
				//다음 행부터 마지막행까지 선택
				for(int i2 = i+1; i2<N; i2++) {
					for(int j2 = 0; j2<=N-M; j2++) {
						temp = maxMap[i][j] + maxMap[i2][j2];
						if(max < temp) {
							max = temp;
						}
					}
				}
				
			}
		}
		return max;
	}
}
