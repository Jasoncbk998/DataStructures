package com.jason.dataStructer.sparsearray;

/**
 * @Classname SparseArray
 * @Description 二维数组与稀疏数组的转化
 * 数组
 * @Date 2020/6/21 11:19 上午
 * @Created by jason
 */
public class SparseArray {
    public static void main(String[] args) {
        int[][] chessArr = new int[11][11];

        /**
         * 0:没有棋子
         * 1:黑子
         * 2:蓝子
         */
        chessArr[1][2] = 1;
        chessArr[2][3] = 2;
        chessArr[4][5] = 2;


        //输出原始数组
        System.out.println("输出原始数组");
        for (int[] row : chessArr) {
            for (int data : row) {
                System.out.printf("%d \t", data);
            }
            //换行
            System.out.println();
        }

        System.out.println("--------------------------------");

        //二维数组转换成稀疏数组
        //遍历二维数组,得到非0数据的个数
        int sum = 0;

        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr[i][j] != 0) {
                    sum++;
                }
            }
        }
        //创建对应的稀疏数组
        /**
         * 为什么是sum+1
         * 因为稀疏数组的第一行是 描述稀疏数组的行  因为有三个数值,所以加上描述行和元素行一共是sum+1行
         */
        int[][] sparseArr = new int[sum + 1][3];//4行3列
        //赋值
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;
        //遍历二维数组,将非0 的值存放到sparseArray中
        int count = 0;//记录非0的数据
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr[i][j] != 0) {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr[i][j];
                }
            }
        }
        //输出稀疏数组
        System.out.println();
        System.out.println("------得到稀疏数组为------");
        for (int i = 0; i < sparseArr.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n", sparseArr[i][0], sparseArr[i][1], sparseArr[i][2]);
        }
        System.out.println();


        System.out.println("稀疏数组->二维数组");
        int[][] chessArr2 = new int[sparseArr[0][0]][sparseArr[0][1]];//稀疏数组第一行的第一列和第二列 就是二维数组的行与列
        //通过读取稀疏数组的第一行,可以获得二维数组的大小以及值,并且可以创建二维数组
        for (int i = 1; i < sparseArr.length; i++) {
            chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }
        //输出恢复后的二维数组
        System.out.println();
        System.out.println("恢复后的二维数组");
        for (int[] row : chessArr2) {
            for (int data : row) {
                System.out.printf("%d \t",data);
            }
            System.out.println();
        }



    }
}
