import java.io.BufferedWriter;
import java.io.FileWriter;

public class PuzzleSaver {

    public void save(String fileName, Puzzle puzzle) {
        BufferedWriter br;
        try {
            String number = puzzle.getPath().length() + "\n";
            br = new BufferedWriter(new FileWriter(fileName));
            br.write(number,0,number.length());
            br.write(puzzle.getPath(),0,puzzle.getPath().length());
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveAdditionalInformation(String fileName, Solver solver){
        BufferedWriter br;
        try {
            String text = solver.getSolutionLength() + "\n" + solver.getVisitedStates() + "\n" + solver.getProccesedStates() + "\n" + solver.getMaxDepth() + "\n" + solver.getTime();
            br = new BufferedWriter(new FileWriter(fileName));
            br.write(text,0,text.length());
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
