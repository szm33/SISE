import java.io.BufferedWriter;
import java.io.FileWriter;

public class PuzzleSaver {

    public void save(String fileName, Puzzle puzzle) {
        BufferedWriter br;
        String line;
        String split = " ";
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
}
