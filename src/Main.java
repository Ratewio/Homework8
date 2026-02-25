import java.util.Random;
import java.util.Scanner;

public class Main {
    public static final int SIZE = 8;

    public static void main(String[] args) {
        int[][] colors = new int[SIZE][SIZE];
        randomizeColors(colors);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Матрица: ");
            printColors(colors);
            System.out.print("Введите угол поворота по часовой стрелке (90, 180, 270): ");
            for (int turns = scanner.nextInt() / 90; turns != 0; --turns)
                colors = rotateColors(colors);
        }
    }

    public static void randomizeColors(int[][] colors) {
        Random random = new Random();
        for (int i = 0; i != SIZE; ++i)
            for (int j = 0; j != SIZE; ++j)
                colors[i][j] = random.nextInt(256);
    }

    public static void printColors(int[][] colors) {
        for (int i = 0; i != SIZE; ++i) {
            for (int j = 0; j != SIZE; ++j)
                System.out.format("%4d", colors[i][j]);
            System.out.println();
        }
        System.out.println();
    }

    public static int[][] rotateColors(int[][] colors) {
        int[][] rotatedColors = new int[SIZE][SIZE];
        for (int i = 0; i != SIZE; ++i)
            for (int j = 0; j != SIZE; ++j)
                rotatedColors[j][SIZE - 1 - i] = colors[i][j];
        return rotatedColors;
    }
}