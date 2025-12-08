import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Day3_2025 {

    public static void main(String[] args) {
        List<String> values = InputParser.readLines();
        System.out.println("Task 1 Result: " + task1(values));
        System.out.println("Task 2 Result: " + task2(values));

    }


    private static long task1(List<String> input) {
        long total = 0;

        for (String line : input) {
            int biggest = 0;
            for (int i = 0; i < line.length(); i++) {
                for (int j = i + 1; j < line.length(); j++) {
                    int firstNum = line.charAt(i) - '0';
                    int secondNum = line.charAt(j) - '0';
                    int sum = firstNum * 10 + secondNum;
                    biggest = Math.max(biggest, sum);
                }
            }
            total += biggest;
        }
        return total;
    }

    private static long task2(List<String> input) {
        long result = 0L;
        final int batteryCount = 12;
        for (String line : input) {
            long lineResult = 0;
            int start = 0;
            for (int i = 0; i < batteryCount; i++) {
                int limit = line.length() - (batteryCount - i);
                int biggest = -1;
                int bestPos = -1;
                for (int j = start; j <= limit; j++) {
                    int num = line.charAt(j) - '0';
                    if (num > biggest) {
                        biggest = num;
                        bestPos = j;
                    }
                }
                lineResult = lineResult * 10L + biggest;
                start = bestPos + 1;
            }
            result += lineResult;
        }
        return result;
    }



}
