import java.util.ArrayList;
import java.util.List;

public class Day2_2025 {

    public static void main(String[] args) {
        List<String> values = InputParser.splitBy(",");
        System.out.println("Task 1 Result: " + task1(values));
        System.out.println("Task 2 Result: " + task2(values));

    }


    private static long task1(List<String> input) {
        long total = 0;

        for (String line : input) {
            String[] split = line.split("-");
            long lowerBoundary = Long.parseLong(split[0]);
            long upperBoundary = Long.parseLong(split[1]);

            for (long i = lowerBoundary; i <= upperBoundary; i++) {
                String numString = String.valueOf(i);
                List<String> parts = getParts(numString);
                for (String part : parts) {
                    int numStringLength = numString.length();
                    int partLength = part.length();
                    if (numStringLength % partLength == 0) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(part.repeat(2));

                        if (numString.contentEquals(stringBuilder)) {
                            total += i;
                        }
                    }
                }
            }
        }
        return total;
    }

    private static long task2(List<String> input) {
        long total = 0;

        for (String line : input) {
            String[] split = line.split("-");
            long lowerBoundary = Long.parseLong(split[0]);
            long upperBoundary = Long.parseLong(split[1]);

            for (long i = lowerBoundary; i <= upperBoundary; i++) {
                String numString = String.valueOf(i);
                List<String> parts = getParts(numString);

                for (String part : parts) {
                    int numStringLength = numString.length();
                    int partLength = part.length();
                    if (numStringLength % partLength == 0) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(part.repeat(numStringLength / partLength));

                        if (numString.contentEquals(stringBuilder)) {
                            total += i;
                            break;
                        }
                    }
                }
            }
        }
        return total;
    }

    private static List<String> getParts(String input) {
        List<String> parts = new ArrayList<>();
        for (int j = 0; j < input.length() / 2; j++) {
            parts.add(input.substring(0, j + 1));
        }
        return parts;
    }
}
