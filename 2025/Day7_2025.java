public class Day7_2025 {


    public static void main(String[] args) {
        char[][] input = InputParser.getPaddedMatrix();
        
        System.out.println("Task 1 Result: " + task1(input));
        System.out.println("Task 2 Result: " + task2(input));
    }


    private static long task1(char[][] input) {
        long total = 0;

        for (int i = 1; i < input.length; i++) {
            for (int j = 0; j < input[i].length; j++) {
                char currentChar = input[i][j];
                if (currentChar == '^' && input[i-1][j] == '|') {
                    input[i+1][j-1] = '|';
                    input[i+1][j+1] = '|';
                    total++;
                } else if (input[i-1][j] == '|') {
                    input[i][j] = '|';
                }
                else if (currentChar == 'S') {
                    input[i+1][j] = '|';
                }
            }
        }
        
        return total;
    }

    private static long task2(char[][] input) {
        long total = 0;
        long[] pathsTaken = new long[input[0].length];

        for (int i = 1; i < input.length; i++) {
            for (int j = 0; j < input[i].length; j++) {
                char currentChar = input[i][j];
                if (currentChar == 'S') pathsTaken[j] = 1;
                if (currentChar == '^' && pathsTaken[j] > 0) {
                    long paths = pathsTaken[j];
                    pathsTaken[j] = 0;
                    pathsTaken[j+1] += paths;
                    pathsTaken[j-1] += paths;
                }
            }
        }
        
        for (int i = 1; i < pathsTaken.length; i++) {
            total += pathsTaken[i];
        }

        return total;
    }
}
