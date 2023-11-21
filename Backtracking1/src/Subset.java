import java.util.*;

public class Subset {

    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        res.add(new ArrayList<>());

        Collections.sort(A);

        for(int i=0; i<A.size(); i++){
            ArrayList<ArrayList<Integer>> temp = new ArrayList<>();

            Queue<ArrayList<Integer>> q = new LinkedList<>();

            // for(int i=0; i<q.size)
            ArrayList<Integer> singleEle = new ArrayList<>(Collections.singletonList(A.get(i)));
            q.add(singleEle);

            int k = i;
            while(!q.isEmpty() && k<A.size()){
                ArrayList<Integer> peek = q.peek();
                ArrayList<Integer> peek2 = new ArrayList<>(peek);
                if(peek.size()==1 && peek.get(0)==A.get(i)) k++;
                if(k>A.size())  break;
                q.remove();

                q.add(peek);
                // System.out.println("Peek before:");
                // System.out.println(peek);
                peek2.add(A.get(k));
                // System.out.println("Peek:");
                // System.out.println(peek);
                // System.out.println("peek2");
                // System.out.println(peek2);
                q.add(peek2);
//                k++;
            }

            while(!q.isEmpty()){
                res.add(q.poll());
                // q.remove();
            }
        }

        return res;
    }
}
