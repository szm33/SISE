public class PuzzleManh extends PuzzleAstar{
    @Override
    public int distance(int[][] a) {
        int sum=0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if(a[i][j] != 0){
                    sum += Math.abs(i - (a[i][j] - 1) / a.length) + Math.abs(j - (a[i][j] - 1) % a[i].length);
                }
            }
        }
        return sum;
    }
}
