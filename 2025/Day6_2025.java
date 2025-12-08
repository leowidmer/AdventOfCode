import java.util.ArrayList;
import java.util.List;

public class Day6_2025 {


    public static void main(String[] args) {
        List<String> input = InputParser.readLines();

        System.out.println("Task 1 Result: " + task1(input));
        System.out.println("Task 2 Result: " + task2(input));
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

    private static long task2(List<String> input) {
        long total = 0;


        for (String line : input) {

        }
        return total;
    }


}
