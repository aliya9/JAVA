import java.util.*;


public class Hexa 

    {

    private String hexNumberString;
    private double decimalValue;

    public void createNumberFromHex(String hexString) {
        hexNumberString = hexString;
        decimalValue = convertHexToDecimal(hexString);
    }

    public void createNumberFromDecimal(double decimal) {
        decimalValue = decimal;
        hexNumberString = convertDecimalToHex(decimal);
    }

    public String getFormattedNumber() {
        return "Hex: " + hexNumberString + ", Decimal: " + decimalValue;
    }

    private double convertHexToDecimal(String hexString) {
        boolean isNegative = false;
        if (hexString.startsWith("-")) {
            isNegative = true;
            hexString = hexString.substring(1); // Remove the negative sign
        }

        int dotIndex = hexString.indexOf('.');
        String naturalPart;
        String fractionalPart = "";

        if (dotIndex != -1) {
            naturalPart = hexString.substring(0, dotIndex);
            fractionalPart = hexString.substring(dotIndex + 1);
        } else {
            naturalPart = hexString;
        }

        double accumulator = 0;
        int length = naturalPart.length();

        for (int i = 0; i < length; i++) {
            char c = naturalPart.charAt(i);
            int baseValue = Character.digit(c, 36);
            accumulator += baseValue * Math.pow(26, length - (i + 1));
        }

        if (!fractionalPart.isEmpty()) {
            double fractionalValue = 0;
            int fracLength = fractionalPart.length();
            
            for (int i = 0; i < fracLength; i++) {
                char c = fractionalPart.charAt(i);
                int baseValue = Character.digit(c, 36);
                fractionalValue += baseValue * Math.pow(26, -1 * (i + 1));
            }

            accumulator += fractionalValue;
        }

        if (isNegative) {
            accumulator *= -1;
        }

        return accumulator;
    }

    private String convertDecimalToHex(double decimalValue) {
        boolean isNegative = false;
        if (decimalValue < 0) {
            isNegative = true;
            decimalValue = Math.abs(decimalValue);
        }

        String naturalPart = Integer.toString((int) decimalValue);
        StringBuilder stringAccumulator = new StringBuilder();

        int temp = (int) decimalValue;

        while (temp > 0) {
            int currValue = temp % 26;
            char c = (char) (currValue + 'a');
            stringAccumulator.insert(0, c);
            temp /= 26;
        }

        String fractionalPart = Double.toString(decimalValue - (int) decimalValue);

        if (!fractionalPart.equals("0.0")) {
            stringAccumulator.append('.');
            int fracLength = fractionalPart.length();
            double fracValue = Double.parseDouble(fractionalPart);

            for (int i = 0; i < fracLength; i++) {
                fracValue *= 26;
                int currValue = (int) fracValue;
                char c = (char) (currValue + 'a');
                stringAccumulator.append(c);
                fracValue -= currValue;
            }
        }

        if (isNegative) {
            stringAccumulator.insert(0, "-");
        }

        return stringAccumulator.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hexa converter = new Hexa();

        while (true) {
            System.out.println("Enter 'h' to convert from Hexadecimal to Decimal");
            System.out.println("Enter 'd' to convert from Decimal to Hexadecimal");
            System.out.println("Enter 'q' to quit");
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            if (choice.equalsIgnoreCase("h")) {
                System.out.print("Enter a Hexadecimal number: ");
                String hexInput = scanner.nextLine();
                converter.createNumberFromHex(hexInput);
                System.out.println(converter.getFormattedNumber());
            } else if (choice.equalsIgnoreCase("d")) {
                System.out.print("Enter a Decimal number: ");
                double decimalInput = scanner.nextDouble();
                scanner.nextLine(); // Consume the newline character
                converter.createNumberFromDecimal(decimalInput);
                System.out.println(converter.getFormattedNumber());
            } else if (choice.equalsIgnoreCase("q")) {
                System.out.println("Goodbye!");
                break;
            } else {
                System.out.println("Invalid input. Please try again.");
            }
        }

        scanner.close();
    }
}