import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

public class Day1_2025 {

    private static final Path INPUT_PATH = Path.of("data/input.txt");

    public static void main(String[] args) throws IOException {

        List<String> lines;
        try (Stream<String> lineStream = Files.lines(INPUT_PATH)) {
            lines = lineStream.toList();
        }
        System.out.println("Task 1 Password: " + task1(lines));
        System.out.println("Task 2 Password: " + task2(lines));

    }


    private static int task1(List<String> input) {
        int password = 0;
        int safeValue = 50;

        for (String line : input) {
            int clicks = getNum(line);
            if (line.contains("L")) {
                safeValue = (safeValue - clicks) % 100;
            } else {
                safeValue = (safeValue + clicks) % 100;
            }

            if (safeValue == 0) password++;
        }

        return password;
    }

    private static int task2(List<String> input) {
        int count = 0;
        int prev;
        int current = 50;

        for (String line : input) {
            prev = current;

            if (line.charAt(0) == 'R')
                current += getNum(line);
            else
                current -= getNum(line);

            if (current == 0 || prev * current < 0)
                count++;
            count += Math.abs(current / 100);

            current %= 100;
        }

        return count;
    }

    private static int getNum(String line) {
        String numToParse = line.substring(1);
        return Integer.parseInt(numToParse);
    }
}
