package TIL_0911;
import java.util.*;
public class Main_bj_14891_톱니바퀴 {
	static Deque<Integer> t1, t2, t3, t4;
	public static void main(String[] args) {
		t1 = new ArrayDeque<Integer>();
		t2 = new ArrayDeque<Integer>();
		t3 = new ArrayDeque<Integer>();
		t4 = new ArrayDeque<Integer>();
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		for(int i=0; i<str.length(); i++) t1.add(Integer.parseInt(str.charAt(i)+""));
		str = sc.next();
		for(int i=0; i<str.length(); i++) t2.add(Integer.parseInt(str.charAt(i)+""));
		str = sc.next();
		for(int i=0; i<str.length(); i++) t3.add(Integer.parseInt(str.charAt(i)+""));
		str = sc.next();
		for(int i=0; i<str.length(); i++) t4.add(Integer.parseInt(str.charAt(i)+""));
		int K = sc.nextInt();
		for(int k=0; k<K; k++) {
			int[] arr = {7,7,7,7,7};
			int x = sc.nextInt();
			int y = sc.nextInt();
			arr[x] = y;
			if(x == 1) {
				Object[] tmp1 = t1.toArray();
				Object[] tmp2 = t2.toArray();
				Object[] tmp3 = t3.toArray();
				Object[] tmp4 = t4.toArray();
				if(tmp1[2] == tmp2[6]) arr[2] = 0;
				else arr[2] = -arr[1];
				if(tmp2[2] == tmp3[6]) arr[3] = 0;
				else arr[3] = -arr[2];
				if(tmp3[2] == tmp4[6]) arr[4] = 0;
				else arr[4] = -arr[3];
			}
			else if( x == 4) {
				Object[] tmp1 = t1.toArray();
				Object[] tmp2 = t2.toArray();
				Object[] tmp3 = t3.toArray();
				Object[] tmp4 = t4.toArray();
				if(tmp4[6] == tmp3[2]) arr[3] = 0;
				else arr[3] = -arr[4];
				if(tmp3[6] == tmp2[2]) arr[2] = 0;
				else arr[2] = -arr[3];
				if(tmp2[6] == tmp1[2]) arr[1] = 0;
				else arr[1] = -arr[2];
			}
			else if(x == 2) {
				Object[] tmp1 = t1.toArray();
				Object[] tmp2 = t2.toArray();
				Object[] tmp3 = t3.toArray();
				Object[] tmp4 = t4.toArray();
				if(tmp2[6] == tmp1[2]) arr[1] = 0;
				else arr[1] = -arr[2];
				if(tmp2[2] == tmp3[6]) arr[3] = 0;
				else arr[3] = -arr[2];
				if(tmp3[2] == tmp4[6]) arr[4] = 0;
				else arr[4] = -arr[3];
			}
			else if(x==3) {
				Object[] tmp1 = t1.toArray();
				Object[] tmp2 = t2.toArray();
				Object[] tmp3 = t3.toArray();
				Object[] tmp4 = t4.toArray();
				if(tmp3[2] == tmp4[6]) arr[4] = 0;
				else arr[4] = -arr[3];
				if(tmp3[6] == tmp2[2]) arr[2] = 0;
				else arr[2] = -arr[3];
				if(tmp2[6] == tmp1[2]) arr[1] = 0;
				else arr[1] = -arr[2];
			}
			if(arr[1] == -1) {
				int m = t1.pollFirst();
				t1.addLast(m);
			}else if(arr[1] ==1) {
				int m = t1.pollLast();
				t1.addFirst(m);
			}
			if(arr[2] == -1) {
				int m = t2.pollFirst();
				t2.addLast(m);
			}else if(arr[2] ==1) {
				int m = t2.pollLast();
				t2.addFirst(m);
			}
			if(arr[3] == -1) {
				int m = t3.pollFirst();
				t3.addLast(m);
			}else if(arr[3] ==1) {
				int m = t3.pollLast();
				t3.addFirst(m);
			}
			if(arr[4] == -1) {
				int m = t4.pollFirst();
				t4.addLast(m);
			}else if(arr[4] ==1) {
				int m = t4.pollLast();
				t4.addFirst(m);
			}
		}
		int answer = 0;
		if(t1.pollFirst() == 1) answer +=1;
		if(t2.pollFirst() == 1) answer +=2;
		if(t3.pollFirst() == 1) answer +=4;
		if(t4.pollFirst() == 1) answer +=8;
		System.out.println(answer);
	}
}
