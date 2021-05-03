import java.util.*;

public class DiskSchedule {
	public static void main(String[] args) {

		int head = 100;	
		int requests[] = {4078, 153, 2819, 3294, 1433, 211, 1594, 2004, 2335, 2007, 771, 1043, 3950, 2784, 1881,
	        2931, 3599, 1245, 4086, 520, 3901, 2866, 947, 3794, 2353, 3970, 3948, 1815, 4621, 372, 2684, 3088, 
	        827, 3126, 2083, 584, 4420, 1294, 917, 2881, 3659, 2868, 100, 1581, 4581, 1664, 1001, 1213, 3439, 4706};
	    int FINAL LAST_CYLINDER = 4999;

	    System.out.println("FCFS: " + FCFS(requests,head));
	    System.out.println("SSTF: " + SSTF(requests,head));
	    System.out.println("SCAN: " + SCAN(requests,head));
	}

	public static int FCFS(int[] requests, int head) {
		int head_movements = 0;
        for(int i = 0; i < requests.length; i++) {
                head_movements += Math.abs(head - requests[i]);
                head = requests[i];
        }
        return head_movements;
	}

	public static int SSTF(int [] requests, int head) {
        int head_movements = 0;
        int tracker = 0;
        ArrayList <Integer> temp = new ArrayList<Integer>();

        for (int i = 0; i < requests.length; i++) {
            temp.add(requests[i]);
        }

        while(tracker < temp.size()) {
            int shortest = Integer.MAX_VALUE;
            int position = 0;

            for (int i = 0; i < temp.size(); i++) {
                if (Math.abs(temp.get(i) - head) < shortest) {
                    shortest = Math.abs(temp.get(i) - head);
                    position = i;
                }
            }

            head_movements += shortest;
            head = temp.get(position);
            temp.remove(position);
        }

        return head_movements;
    }

    public static int SCAN(int [] requests, int head) {
    	
    }
}



