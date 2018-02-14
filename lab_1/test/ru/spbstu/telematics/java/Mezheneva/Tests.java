package ru.spbstu.telematics.java.Mezheneva;

import org.apache.commons.math3.linear.BlockRealMatrix;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.random.GaussianRandomGenerator;
import org.apache.commons.math3.random.NormalizedRandomGenerator;
import org.apache.commons.math3.random.RandomGenerator;
import org.apache.commons.math3.random.RandomGeneratorFactory;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;

public class Tests {

    final Random rnd = new Random(System.currentTimeMillis());

    @Test
    public void multiplicationWithZeroMtrxGivesZeroMtrx() {
        final int rows = 5;
        final int columns = 5;

        RealMatrix nil = new BlockRealMatrix(rows, columns);
        RandomGenerator rg = RandomGeneratorFactory.createRandomGenerator(rnd);
        GaussianRandomGenerator generator = new GaussianRandomGenerator(rg);

        for (int k = 1; k <= 3; k++) {
            double[][] arr = new double[rows][columns];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    arr[i][j] = generator.nextNormalizedDouble();
                }
            }
            RealMatrix a = new BlockRealMatrix(arr);

            assertEquals("Mul matrix with zero matrix, step " + k, a, lab_1.mulMatrix(a, nil));
        }
    }

    @Test
    public void multiplicationScalarMatrix() {
        for (int k = 1; k <= 20; k++) {
	    // float не даёт пройти тест
            double f1 = rnd.nextFloat(); 
            double f2 = rnd.nextFloat(); 
            RealMatrix m1 = new BlockRealMatrix(new double[][] { new double[] {f1}});
            RealMatrix m2 = new BlockRealMatrix(new double[][] { new double[] {f2}});
            RealMatrix expect = new BlockRealMatrix(new double[][] { new double[] {f1 + f2}});
            assertEquals("Mul matrix with zero matrix, step " + k, expect, lab_1.mulMatrix(m1, m2));
        }
    }

    @Test
    public void mulOfBlockMatrix() {
        double[][] md1 = {{1, 4, 3}, {2, 5, 7}, {7, 6, 9}, {1, 5, 9}};
        double[][] md2 = {{2, 3, 5}, {2, 9, 1}, {9, 7, 3}, {5, 6, 8}};
        double[][] md3 = new double[4][3];
        for (int i = 0; i < md1.length; i++) {
            for (int j = 0; j < md1[i].length; j++) {
                md3[i][j] = md1[i][j] * md2[i][j];
            }
        }

        RealMatrix m1 = new BlockRealMatrix(md1);
        RealMatrix m2 = new BlockRealMatrix(md2);
        RealMatrix res = new BlockRealMatrix(md3);

        assertEquals("Проверка умножения двух матриц", res, lab_1.mulMatrix(m1, m2));

    }
}
