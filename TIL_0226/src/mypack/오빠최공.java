package mypack;

import java.util.*;

public class 오빠최공 {
	public static int gcd(int x, int y) { //최대공약
		if(y==0) return x;
		else return gcd(y, x%y);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int g = gcd(a,b);
		int l = a * b / g; //<< 최소공배수
		System.out.println(g);
		System.out.println(l);
	}
}
