import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day_01 {
    public static void main(String[] args) throws IOException {
        File file = new File("src/main/resources/Day_01.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        List<String> lines = new ArrayList<>();
        String tmp;

        while ((tmp = br.readLine()) != null) {
            lines.add(tmp);
        }

        List<Integer> col1 = new ArrayList<>();
        List<Integer> col2 = new ArrayList<>();

        for (String line : lines) {
            String[] parts = line.split("\\s+");
            col1.add(Integer.parseInt(parts[0]));
            col2.add(Integer.parseInt(parts[1]));
        }

        col1.sort(Integer::compareTo);
        col2.sort(Integer::compareTo);

        int sum = 0;

        for (int i = 0; i < col1.size(); i++) {
            sum += Math.abs(col2.get(i) - col1.get(i));
        }

        System.out.println(sum);
    }
}
