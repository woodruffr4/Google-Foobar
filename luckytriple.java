// Accepted

import java.util.Scanner;
import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;

public class luckytriple {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		//int[] l = {5,5,25};
		//int[] l = {1,2,3,4,5,6};
		while(true) {
			int num = in.nextInt();
			int[] l = new int[num];
			for (int i=0; i<num; i++) {
				l[i]=in.nextInt();
			}
			System.out.println(answer(l));
		}
		
	}


    public static int answer(int[] l) { 

        // Your code goes here.
        HashMap<Integer, ArrayList<Integer>> indices = new HashMap<Integer, ArrayList<Integer>>();
        int res = 0;
        int min = l[0];
        int max = l[0];
        int index = 0;
        for(int val: l) {
            if(indices.containsKey(val)) {
                indices.get(val).add(index);
            } else {
                ArrayList<Integer> list = new ArrayList<Integer>();
                list.add(index);
                indices.put(val,list);
            }
            min = Math.min(min,val);
            max = Math.max(max,val);
            index++;
        }

        for(int i=0;i<l.length;i++) {            
            
            int numright = 0;
            int numleft = 0;

            //find multiples of l[i] such that the index of the multiple is greater than i
            for (int j=1; l[i]*j<=max; j++) {
                if(indices.containsKey(l[i]*j)) {
                    ArrayList<Integer> list = indices.get(l[i]*j);
                    int counter = list.size()-1;
                    while(counter>=0 && list.get(counter)>i) {
                        numright++;
                        counter--;
                    }
                }
            }

            //short circuit
            if(numright==0) continue;

            //find divisors of l[i] such that the index of the divisor is less than i
            for (int j=1; l[i]/j>=min; j++) {
                 if(l[i]%j!=0) continue;
                 if(indices.containsKey(l[i]/j)) {
                    ArrayList<Integer> list = indices.get(l[i]/j);
                    int counter = 0;
                    while(counter<list.size() && list.get(counter)<i) {
                        numleft++;
                        counter++;
                    }
                }
            }

            //add multiples*divisors
            res+=numright*numleft;
        }
        
        return res;
    }
}