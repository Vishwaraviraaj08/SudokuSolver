import java.util.*;

public class sudoku {
    static int[][] grid = new int[9][9];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Sudoku grid, ( 0 for empty spaces) ");
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        if (solve()) {
            System.out.println("The Sudoku grid has been solved 🎊🎊🎊 ");
            printGrid();
        } else {
            System.out.println("Unable to solve the Sudoku grid.");
        }
    }

    public static boolean solve() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (grid[i][j] == 0) {
                    for (int k = 1; k <= 9; k++) {
                        grid[i][j] = k;
                        if (isValid(i, j) && solve()) {
                            return true;
                        }
                        grid[i][j] = 0;
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isValid(int i, int j) {
        for (int k = 0; k < 9; k++) {
            if (k != j && grid[i][k] == grid[i][j]) {
                return false;
            }
        }
        for (int k = 0; k < 9; k++) {
            if (k != i && grid[k][j] == grid[i][j]) {
                return false;
            }
        }
        int startRow = i / 3 * 3;
        int startCol = j / 3 * 3;
        for (int k = startRow; k < startRow + 3; k++) {
            for (int l = startCol; l < startCol + 3; l++) {
                if (k != i && l != j && grid[k][l] == grid[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void printGrid() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}
