package ru.hse.java2026;

import java.math.BigDecimal;
import java.math.BigInteger;

public class SumBigDecimalHex {
    public static void main(String[] args) {

        BigDecimal sum = BigDecimal.ZERO;

        for (String arg : args) {

            String[] tokens = arg.split("\\p{javaWhitespace}+");

            for (String token : tokens) {
                if (token.isEmpty()) {
                    continue;
                }


                String lowerToken = token.toLowerCase();


                if (lowerToken.startsWith("0x") || lowerToken.startsWith("-0x") || lowerToken.startsWith("+0x")) {


                    String hexPart = lowerToken.replace("0x", "");


                    if (hexPart.startsWith("+")) {
                        hexPart = hexPart.substring(1);
                    }


                    if (hexPart.contains("s")) {
                        int sIndex = hexPart.indexOf('s');
                        String mantissaStr = hexPart.substring(0, sIndex);
                        String scaleStr = hexPart.substring(sIndex + 1);

                        if (mantissaStr.startsWith("+")) mantissaStr = mantissaStr.substring(1);
                        if (scaleStr.startsWith("+")) scaleStr = scaleStr.substring(1);


                        BigInteger mantissa = new BigInteger(mantissaStr, 16);
                        int scale = Integer.parseInt(scaleStr, 16);


                        sum = sum.add(new BigDecimal(mantissa, scale));
                    } else {

                        BigInteger mantissa = new BigInteger(hexPart, 16);
                        sum = sum.add(new BigDecimal(mantissa));
                    }
                } else {

                    sum = sum.add(new BigDecimal(token));
                }
            }
        }

        System.out.println(sum);
    }
}