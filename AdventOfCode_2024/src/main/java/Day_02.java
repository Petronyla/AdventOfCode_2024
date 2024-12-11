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
            String[] levels = line.split("\\s+");
            List<Integer> report = new ArrayList<>();

            for (String s : levels) {
                report.add(Integer.parseInt(s));
            }

            if (isSave(report)) {
                save++;
            } else {
                for (Integer level : report) {
                    List<Integer> copyOfReport = new ArrayList<>(report);
                    copyOfReport.remove(level);
                    if (isSave(copyOfReport)) {
                        save++;
                        break;
                    }
                }
            }
        }

        System.out.println("Part two solution: " + save);
    }

    private static boolean isSave(List<Integer> line) {
        if (!isIncreasing(line) && !isDecreasing(line)) {
            return false;
        }
        for (int i = 0; i < line.size() - 1; i++) {
            if (Math.abs(line.get(i) - line.get(i + 1)) > 3) {
                return false;
            }
        }
        return true;
    }

    private static boolean isIncreasing(List<Integer> line) {
        for (int i = 0; i < line.size() - 1; i++) {
            if (line.get(i) >= line.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isDecreasing(List<Integer> line) {
        for (int i = 0; i < line.size() - 1; i++) {
            if (line.get(i) <= line.get(i + 1)) {
                return false;
            }
        }
        return true;
    }
}
