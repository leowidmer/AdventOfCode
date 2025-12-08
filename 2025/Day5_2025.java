import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Day5_2025 {

    private static final List<Range> freshRanges = new ArrayList<>();

    public static void main(String[] args) {
        List<String> input = InputParser.readLines();
        List<String> rangeStrings = new ArrayList<>();

        int i = 0;
        while (!input.get(i).isEmpty()) {
            rangeStrings.add(input.get(i));
            i++;
        }
        generateRanges(rangeStrings);
        input = input.subList(i + 1, input.size());

        System.out.println("Task 1 Result: " + task1(input));
        System.out.println("Task 2 Result: " + task2(input));
    }


    private static long task1(List<String> input) {
        long total = 0;
        for (String line : input) {
            long number = Long.parseLong(line);
            for (Range range : freshRanges) {
                if (number >= range.start() && number <= range.end()) {
                    total++;
                    break;
                }
            }

        }
        return total;
    }

    private static long task2(List<String> input) {
        long total = 0;
        for (Range range : freshRanges) {
            total += range.end() - range.start() + 1;
        }

        return total;
    }

    private static void generateRanges(List<String> lines) {
        freshRanges.clear();
        List<Range> parsed = new ArrayList<>();
        for (String line : lines) {
            String[] parts = line.split("-");
            long start = Long.parseLong(parts[0]);
            long end = Long.parseLong(parts[1]);
            parsed.add(new Range(start, end));
        }

        parsed.sort(Comparator.comparing(Range::start));
        for (Range range : parsed) {
            if (freshRanges.isEmpty()) {
                freshRanges.add(range);
                continue;
            }

            Range last = freshRanges.getLast();
            if (last.end() >= range.start()) {
                long mergedStart = Math.min(last.start(), range.start());
                long mergedEnd = Math.max(last.end(), range.end());
                freshRanges.set(freshRanges.size() - 1, new Range(mergedStart, mergedEnd));
            } else {
                freshRanges.add(range);
            }
        }
    }

    private record Range(long start, long end) {
    }

}
