import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day_02 {
    public static void main(String[] args) throws IOException {
        File file = new File("src/main/resources/Day_02.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        List<String> lines = new ArrayList<>();
        String tmp;

        while ((tmp = br.readLine()) != null) {
            lines.add(tmp);
        }

        int save = 0;
        for (String line : lines) {
            String[] parts = line.split("\\s+");
            int[] numbers = new int[parts.length];

            for (int i = 0; i < parts.length; i++) {

                numbers[i] = Integer.parseInt(parts[i]);
            }

            if (isSave(numbers)) {
                save++;
            }
        }

        System.out.println("Part one solution: " + save);
    }

    private static boolean isSave(int[] line) {
        if (!isIncreasing(line) && !isDecreasing(line)) {
            return false;
        }
        for (int i = 0; i < line.length - 1; i++) {
            if (Math.abs(line[i] - line[i + 1]) > 3) {
                return false;
            }
        }
        return true;
    }

    private static boolean isIncreasing(int[] line) {
        for (int i = 0; i < line.length - 1; i++) {
            if (line[i] >= line[i + 1]) {
                return false;
            }
        }
        return true;
    }

    private static boolean isDecreasing(int[] line) {
        for (int i = 0; i < line.length - 1; i++) {
            if (line[i] <= line[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
