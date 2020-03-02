import java.util.LinkedList;
import java.util.Queue;

public class PuzzleBFS {

    private Queue<Puzzle> tree = new LinkedList<Puzzle>();

    public Puzzle solve(Puzzle puzzle, Puzzle.DIRECTION[] strategy) throws CloneNotSupportedException {
        tree.add(puzzle);

        while(!tree.isEmpty()){
            Puzzle puzzleToCheck = tree.poll();

            if(puzzleToCheck.isCorrect()){
                return puzzleToCheck;
            }
            for (int i = 0; i < strategy.length; i++) {
                if(puzzleToCheck.canMove(strategy[i])){
                    Puzzle nextStepPuzzle = new Puzzle(puzzleToCheck);
                    nextStepPuzzle.move(strategy[i]);
//                    System.out.println(nextStepPuzzle);
//                    System.out.println(puzzleToCheck);
                    tree.add(nextStepPuzzle);
                }
            }
        }
        return null;
    }
}
