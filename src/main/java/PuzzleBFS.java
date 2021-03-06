import java.util.LinkedList;
import java.util.Queue;

public class PuzzleBFS extends Solver{

    private Queue<Puzzle> tree = new LinkedList<Puzzle>();

    private Puzzle.DIRECTION[] strategy;

    public PuzzleBFS(Puzzle.DIRECTION[] strategy){
        this.strategy = strategy;
    }


    public Puzzle solve(Puzzle puzzle) {
        tree.add(puzzle);

        while(!tree.isEmpty()){
            Puzzle puzzleToCheck = tree.poll();

            setVisitedStates(getVisitedStates() + 1);
            if(puzzleToCheck.getPath().length() > getMaxDepth()){
                setMaxDepth(puzzleToCheck.getPath().length());
            }
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
