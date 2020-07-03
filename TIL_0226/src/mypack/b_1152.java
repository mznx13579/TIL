package mypack;

import java.util.*;

public class b_1152 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine().trim();
		String[] ans = str.split(" ");
		if(str.isEmpty()) System.out.println(0); 
		else System.out.println(ans.length);
	}
}
