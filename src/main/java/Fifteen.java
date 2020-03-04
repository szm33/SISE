import org.apache.commons.math3.util.Precision;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Fifteen {

    public static Puzzle.DIRECTION[] setStrategy(String str){
        Puzzle.DIRECTION[] strategy = new Puzzle.DIRECTION[4];
        for(int i = 0; i < str.length(); i++){
            switch (str.charAt(i)){
                case 'L':
                    strategy[i] = Puzzle.DIRECTION.LEFT;
                    break;
                case 'R':
                    strategy[i] = Puzzle.DIRECTION.RIGHT;
                    break;
                case 'U':
                    strategy[i] = Puzzle.DIRECTION.UP;
                    break;
                case 'D':
                    strategy[i] = Puzzle.DIRECTION.DOWN;
                    break;

            }
        }
        return strategy;
    }


    public static void main(String[] args) {
        String strategy = args[0];
        String paramStrategy = args[1];
        String startFile = args[2];
        String endFile = args[3];
        String additionalFile = args[4];
        Solver solver;
        PuzzleLoader loader = new PuzzleLoader();
        PuzzleSaver saver = new PuzzleSaver();
        if("bfs".equals(strategy)){
            solver = new PuzzleBFS(setStrategy(paramStrategy));
        } else if("dfs".equals(strategy)){
            solver = new PuzzleDFS(setStrategy(paramStrategy));
        } else if("astr".equals(strategy)){
            if(paramStrategy == "manh"){
                solver = new PuzzleManh();
            } else {
                solver = new PuzzleHamm();
            }
        }
        else {
            solver = null;
        }
        Puzzle puzzle = new Puzzle(loader.load(startFile));
        long startTime = System.nanoTime();
        Puzzle solvedPuzzle = solver.solve(puzzle);
        long endTime = System.nanoTime();
        double duration = (endTime - startTime)/1000000.0;
        duration = Precision.round(duration,3);
        if(solvedPuzzle == null){
            solver.setSolutionLength(-1);
        }
        else {
            solver.setSolutionLength(solvedPuzzle.getPath().length());
        }
        solver.setTime(duration);
        saver.save(endFile,solvedPuzzle);
        saver.saveAdditionalInformation(additionalFile,solver);


//        PuzzleAstar hamm = new PuzzleHamm();
//        PuzzleAstar manh = new PuzzleManh();
//        PuzzleLoader loader = new PuzzleLoader();
//        PuzzleSaver saver = new PuzzleSaver();
//        Puzzle puzzle = new Puzzle(loader.load("C:\\Users\\SzymonDobrowolski\\Desktop\\SISE\\4x4_10_00011.txt"));
//        System.out.println(puzzle);
////        if(puzzle.canMove(Puzzle.DIRECTION.DOWN)){
////            puzzle.move(Puzzle.DIRECTION.DOWN);
////            System.out.println(puzzle);
////        }
////        if(puzzle.isCorrect()){
////            System.out.println("Brawo udalo sie");
////        }
//        Puzzle.DIRECTION[] strategy = {Puzzle.DIRECTION.LEFT, Puzzle.DIRECTION.DOWN, Puzzle.DIRECTION.UP, Puzzle.DIRECTION.RIGHT};
//        PuzzleBFS bfs = new PuzzleBFS(strategy);
//        PuzzleDFS dfs = new PuzzleDFS(strategy);
//        Solver solver = bfs;
//        Puzzle solvedPuzzle = solver.solve(puzzle);
//        //Puzzle solvedPuzzle = bfs.solve(puzzle, strategy);
//        System.out.println(solvedPuzzle);
//        System.out.println(solvedPuzzle.getPath());
//        if (solvedPuzzle.isCorrect()) {
//            System.out.println("Brawo udalo sie");
//            saver.save("C:\\Users\\SzymonDobrowolski\\Desktop\\SISE\\answer.txt",solvedPuzzle);
//
//        }
    }
}
