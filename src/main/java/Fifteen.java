import java.util.Comparator;
import java.util.PriorityQueue;

public class Fifteen {



    public static void main(String[] args) {
        PuzzleAstar hamm = new PuzzleHamm();
        PuzzleAstar manh = new PuzzleManh();
        PuzzleLoader loader = new PuzzleLoader();
        PuzzleSaver saver = new PuzzleSaver();
        Puzzle puzzle = new Puzzle(loader.load("C:\\Users\\SzymonDobrowolski\\Desktop\\SISE\\4x4_09_00191.txt"));
        System.out.println(puzzle);
//        if(puzzle.canMove(Puzzle.DIRECTION.DOWN)){
//            puzzle.move(Puzzle.DIRECTION.DOWN);
//            System.out.println(puzzle);
//        }
//        if(puzzle.isCorrect()){
//            System.out.println("Brawo udalo sie");
//        }
        Puzzle.DIRECTION[] strategy = {Puzzle.DIRECTION.LEFT, Puzzle.DIRECTION.DOWN, Puzzle.DIRECTION.UP, Puzzle.DIRECTION.RIGHT};
        PuzzleBFS bfs = new PuzzleBFS(strategy);
        PuzzleDFS dfs = new PuzzleDFS(strategy);
        Solver solver = manh;
        Puzzle solvedPuzzle = solver.solve(puzzle);
        //Puzzle solvedPuzzle = bfs.solve(puzzle, strategy);
        System.out.println(solvedPuzzle);
        System.out.println(solvedPuzzle.getPath());
        if (solvedPuzzle.isCorrect()) {
            System.out.println("Brawo udalo sie");
            saver.save("C:\\Users\\SzymonDobrowolski\\Desktop\\SISE\\answer.txt",solvedPuzzle);

        }
    }
}
