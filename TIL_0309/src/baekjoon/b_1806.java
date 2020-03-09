package baekjoon;

import java.util.*;

public class b_1806 {
	static int N, M;
	static int[] arr;
	public static void main(String[] args)  {
		 Scanner sc = new Scanner(System.in);
		 N = sc.nextInt();
		 M = sc.nextInt();
		 arr = new int[N+1];
		 for(int i=0; i<N; i++) arr[i] = sc.nextInt();
		 int left = 0;
		 int right = 0;
		 int sum = arr[0];
		 int min = N+1;
		 while(right < N && left < N) {
			 if(sum == M) {
				 int len = right+1 - left;
				 if(min > len) min = len;
				 right+=1;
				 sum+=arr[right];
			 }
			 else if(sum < M) {
				 right+=1;
				 sum+=arr[right];
			 }
			 else {
				 int len = right+1 - left;
				 if(min > len) min = len;
				 sum-=arr[left];
				 left+=1;
				 if(right < left) {
					 right = left;
					 sum = arr[left];
				 }
			 }
		 }
		 System.out.println(min == N+1 ? 0 : min);
	}
}

