package main.day9.matrix;

/**
 * 二位子矩阵的数字之和
 * 输入一个二位矩阵，计算给定左上角坐标和右下角坐标的数字之和
 * @author fisher
 * @version 1.0
 */
public class MatrixChildSum {

    /**
     * <code>int[][]</code>-辅助矩阵，记录(0,0)到每个坐标的子矩阵的数据之和
     */
    private int[][] sums;

    /**
     * 可能由于输入不同的坐标反复调用多次<br>
     * @param matrix <code>int[][]</code>-二维矩阵
     * @param row1 <code>int</code>-左上角横坐标,第row1+1行
     * @param col1 <code>int</code>-左上角纵坐标,第col1+1列
     * @param row2 <code>int</code>-左上角横坐标,第row2+1行
     * @param col2 <code>int</code>-左上角横坐标,第col2+1行
     * @return <code>int</code>-子矩阵的数据和
     */
    public int sumRegion(int[][] matrix,int row1,int col1,int row2,int col2){
        return solve2(row1,col1,row2,col2);
    }

    /**
     * 暴力算法<br><br>
     * 若矩阵的总行数为m，总列数为n<br>
     * 时间复杂度：O(mn)<br>
     * 空间复杂度：O(mn)<br>
     * @param matrix <code>int[][]</code>-二维矩阵
     * @param row1 <code>int</code>-左上角横坐标,第row1+1行
     * @param col1 <code>int</code>-左上角纵坐标,第col1+1列
     * @param row2 <code>int</code>-左上角横坐标,第row2+1行
     * @param col2 <code>int</code>-左上角横坐标,第col2+1行
     * @return <code>int</code>-子矩阵的数据和
     */
    private int solve1(int[][] matrix,int row1,int col1,int row2,int col2){
        int index = 0;
        int result = 0;
        //记录每行子数组之和
        int[] sums = new int[row2-row1+1];
        //计算第row1+1行到第row2行的子数组之和的和
        for (int i = row1;i <= row2;i++){
            //计算每行的子数组之和
            for (int j = col1;j <= col2;j++){
                sums[index] += matrix[i][j];
            }
            result += sums[index++];

        }
        return result;
    }

    /**
     * construction 根据输入矩阵初始化字段sums；
     * @param matrix <code>int[][]</code>-矩阵
     */
    public MatrixChildSum(int[][] matrix){
        if(matrix.length == 0 || matrix[0].length == 0){
            return;
        }
        //sums比matrix多1行一列，且sums的第一行和第一列不存储数据
        sums = new int[matrix.length+1][matrix[0].length+1];
        for (int i = 0;i < matrix.length;i++){
            int rowSum = 0;
            for (int j = 0;j < matrix[i].length;j++){
                rowSum += matrix[i][j];
                sums[i+1][j+1] = sums[i][j+1] + rowSum;
            }
        }
    }
    /**
     * 通过预处理的sums求子矩阵中的数据之和<br><br>
     * 若矩阵的总行数为m，总列数为n<br>
     * 时间复杂度：O(1),只对辅助矩阵sums中的值进行加减运算<br>
     * 空间复杂度：O(mn)<br>
     * @param row1 <code>int</code>-左上角横坐标,第row1+1行
     * @param col1 <code>int</code>-左上角纵坐标,第col1+1列
     * @param row2 <code>int</code>-左上角横坐标,第row2+1行
     * @param col2 <code>int</code>-左上角横坐标,第col2+1行
     * @return <code>int</code>-子矩阵的数据和
     */
    private int solve2(int row1,int col1,int row2,int col2){
        return sums[row2 + 1][col2 + 1] - sums[row1][col2 + 1] - sums[row2 + 1][col1] + sums[row1][col1];
    }
}


class Main{
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {3,0,1,4,2},
                {5,6,3,2,1},
                {1,2,0,1,5},
                {4,1,0,1,7},
                {1,0,3,0,5}
        };
        MatrixChildSum matrixChildSum = new MatrixChildSum(matrix);
        System.out.println(matrixChildSum.sumRegion(matrix,2, 1, 4, 3));
    }
}