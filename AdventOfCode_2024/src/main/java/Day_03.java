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

        String tmp;
        StringBuilder sb = new StringBuilder();

        while ((tmp = br.readLine()) != null) {
            sb.append(tmp);
        }

        String trimRegex = "don't\\(\\).*?do\\(\\)|don't\\(\\).*";

        String input = sb.toString().replaceAll(trimRegex, "");

        List<String> mulls = new ArrayList<>();
        String regex = "mul\\([0-9]+,[0-9]+\\)";
        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            mulls.add(matcher.group());
        }

        List<Integer[]> pairs = new ArrayList<>();
        String mulRegex = "[0-9]+";
        Pattern mulPattern = Pattern.compile(mulRegex);

        for (String mull : mulls) {
            Integer[] pair = new Integer[2];
            Matcher mulMatcher = mulPattern.matcher(mull);

            int i = 0;
            while (mulMatcher.find()) {
                pair[i] = Integer.parseInt(mulMatcher.group());
                i++;
            }

            pairs.add(pair);
        }

        int sum = 0;

        for (Integer[] pair : pairs) {
            sum += pair[0] * pair[1];
        }

        System.out.println("Solution for part two: " + sum);
    }
}
