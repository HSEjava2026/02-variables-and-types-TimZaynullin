package ru.hse.java2026;

public class SumDoubleHex {
    public static void main(String[] args) {
        double sum = 0.0;

        for (String arg : args) {
            String[] tokens = arg.split("\\p{javaWhitespace}+");

            for (String token : tokens) {
                if (token.isEmpty()) {
                    continue;
                }

                String lowerToken = token.toLowerCase();

                if ((lowerToken.startsWith("0x") || lowerToken.startsWith("-0x") || lowerToken.startsWith("+0x"))
                        && !lowerToken.contains("p")) {
                    token = token + "p0";
                }
                sum += Double.parseDouble(token);
            }
        }

        System.out.println(sum);
    }
}