import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("Введите арифметическое выражение: ");
        String input = in.nextLine();

        System.out.println(calc(input));

    }

    public static String calc(String input) {
        String error = "Формат математической операции не удовлетворяет заданию: ";
        int result;
        int x = 0, y = 0;
        int[] numbs = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        String[] partsStr;

        try{
            partsStr = input.split(" ");

            if (partsStr.length != 3) {
                throw new Exception(error + "два операнда и один оператор (+, -, /, *)");
            }

            if (isNumber(partsStr[0]) && isNumber(partsStr[2])) {
                x = Integer.parseInt(partsStr[0]);
                y = Integer.parseInt(partsStr[2]);
            }

            String operator = partsStr[1];

            if (isNumberInArray(numbs, x) && isNumberInArray(numbs, y)) {
                result = switch (operator) {
                    case "+" -> x + y;
                    case "-" -> x - y;
                    case "*" -> x * y;
                    case "/" -> x / y;
                    default -> throw new Exception(error + "оператор должен быть (+, -, /, *)");
                };
            } else throw new Exception(error + "операнд имеет целочисленное значение от 1 до 10");

            return Integer.toString(result);
        }
        catch(Exception ex){

            return ex.getMessage();
        }
    }

    static boolean isNumber(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    static boolean isNumberInArray(int[] array, int number) {
        for (int item : array) {
            if (item == number) {
                return true;
            }
        }
        return false;
    }
}