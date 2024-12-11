import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day_03 {
    public static void main(String[] args) throws IOException {
        File file = new File("src/main/resources/Day_03.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        List<String> lines = new ArrayList<>();
        String tmp;

        while ((tmp = br.readLine()) != null) {
            lines.add(tmp);
        }

        List<String> mulls = new ArrayList<>();
        String regex = "mul\\([0-9]+,[0-9]+\\)";
        Pattern pattern = Pattern.compile(regex);

        for (String line : lines) {
            Matcher matcher = pattern.matcher(line);

            while (matcher.find()) {
                mulls.add(matcher.group());
            }
        }

        for (String mull : mulls) {
            System.out.println(mull);
        }

        List<Integer[]> pairs = new ArrayList<>();
        String mullRegex = "[0-9]+";
        Pattern mullPattern = Pattern.compile(mullRegex);

        for (String mull : mulls) {
            Integer[] pair = new Integer[2];
            Matcher matcher = mullPattern.matcher(mull);

            int i = 0;
            while (matcher.find()) {
                pair[i] = Integer.parseInt(matcher.group());
                i++;
            }

            pairs.add(pair);
        }

        int sum = 0;

        for (Integer[] pair : pairs) {
            sum += pair[0] * pair[1];
        }

        System.out.println("Solution for part one: " + sum);

    }
}
