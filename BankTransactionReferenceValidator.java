import java.util.Scanner;

public class BankTransactionReferenceValidator {
    static String normalizeReference(String raw) {
        String reference = raw.trim();
        if (reference.length() >= 3) {
            reference = reference.substring(0, 3).toUpperCase()
                    + reference.substring(3);
        }
        return reference;
    }

    static String validateAndFormat(String reference) {
        if (reference.length() != 14) return "Invalid: wrong length";

        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(reference.charAt(i))) {
                return "Invalid: bank code must be 3 letters";
            }
        }
        for (int i = 3; i < reference.length(); i++) {
            if (!Character.isDigit(reference.charAt(i))) {
                return "Invalid: body must contain only digits";
            }
        }

        String date = reference.substring(3, 5) + "/"
                + reference.substring(5, 7) + "/"
                + reference.substring(7, 9);
        StringBuilder output = new StringBuilder();
        output.append("[").append(reference.substring(0, 3)).append("] DATE: ")
                .append(date).append(" | SEQ: ").append(reference.substring(9));
        return output.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter transaction reference: ");
        String reference = normalizeReference(sc.nextLine());
        System.out.println(validateAndFormat(reference));
        sc.close();
    }
}