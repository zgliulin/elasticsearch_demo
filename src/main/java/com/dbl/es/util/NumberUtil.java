package com.dbl.es.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

/**
 * descrription:
 * <p>
 * Create by DbL on 2022/8/13 8:41
 */
public class NumberUtil extends org.springframework.util.NumberUtils {
    public static double randomDouble(double start, double end, int scal) {
        Random random = new Random();
        double d = random.nextDouble() * (end - start) + start;
        BigDecimal bigDecimal = BigDecimal.valueOf(d);
        return bigDecimal.setScale(scal, RoundingMode.HALF_DOWN).doubleValue();
    }

    public static int randomInt(int start, int end) {
        Random random = new Random();
        return random.nextInt(end - start) + start;
    }
}
