import java.util.*;

public class Main {
    public static void main(String[] args) {


        ArrayList<ArrayList<Integer>> B = new ArrayList<>();
        B.add(0, new ArrayList<>(List.of(0, 4, 9)));
        B.add(1, new ArrayList<>(List.of(3, 4, 6)));
        B.add(2, new ArrayList<>(List.of(1, 2, 1)));
        B.add(3, new ArrayList<>(List.of(2, 5, 1)));
        B.add(4, new ArrayList<>(List.of(2, 4, 5)));
        B.add(5, new ArrayList<>(List.of(0, 3, 7)));
        B.add(6, new ArrayList<>(List.of(0, 1, 1)));
        B.add(7, new ArrayList<>(List.of(4, 5, 7)));
        B.add(8, new ArrayList<>(List.of(0, 5, 1)));
//        B.add(9, new ArrayList<>(List.of(14, 11)));
//        B.add(10, new ArrayList<>(List.of(12, 9)));
//        B.add(11, new ArrayList<>(List.of(2, 1)));
//        B.add(12, new ArrayList<>(List.of(9, 2)));


        int A = 6;
        int C = 4;
//        ArrayList<Integer> B = new ArrayList<>(List.of(67,8,48,42,35,25,37,69,31,36,7,33,2,47,42,52,31,70,29,38,36,60,15,37,33,27,4,32,43,55,49,35,21,28,62,17,2,61,54,22,9,56,12,3,60,52,21,15,54,63,33,64,38,16,59,69,49,52,10,10,6,56,43,32,41,66,6));
//        ArrayList<Integer> C = new ArrayList<>(List.of(51,43,55,27,34,8,14,5,70,64,65,57,45,19,53,50,44,51,19,41,14,68,12,58,50,66,7,47,40,62,29,5,22,39,23,34,25,4,40,26,26,45,18,28,61,59,17,46,39,46,68,24,63,59,67,53,9,11,3,44,24,37,13,1,65,18,48));
//        TopologicalSort ts = new TopologicalSort();
//        Djkstra d = new Djkstra();
//        ArrayList<Integer> resp = d.solve(A, B, C);
////        PossibilityOfFinishing pf = new PossibilityOfFinishing();
//
////        int resp = d.solve(A, B, C);
//        System.out.println("Final resp:: "+resp);
//        import java.util.HashMap;
//
//import java.util.Map;
//
//import java.util.TreeMap;
//
//
//        public class HashMapDemo {
//
//
//            public static void main(String args[]) {


                Map<Integer, String> employeeMap = new HashMap<>();

                employeeMap.put(123, "Alex");

                employeeMap.put(342, "Ryan");

                employeeMap.put(143, "Joe");

                employeeMap.put(234, "Allen");

                employeeMap.put(432, "Roy");



                TreeMap<Integer, String> sortedMap = new TreeMap<>();

                sortedMap.putAll(employeeMap);

                ArrayList<Integer>

                System.out.println("Sorted map " + sortedMap);


            }

//        }
//    }
}