package mypack;

import java.util.Arrays;
import java.util.Scanner;

public class permutation {
	public static boolean next_permutation(int[] a) {
		int i = a.length-1; //i를 최대 인덱스로 두고 
		while(i>0 && a[i-1] >= a[i]) i-=1; // 이전것이 더 클떄까지 줄임
		if(i<=0) return false; // 0보다 작거나 같아지면 return false;
		int j = a.length-1;
		while(a[i-1] >= a[j]) j-=1;//위에서 찾은 i 보다 1적은 칸 이 클뗴까
		
		int temp = a[i-1];
        a[i-1] = a[j];
        a[j] = temp; //이제 찾은두개를 바꿈
		j = a.length-1;
		while(i<j) {
			temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i += 1;
            j -= 1;
		}
		return true;
	}
	
	public static boolean prev_permutation(int[] a) {
		int i = a.length-1;
		while(i>0 && a[i-1] <= a[i]) i-=1;
		if(i<=0) return false;
		int j = a.length-1;
		while(a[i-1] <= a[j]) j-=1; //방향만 다름 위에랑
		
		swap(a, i-1, j);//똑같은데 스왑을 썻을 때임  
		j = a.length-1;
        while (i < j) {
            swap(a, i, j);
            i += 1;
            j -= 1;
        }
        return true;
	}
	
	static void swap(int[] a, int x, int y) {
		int temp = a[x];
		a[x] = a[y];
		a[y] = temp;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		for(int i=0; i<n; i++) a[i] = sc.nextInt();
		
		Arrays.sort(a);//sort해주는 이유는 무작위로들어 왔을 경우이고 그게 아니면 안해줘도됩니
	
		System.out.println("바로 다음 순열");
		next_permutation(a);
		for (int i=0; i<n; i++) {
            System.out.print(a[i] + " ");
        }
		System.out.println();
		
		System.out.println("바로 이전 순열");
		prev_permutation(a);
		for (int i=0; i<n; i++) {
            System.out.print(a[i] + " ");
        }
		System.out.println();
		
		System.out.println("모든 순열");
		do {
			for(int i=0; i<n; i++) {
				System.out.print(a[i]+" ");
			}
			System.out.println();
		} while(next_permutation(a));
		
	}
}
