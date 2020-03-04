

public class PuzzleHamm extends PuzzleAstar {

    public int distance(int[][] a){
        int sum=0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if(a[i][j]!=i*a.length + j + 1){
                    sum++;
                }
            }
        }
        return sum;
    }

}
