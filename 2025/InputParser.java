import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class InputParser {

    private static final Path INPUT_PATH = Path.of("data/input.txt");

    public static List<String> readLines() {
        try (Stream<String> lineStream = Files.lines(INPUT_PATH)) {
            return lineStream.toList();
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

}
