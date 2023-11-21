import java.util.ArrayList;

public class Sudoku {
    public void solveSudoku(ArrayList<ArrayList<Character>> a) {

        for(int i=0; i<a.size(); i++){
            for(int j=0; j<a.get(i).size(); j++){
                if(a.get(i).get(j) == '.'){
                    boolean valAdded = false;
                    for(int k=1; k<=9; k++){
                        char ch = (char)('0'+k);
                        if(uniqueInRow(a.get(i), ch) && uniqueInBox(a, i, j, ch) && uniqueInColumn(a, j, ch)) {
                            a.get(i).set(j, ch);
                            valAdded = true;
                            break;
                        }
                    }
                    if(!valAdded)   return;
                }
            }
//            if(!checkBox || !checkRow(a.get(i)) || !checkColumn) return;
        }

//        return a;
    }

    public boolean checkRow(ArrayList<Character> box){
        return true;
    }
}
