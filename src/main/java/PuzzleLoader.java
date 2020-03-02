import java.io.BufferedReader;
import java.io.FileReader;

public class PuzzleLoader {

    public int[][] load(String fileName) {
        int[][] puzzle;
        BufferedReader br;
        String line;
        String split = " ";
        try {
            br = new BufferedReader(new FileReader(fileName));
            line = br.readLine();
            String[] size = line.split(split);
            puzzle = new int[Integer.parseInt(size[0])][Integer.parseInt(size[1])];
            int puzzleLine = 0;
            while ((line = br.readLine()) != null) {
                String[] number = line.split(split);
                for (int i = 0; i < puzzle[0].length; ++i) {
                    puzzle[puzzleLine][i] = Integer.parseInt(number[i]);
                }
                ++puzzleLine;
            }
            br.close();
            return puzzle;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
