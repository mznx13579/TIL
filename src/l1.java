import java.util.*;
public class l1 {
	public static void main(String[] args) {
		int[][] boxes = {{1,2},{2,1},{3,3},{4,5},{5,6},{4,4}};
		HashMap<Integer, Integer> m = new HashMap<>();
		for(int r=0; r<boxes.length; r++) {
			for(int c=0; c<2; c++) {
				if(m.containsKey(boxes[r][c])) {
					m.put(boxes[r][c], m.get(boxes[r][c])+1);
				}
				else {
					m.put(boxes[r][c], 1);
				}
			}
		}
		int cnt = 0;
		for(Integer key : m.keySet()) {
			cnt+=m.get(key)/2;
		}
		int answer = boxes.length-cnt;
	}
}
