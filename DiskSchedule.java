import java.util.*;

public class DiskSchedule {
    public static void main(String[] args) {

        int head = 50; 
        int requests[] = {82,170,43,140,24,16,190};
        int max = 199; 

        System.out.println("FCFS: " + FCFS(requests,head));
        System.out.println();
        System.out.println("SSTF: " + SSTF(requests,head));
        System.out.println();
        System.out.println("SCAN LEFT: " + SCAN_LEFT(requests,head));
        System.out.println();
        System.out.println("SCAN RIGHT: " + SCAN_RIGHT(requests,head,max));
        System.out.println();
        System.out.println("C-SCAN: " + C_SCAN(requests,head,max));
        System.out.println();
        System.out.println("LOOK: " + LOOK(requests,head));
        System.out.println();
        System.out.println("C-LOOK: " + C_LOOK(requests,head));
        
    }

    public static int FCFS(int[] requests, int head) {
        int head_movements = 0;
        for(int i = 0; i < requests.length; i++) {
            if(i == requests.length - 1) 
                System.out.print("(|" + head + " - " + requests[i] + "|)"); 
            else 
                System.out.print("(|" + head + " - " + requests[i] + "|) + ");
            head_movements += Math.abs(head - requests[i]);
            head = requests[i];
        }
        System.out.println();
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
                    shortest = Math.abs(head - temp.get(i));
                    position = i;
                }
            }

            System.out.print(shortest + " + ");

            head_movements += shortest;
            head = temp.get(position);
            temp.remove(position);
        }

        System.out.println();
        return head_movements;
    }

    // IF DIRECTION IS TO THE LEFT
    public static int SCAN_LEFT(int [] requests, int head) {
        int head_movements = 0;
        int position = 0;
        ArrayList <Integer> temp = new ArrayList<Integer>();

        for (int i = 0; i < requests.length; i++) {
            temp.add(requests[i]);
        }
        Collections.sort(temp); //sort the list in ascending order

        head_movements += Math.abs(head - 0);
        System.out.print("(|" + head + " - " + 0 + "|) + ");
        head_movements += Math.abs(0 - temp.get(temp.size() - 1));
        System.out.print("(|" + 0 + " - " + temp.get(temp.size() - 1) + "|)");
        System.out.println();
        return head_movements;
    }

    //IF DIRECTION IS TO THE RIGHT
    public static int SCAN_RIGHT(int [] requests, int head, int max) {
        int head_movements = 0;
        int position = 0;
        ArrayList <Integer> temp = new ArrayList<Integer>();

        for (int i = 0; i < requests.length; i++) {
            temp.add(requests[i]);
        }

        Collections.sort(temp); //sort the list in ascending order

        head_movements += Math.abs(head - max);
        System.out.print("(|" + head + " - " + max + "|) + ");
        head_movements += Math.abs(max - temp.get(0));
        System.out.print("(|" + max + " - " + temp.get(0) + "|)");
        System.out.println();
        return head_movements;
    }


    public static int C_SCAN(int[] requests, int head, int max) {
        int head_movements = 0;
        int position = 0;
        ArrayList <Integer> temp = new ArrayList<Integer>();

        for (int i = 0; i < requests.length; i++) {
            temp.add(requests[i]);
        }
        Collections.sort(temp); //sort the list in ascending order

        //get position of first biggest request so you know where to start off at second time going back
        for(int i = 0; i < temp.size(); i++) {
            if(temp.get(i) >= head) {
                position = i;
                break;
            }
        }

        //going to the right side first
        for(int i = position; i < temp.size(); i++) {
            System.out.print("(|" + head + " - " + temp.get(i) + "|) + ");
            head_movements += Math.abs(temp.get(i) - head);
            head = temp.get(i);
        }

        head_movements += max - head;
        System.out.print("(|" + max + " - " + head + "|) + ");
        head = 0;
        head_movements += max - head;
        System.out.print("(|" + max + " - " + head + "|) + ");

        //going to the right side again
        for(int i = 0; i < position; i++) {
            if(i == position - 1)
                System.out.print("(|" + head + " - " + temp.get(i) + "|)");
            else
                System.out.print("(|" + head + " - " + temp.get(i) + "|) + ");
            head_movements += Math.abs(temp.get(i) - head);
            head = temp.get(i);
        }
        System.out.println();
        return head_movements;
    }

    public static int LOOK(int[] requests, int head) {

        int head_movements = 0;
        int position = 0;
        ArrayList <Integer> temp = new ArrayList<Integer>();

        for (int i = 0; i < requests.length; i++) {
            temp.add(requests[i]);
        }
        Collections.sort(temp); //sort the list in ascending order

        head_movements += Math.abs(temp.get(temp.size() - 1) - head);
        System.out.print("(|" + head + " - " + temp.get(temp.size() - 1) + "|) + ");
        head_movements += Math.abs(temp.get(temp.size() - 1) - temp.get(0));
        System.out.print("(|" + temp.get(0) + " - " + temp.get(temp.size() - 1) + "|)");

        System.out.println();
        return head_movements;
    }

    public static int C_LOOK(int[] requests, int head) {

        int head_movements = 0;
        int position = 0;
        ArrayList <Integer> temp = new ArrayList<Integer>();

        for (int i = 0; i < requests.length; i++) {
            temp.add(requests[i]);
        }
        Collections.sort(temp); //sort the list in ascending order

        //get position of first biggest request so you know where to start off at second time going back
        for(int i = 0; i < temp.size(); i++) {
            if(temp.get(i) <= head) {
                position = i;
                break;
            }
        }

        head_movements += Math.abs(temp.get(temp.size() - 1) - head);
        System.out.print("(|" + head + " - " + temp.get(temp.size() - 1) + "|) + ");
        head_movements += Math.abs(temp.get(temp.size() - 1) - temp.get(0)); 
        System.out.print("(|" + temp.get(0) + " - " + temp.get(temp.size() - 1) + "|)");       

        temp.add(head);
        Collections.sort(temp);
        for(int i = 0; i < temp.size(); i++) {
            if(temp.get(i) == 50) 
                position = i - 1;
        }

        head_movements += Math.abs(temp.get(0) - temp.get(position)); 
        System.out.println();
        return head_movements;

    }
}
    


