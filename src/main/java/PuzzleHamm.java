import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class PuzzleHamm implements Solver {

    private List<int[][]> previousSteps = new LinkedList<int[][]>();

    private Puzzle.DIRECTION[] strategy = {Puzzle.DIRECTION.LEFT, Puzzle.DIRECTION.DOWN, Puzzle.DIRECTION.UP, Puzzle.DIRECTION.RIGHT};

    private PriorityQueue<Puzzle> tree = new PriorityQueue<Puzzle>(200, new Comparator<Puzzle>() {
        @Override
        public int compare(Puzzle o1, Puzzle o2) {
            int d1 = distanceHamming(o1.getPuzzle()) + o1.getPath().length();
            int d2 = distanceHamming(o2.getPuzzle()) + o2.getPath().length();
            if( d1 != d2){
                return d1 - d2;
            }
            else {
                return o2.getPath().length() - o1.getPath().length();
            }
        }
    });
    public int distanceHamming(int[][] a){
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
    @Override
    public Puzzle solve(Puzzle puzzle) {
        tree.add(puzzle);

        while(!tree.isEmpty()){
            Puzzle puzzleToCheck = tree.poll();

            if(puzzleToCheck.isCorrect()){
                return puzzleToCheck;
            }
            previousSteps.add(puzzleToCheck.getPuzzle());
            for (int i = 0; i < strategy.length; i++) {
                if(puzzleToCheck.canMove(strategy[i])){
                    Puzzle nextStepPuzzle = new Puzzle(puzzleToCheck);
                    nextStepPuzzle.move(strategy[i]);
                    if(!nextStepPuzzle.inList(previousSteps)){
                        tree.add(nextStepPuzzle);
                    }
                }
            }
        }
        return null;
    }
}
