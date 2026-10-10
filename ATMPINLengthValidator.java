import java.util.Scanner;

public class ATMPINLengthValidator {
    static void checkPinLength(String pin) {
        if (pin.length() != 4) {
            System.out.println("Invalid PIN — must be exactly 4 digits.");
        } else {
            boolean digitsOnly = true;
            for (int i = 0; i < pin.length(); i++) {
                if (!Character.isDigit(pin.charAt(i))) digitsOnly = false;
            }
            if (digitsOnly) System.out.println("PIN length OK.");
            else System.out.println("Invalid PIN — must be exactly 4 digits.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter PIN: ");
        checkPinLength(sc.nextLine());
        sc.close();
    }
}