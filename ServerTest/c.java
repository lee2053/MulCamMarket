package ServerTest;
import java.util.ArrayList;

public class c {
	public static void main(String[] args) {
		int b = 1;
		ArrayList<Object> r = new ArrayList<>();
		ArrayList<ArrayList<Object>> q = new ArrayList<>();
        ArrayList<Object> t;    
        
        for(int i = 0; i < 4; i++) {
        	t = new ArrayList<Object>();
        	t.add("데이터" + b++);
        	t.add("데이터" + (b++));
        	t.add("데이터" + (b++));
        	q.add(t);
//        	System.out.println(q.get(i).get(0));
//        	System.out.println(q.get(i).get(1));
//        	System.out.println(q.get(i).get(2));
        }
        
		Object a[][] = new Object[][] {{ "데이터1", "데이터2", "데이터3" },
            { "데이터4", "데이터5", "데이터6" },
            { "데이터7", "데이터8", "데이터9" }};
        
            Object x[][] = new Object[4][3];
            
            for(int i = 0; i < 4; i++) {
            	for(int j = 0; j < 3; j++) {
            		x[i][j] = q.get(i).get(j);
            		System.out.println(x[i][j]);
            	}
            }
        
	}
}
