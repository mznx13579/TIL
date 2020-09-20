import java.util.*;

public class l2 {
	public static void main(String[] args) {
		int[] ball = {11, 2, 9, 13, 24};
		int[] order = {9, 2, 13, 24, 11};
		ArrayList<Integer> answer = new ArrayList<>();
		Deque<Integer> dq = new ArrayDeque<>();
		for(int i=0; i<ball.length; i++) dq.add(ball[i]);
		ArrayList<Integer> al = new ArrayList<>();
		for(int i=0; i<order.length; i++) {
			int left = dq.peekFirst();
			int right = dq.peekLast();
			while(true) {
				boolean isOk = false;
				int idx = -1;
				for(int j=0; j<al.size(); j++) {
					if(al.get(j) == left || al.get(j) == right) {
						isOk = true;
						idx = j;
						break;
					}
				}
				if(isOk) {
					int tmp = al.get(idx);
					al.remove(idx);
					if(left == tmp) {
						answer.add(dq.pollFirst());
						left = dq.peekFirst();
					}
					else if(right == tmp) {
						answer.add(dq.pollLast());
						right = dq.peekLast();
					}
				}
				else break;
			}
			if(left == order[i]) {
				answer.add(dq.pollFirst());
			}
			else if(right == order[i]) {
				answer.add(dq.pollLast());
			}
			else {
				al.add(order[i]);
			}
		}
		for(int x : answer) {
			System.out.println(x);
		}
	}
}
