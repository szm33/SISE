public class Fifteen {

    public static void main(String[] args) {
        PuzzleLoader loader = new PuzzleLoader();
        Puzzle puzzle = new Puzzle(loader.load("C:\\Users\\SzymonDobrowolski\\Desktop\\SISE\\4x4_09_00121.txt"));
        System.out.println(puzzle);
//        if(puzzle.canMove(Puzzle.DIRECTION.DOWN)){
//            puzzle.move(Puzzle.DIRECTION.DOWN);
//            System.out.println(puzzle);
//        }
//        if(puzzle.isCorrect()){
//            System.out.println("Brawo udalo sie");
//        }
        PuzzleBFS bfs = new PuzzleBFS();
        Puzzle.DIRECTION[] strategy = {Puzzle.DIRECTION.LEFT, Puzzle.DIRECTION.DOWN, Puzzle.DIRECTION.UP, Puzzle.DIRECTION.RIGHT};
        PuzzleDFS dfs = new PuzzleDFS(strategy);
        Puzzle solvedPuzzle = dfs.solve(puzzle,0);
        //Puzzle solvedPuzzle = bfs.solve(puzzle, strategy);
        System.out.println(solvedPuzzle);
        System.out.println(solvedPuzzle.getPath());
        if (solvedPuzzle.isCorrect()) {
            System.out.println("Brawo udalo sie");


        }
    }
}
