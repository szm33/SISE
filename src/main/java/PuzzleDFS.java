public class PuzzleDFS {

    private Puzzle.DIRECTION[] strategy;

    public PuzzleDFS(Puzzle.DIRECTION[] strategy){
        this.strategy = strategy;
    }

    public Puzzle solve(Puzzle puzzle, int invokations){

            if(puzzle.isCorrect()){
                return puzzle;
            }
            if(invokations > 20){
                return null;
            }
            for (int i = 0; i < strategy.length; i++) {
                if(puzzle.canMove(strategy[i])){
                    Puzzle nextStepPuzzle = new Puzzle(puzzle);
                    nextStepPuzzle.move(strategy[i]);
                    Puzzle solution = solve(nextStepPuzzle, invokations+ 1);
                    if(solution != null){
                        return solution;
                    }

                }
            }
        return null;
    }
}
