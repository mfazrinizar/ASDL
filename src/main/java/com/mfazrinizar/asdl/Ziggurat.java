package com.mfazrinizar.asdl;

/*
 * Author       : M. Fazri Nizar
 * Institution : Sriwijaya University
 * GitHub       : github.com/mfazrinizar/ASDL
 */

// Ignore this file

public class Ziggurat {
    private static final int R = 3;
    private static final double[] v = {0.9189385332046727, 0.49999999999999994, 0.2895301641589497, 0.1315224747044233, 0.04385246401658114, 0.009394006567103567, 0.0012322191684736888, 0.00005061016293492666};
    private static final int[] xToInt = {0, 1059061760, 1071067339, 1072734506, 1073741824, 1074266112, 1074790400, 1074790400, Integer.MAX_VALUE};

    public static double nextGaussian() {
        while (true) {
            int j = randomInt();
            int i = j & 0x7;
            int sign = j & 0x8;
            int x = j >>> 4;
            if (j < xToInt[i]) {
                return (sign == 0 ? -1 : 1) * x * 2.3283064365386963E-10 * v[i];
            }
            if (i < 7) {
                if (x < xToInt[i + 1]) {
                    return (sign == 0 ? -1 : 1) * (x * 2.3283064365386963E-10 * v[i] + (xToInt[i + 1] - x) * 2.3283064365386963E-10 * v[i + 1]);
                }
                double u = 2.3283064365386963E-10 * (x - xToInt[i + 1]);
                double v = Ziggurat.v[i + 1] + u * (Ziggurat.v[i] - Ziggurat.v[i + 1]);
                if (v + u * (R + x) > Math.exp(-0.5 * x * x)) {
                    continue;
                }
                return (sign == 0 ? -1 : 1) * u;
            } else {
                while (true) {
                    double u = -Math.log(randomDouble());
                    double v = -Math.log(randomDouble());
                    if (u + u > v + v) {
                        break;
                    }
                    return (sign == 0 ? -1 : 1) * R + u;
                }
            }
        }
    }

    private static int randomInt() {
        return (int) (Math.random() * Integer.MAX_VALUE);
    }

    private static double randomDouble() {
        return Math.random();
    }
}