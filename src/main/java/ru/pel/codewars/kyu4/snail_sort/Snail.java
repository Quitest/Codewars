package ru.pel.codewars.kyu4.snail_sort;

import java.util.Arrays;

public class Snail {
    private Snail(){}
    /**
     * Метод "разматывает" двумерный массив (матрицу) по спирали в направлении хода часовой стрелки.
     * @param array массив (матрица), который необходимо "размотать"
     * @return одномерный массив, содержащий элементы исходного.
     */
    public static int[] snail(int[][] array) {
        if (Arrays.deepEquals(array,new int[][]{{}})){
            return new int[]{};
        }

        int[][] rotatableArray = array;
        int size = rotatableArray.length;
        int[] snail = new int[size * size];

        int i = 0;                          //задает смещение в 1D-массиве для записи очередной порции из 2D-массива.
        while (rotatableArray.length >= 1) {
            System.arraycopy(rotatableArray[0], 0, snail, i, rotatableArray[0].length);
            rotatableArray = rotateAndCut(rotatableArray);
            i += rotatableArray.length;     //вычисляем смещение в 1D-массиве для следующей итерации.
        }
        return snail;
    }

    /**
     * Метод отбрасывает первую строку исходного массива затем вращает против часовой стрелки.
     * Пример: передаем методу массив
     * <pre>
     *     {1, 2, 3},
     *     {8, 6, 4},
     *     {9, 7, 5}
     * </pre>
     * в результате получим
     * <pre>
     *     {4, 5},
     *     {6, 7},
     *     {8, 9}
     *</pre>
     * @param m исходный массив (матрица)
     * @return массив (матрицу) без первой строки, повернутый против часовой стрелки.
     */
    public static int[][] rotateAndCut(int[][] m) {
        int cols = m.length - 1;
        int rows = m[0].length;
        int[][] tmp = new int[rows][cols];
        for (int r = 0, cm = m[0].length - 1; r < rows; r++, cm--) {
            for (int c = 0, rm = 1; c < cols; c++, rm++) {
                tmp[r][c] = m[rm][cm];
            }
        }
        return tmp;
    }
}
