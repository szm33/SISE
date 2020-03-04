import java.util.Arrays;
import java.util.List;

public class Puzzle{
    public enum DIRECTION {UP, DOWN, LEFT, RIGHT}

    private String path = "";

    public Puzzle(){};

    private int[][] puzzle;

   // private int[][] correct;

    private int row,col;

    public Puzzle(Puzzle newPuzzle) {
        puzzle = new int[newPuzzle.puzzle.length][newPuzzle.puzzle[0].length];
        for (int i = 0; i < puzzle.length; i++) {
            puzzle[i] = Arrays.copyOf(newPuzzle.puzzle[i], puzzle[i].length);
        }

        row = newPuzzle.row;
        col = newPuzzle.col;
        path = newPuzzle.path;
    }


    public Puzzle(int[][] puzzle) {
        this.puzzle = puzzle;
        //this.correct = correct;
        zeroPosition();
    }

    public boolean inList(List<int[][]> puzzeles){
        for (int[][] puzzle : puzzeles
             ) {
            if(Arrays.deepEquals(puzzle,this.puzzle)){
                return true;
            }
        }
        return false;
    }

    public void move(DIRECTION direction){
        switch (direction) {
            case UP:
                swap(-1,0);
                path += "U";
                row -= 1;
                break;
            case DOWN:
                swap(1,0);
                path += "D";
                row += 1;
                break;
            case LEFT:
                swap(0,-1);
                path += "L";
                col -= 1;
                break;
            case RIGHT:
                swap(0,1);
                path += "R";
                col += 1;
                break;
        }
    }

    private void swap(int vertical, int horizontal){
        int x = puzzle[row][col];
        puzzle[row][col] = puzzle[row + vertical][col + horizontal];
        puzzle[row + vertical][col + horizontal] = x;
    }

    public boolean canMove(DIRECTION direction) {
        switch (direction) {
            case UP:
                if (row != 0) {
                    return true;
                }
                break;
            case DOWN:
                if (row != puzzle.length - 1) {
                    return true;
                }
                break;
            case LEFT:
                if (col != 0) {
                    return true;
                }
                break;
            case RIGHT:
                if (col != puzzle[row].length - 1) {
                    return true;
                }
                break;
        }
        return false;
    }

    public boolean isCorrect(){
//        for (int i = 0; i < puzzle.length; i++) {
//            if(!Arrays.equals(puzzle[i],correct[i])){
//                return false;
//            }
//        }
//        return true;
        for (int i = 0; i < puzzle.length; i++) {
            for (int j = 0; j < puzzle[i].length; j++) {
                if(puzzle[i][j] != (4 * i + j + 1) % (puzzle.length * puzzle[i].length)){
                    return false;
                }
            }
        }
        return true;
    }

    private void zeroPosition(){
        for (int i = 0; i < puzzle.length; i++) {
            for (int j = 0; j < puzzle[i].length; j++) {
                if(puzzle[i][j] == 0){
                    row = i;
                    col = j;
                }
            }
        }
    }

    @Override
    public String toString() {
        String text = "";
        for (int[] tab : puzzle
             ) {
            for (int number: tab
                 ) {
                text += number + " ";

            }
            text += "\n";

        }
        return text;
    }


    public int[][] getPuzzle() {
        return puzzle;
    }

    public void setPuzzle(int[][] puzzle) {
        this.puzzle = puzzle;
    }


    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

//    public int[][] getCorrect() {
//        return correct;
//    }
//
//    public void setCorrect(int[][] correct) {
//        this.correct = correct;
//    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }
}
