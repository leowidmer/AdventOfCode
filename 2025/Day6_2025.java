import java.util.ArrayList;
import java.util.List;

public class Day6_2025 {


    public static void main(String[] args) {
        List<String> input = InputParser.readLines();
        char[][] matrix = InputParser.getMatrix();

        System.out.println("Task 1 Result: " + task1(input));
        // I decided that using a 2D array avoids some unnecessary parsing and splitting
        System.out.println("Task 2 Result: " + task2(matrix));
    }


    private static long task1(List<String> input) {
        long total = 0;

        List<String[]> numbers = new ArrayList<>();

        for (String line : input) {
            line = line.trim().replaceAll("\\s+", " ");
            String[] words = line.split(" ");
            numbers.add(words);
        }

        for (int i = 0; i < numbers.getFirst().length; i++) {
            String operation = numbers.getLast()[i];
            long result = 0;

            for (int j = 0; j < numbers.size() - 1; j++) {
                if (operation.charAt(0) == '+') {
                    result += Long.parseLong(numbers.get(j)[i]);
                } else if (operation.charAt(0) == '*') {
                    long multiplier = Long.parseLong(numbers.get(j)[i]);

                    if (result == 0) result = multiplier;
                    else result *= multiplier;
                }
            }
            total += result;
        }

        return total;
    }

    private static long task2(char[][] input) {
        long total = 0;
        // Contains the result from one task on the sheet before adding it to the grand total
        long result = 0;

        int lastRowIdx = input.length - 1;
        char operation = input[lastRowIdx][0];
        boolean blank = false;

        for (int i = 0; i < input[0].length; i++) {
            int operand = 0;
            int blankCounter = 0;
            for (int j = 0; j < lastRowIdx; j++) {
                // Keep the operation symbol updated
                if (input[lastRowIdx][i] == '+' || input[lastRowIdx][i] == '*') {
                    operation = input[lastRowIdx][i];
                }

                char currentValue = input[j][i];

                if (currentValue != ' ') {
                    int num = currentValue - '0';
                    operand = operand * 10 + num;
                } else {
                    blankCounter++;
                    // The row is blank when we counted (array length - 1) blanks
                    blank = blankCounter == lastRowIdx;
                }
            }

            // Add the result to the grand total on every blank row, else keep calculating
            if (blank) {
                total += result;
                result = 0;
                blank = false;
            } else {
                if (operation == '+') {
                    result += operand;
                } else {
                    if (result == 0) result = operand;
                    else result *= operand;
                }
            }
        }
        return total;
    }
}
