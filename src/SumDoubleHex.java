public class SumDoubleHex {
    public static void main(String[] args) {
        double sum = 0.0;

        for (String arg : args) {
            // Заменяем \\s+ на \\p{javaWhitespace}+
            // Это разобьет строку по ЛЮБЫМ пробельным символам Unicode
            String[] tokens = arg.split("\\p{javaWhitespace}+");

            for (String token : tokens) {
                if (token.isEmpty()) {
                    continue;
                }

                String lowerToken = token.toLowerCase();

                // Проверяем шестнадцатеричные числа и добавляем экспоненту p0 при необходимости
                if ((lowerToken.startsWith("0x") || lowerToken.startsWith("-0x") || lowerToken.startsWith("+0x"))
                        && !lowerToken.contains("p")) {
                    token = token + "p0";
                }

                // Переводим строку в double и суммируем
                sum += Double.parseDouble(token);
            }
        }

        System.out.println(sum);
    }
}