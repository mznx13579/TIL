package TIL_0308;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class goodMorning1 {
	static int gcd(int x, int y) {
		if(y == 0) return x;
		else return gcd(y, x%y);
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		System.out.println(gcd(a,b));
		System.out.println(a * b / gcd(a,b));
	}
}
