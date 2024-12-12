import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day_04 {
    public static void main(String[] args) throws IOException {
        File file = new File("src/main/resources/Day_04.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        List<String> lines = new ArrayList<>();
        String tmp;

        while ((tmp = br.readLine()) != null) {
            lines.add(tmp);
        }

        char[][] grid = new char[lines.size()][];

        for (String line : lines) {
            grid[lines.indexOf(line)] = line.toCharArray();
        }

        int cnt = 0;

        //find all 'X' in the grid
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 'X') {

                    //find 'M' in the 'X' surrounding
                    for (int k = j - 1; k <= j + 1; k++) {
                        if (k >= 0 && k < grid.length) {
                            for (int l = i - 1; l <= i + 1; l++) {
                                if (l >= 0 && l < grid.length) {
                                    if (grid[l][k] == 'M') {

                                        //detect right direction
                                        int directionY = l - i;
                                        int directionX = k - j;

                                        //check the rest of word
                                        if (k + directionX >= 0 && k + directionX < grid.length &&
                                                l + directionY >= 0 && l + directionY < grid.length) {
                                            if (grid[(l + directionY)][(k + directionX)] == 'A') {
                                                if (k + 2 * directionX >= 0 && k + 2 * directionX < grid.length &&
                                                        l + 2 * directionY >= 0 && l + 2 * directionY < grid.length) {
                                                    if (grid[l + 2 * directionY][k + 2 * directionX] == 'S') {
                                                        cnt++;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println("Solution for part one of day four is: " + cnt);

        cnt = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 'A') {
                    if (i - 1 >= 0 && i + 1 < grid.length && j - 1 >= 0 && j + 1 < grid[i].length) {
                        if (((grid[i - 1][j - 1] == 'M' && grid[i + 1][j + 1] == 'S') ||
                                (grid[i - 1][j - 1] == 'S' && grid[i + 1][j + 1] == 'M')) &&
                        ((grid[i + 1][j - 1] == 'M' && grid[i - 1][j + 1] == 'S') ||
                                (grid[i + 1][j - 1] == 'S' && grid[i - 1][j + 1] == 'M'))) {
                            cnt++;
                        }
                    }
                }
            }
        }

        System.out.println("Solution for part two of day four is: " + cnt);
    }
}