public class Fifteen {

    public static void main(String[] args) {
        PuzzleLoader loader = new PuzzleLoader();
        Puzzle puzzle = new Puzzle(loader.load("C:\\Users\\SzymonDobrowolski\\Desktop\\SISE\\4x4_10_00590.txt"));
        System.out.println(puzzle);
//        if(puzzle.canMove(Puzzle.DIRECTION.DOWN)){
//            puzzle.move(Puzzle.DIRECTION.DOWN);
//            System.out.println(puzzle);
//        }
//        if(puzzle.isCorrect()){
//            System.out.println("Brawo udalo sie");
//        }
        PuzzleBFS bfs = new PuzzleBFS();
        Puzzle.DIRECTION[] strategy = {Puzzle.DIRECTION.RIGHT, Puzzle.DIRECTION.DOWN, Puzzle.DIRECTION.UP, Puzzle.DIRECTION.LEFT};
        try {
            Puzzle solvedPuzzle = bfs.solve(puzzle, strategy);
            System.out.println(solvedPuzzle);
            System.out.println(solvedPuzzle.getPath());
            if(solvedPuzzle.isCorrect()){
            System.out.println("Brawo udalo sie");
        }
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
