public class Day4_2025 {

    private static char[][] input;

    public static void main(String[] args) {
        input = InputParser.getPaddedMatrix();
        System.out.println("Task 1 Result: " + task1(input));
        System.out.println("Task 2 Result: " + task2(input));

    }


    private static long task1(char[][] input) {
        long total = 0;
        for (int i = 1; i < input.length; i++) {
            for (int j = 1; j < input[i].length; j++) {
                if (input[i][j] == '@' && isAccessible(i,j)) {
                    total++;
                }
            }
        }
        return total;
    }

    private static long task2(char[][] input) {
        long total = 0;
        boolean matrixChanged = true;
        while (matrixChanged) {
            matrixChanged = false;
            for (int i = 1; i < input.length; i++) {
                for (int j = 1; j < input[i].length; j++) {
                    if (input[i][j] == '@' && isAccessible(i,j)) {
                        input[i][j] = '.';
                        total++;
                        matrixChanged = true;
                    }
                }
            }
        }

        return total;
    }

    private static boolean isAccessible(int i, int j) {
        int count = 0;
        // you may not like it but this is what peak programming looks like
        if (input[i - 1][j] == '@') count++;
        if (input[i + 1][j] == '@') count++;
        if (input[i][j - 1] == '@') count++;
        if (input[i][j + 1] == '@') count++;
        if (input[i - 1][j - 1] == '@') count++;
        if (input[i + 1][j + 1] == '@') count++;
        if (input[i - 1][j + 1] == '@') count++;
        if (input[i + 1][j - 1] == '@') count++;

        return count < 4;
    }
}
