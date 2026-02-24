public class Sum {

    public static void main(String[] args) {

        int sum = 0;

        for (String arg : args) {
            System.err.println("Обработка аргумента: [" + arg + "]");

            String newA = arg.replaceAll("[^\\d-]", " ");
            String[] tokens = newA.split("\\s+");

            for (String token : tokens) {
                if (!token.isEmpty()) {

                    int number = Integer.parseInt(token);
                    sum += number;
                    System.err.println("Найдено число: " + number + ", текущая сумма: " + sum);
                }
            }
        }

        System.out.println(sum);
    }
}