import java.util.Scanner;

public class LibraryISBNNormalizerValidator {
    static String normalizeCode(String raw) {
        String code = raw.trim();
        if (code.length() >= 3) {
            code = code.substring(0, 3).toUpperCase() + code.substring(3);
        }
        return code;
    }

    static String validateAndFormat(String code) {
        if (code.length() != 13) return "Invalid: wrong length";

        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(code.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }
        for (int i = 3; i < code.length(); i++) {
            if (!Character.isDigit(code.charAt(i))) {
                return "Invalid: body must contain only digits";
            }
        }

        StringBuilder output = new StringBuilder();
        output.append("[").append(code.substring(0, 3)).append("] YEAR: ")
                .append(code.substring(3, 7)).append(" | CATALOG: ")
                .append(code.substring(7));
        return output.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter ISBN-style code: ");
        String code = normalizeCode(sc.nextLine());
        System.out.println(validateAndFormat(code));
        sc.close();
    }
}