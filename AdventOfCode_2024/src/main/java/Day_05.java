import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Day_05 {
    public static void main(String[] args) throws IOException {
        File file = new File("src/main/resources/Day_05.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        List<String> rules = new ArrayList<>();
        List<String> updates = new ArrayList<>();
        String tmp;
        int sum_part1 = 0;
        int sum_part2 = 0;

        while ((tmp = br.readLine()) != null) {
            if (tmp.isEmpty()) {
                break;
            }
            rules.add(tmp);
        }

        while ((tmp = br.readLine()) != null) {
            updates.add(tmp);
        }

        Integer[][] rulesArray = new Integer[rules.size()][2];

        for (String rule : rules) {
            String[] pair = rule.split("\\|");
            rulesArray[rules.indexOf(rule)][0] = Integer.parseInt(pair[0]);
            rulesArray[rules.indexOf(rule)][1] = Integer.parseInt(pair[1]);
        }

        for (String update : updates) {
            String[] s = update.split(",");
            int[] numbers = new int[s.length];
            for (int i = 0; i < s.length; i++) {
                numbers[i] = Integer.parseInt(s[i]);
            }
            if (isValid(rulesArray, numbers)) {
                sum_part1 += numbers[numbers.length / 2];
            } else {
                int[] tmpResult = correctOrder(rulesArray, numbers);
                sum_part2 += tmpResult[tmpResult.length / 2];
            }
        }
        System.out.println("The solution for the part one of the fifth day: " + sum_part1);
        System.out.println("The solution for the part two of the fifth day: " + sum_part2);
    }

    private static boolean isValid(Integer[][] rulesArray, int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < i; j++) {
                for (Integer[] integers : rulesArray) {
                    if (integers[0] == numbers[i] && integers[1] == numbers[j]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private static int[] correctOrder(Integer[][] rulesArray, int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < i; j++) {
                for (Integer[] integers : rulesArray) {
                    if (integers[0] == numbers[i] && integers[1] == numbers[j]) {
                        int temp = numbers[i];
                        numbers[i] = numbers[j];
                        numbers[j] = temp;
                        correctOrder(rulesArray, numbers);
                    }
                }
            }
        }
        return numbers;
    }
}
