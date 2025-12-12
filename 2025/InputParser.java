import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputParser {

    private static final Path INPUT_PATH = Path.of("data/input.txt");

    public static List<String> readLines() {
        try (Stream<String> lineStream = Files.lines(INPUT_PATH)) {
            return lineStream.collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
            return List.of();
        }
    }

    public static List<String> splitBy(String splitPattern) {
        List<String> lines = readLines();
        String[] splits = lines.getFirst().split(splitPattern);
        return Arrays.asList(splits);
    }

    public static char[][] getPaddedMatrix() {
        List<String> lines = readLines();
        char[][] matrix = new char[lines.size()+2][lines.getFirst().length()+2];
        for(int i = 0; i < lines.size(); i++) {
            lines.set(i,'\0' + lines.get(i) + '\0');
            matrix[i+1] = lines.get(i).toCharArray();
        }
        return matrix;
    }

    public static char[][] getMatrix() {
        List<String> lines = readLines();
        char[][] matrix = new char[lines.size()][lines.getFirst().length()];
        for(int i = 0; i < lines.size(); i++) {
            matrix[i] = lines.get(i).toCharArray();
        }
        return matrix;
    }

}
