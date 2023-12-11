import java.math.BigInteger;
import java.util.Scanner;

public class BigIntegerCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Istalgan amalni tanlang:");
            System.out.println("1. Qo'shish");
            System.out.println("2. Ayirish");
            System.out.println("3. Ko'paytirish");
            System.out.println("4. Bo'lish");
            System.out.println("0. Chiqish");

            int amal = scanner.nextInt();

            if (amal == 0) {
                System.out.println("Dasturni tugatildi.");
                break;
            }

            System.out.print("Birinchi sonni kiriting: ");
            BigInteger operand1 = scanner.nextBigInteger();

            System.out.print("Ikkinchi sonni kiriting: ");
            BigInteger operand2 = scanner.nextBigInteger();

            BigInteger natija = BigInteger.ZERO;

            switch (amal) {
                case 1:
                    natija = operand1.add(operand2);
                    break;
                case 2:
                    natija = operand1.subtract(operand2);
                    break;
                case 3:
                    natija = operand1.multiply(operand2);
                    break;
                case 4:
                    if (!operand2.equals(BigInteger.ZERO)) {
                        natija = operand1.divide(operand2);
                    } else {
                        System.out.println("Nolga bo'lish mumkin emas!");
                        continue;
                    }
                    break;
                default:
                    System.out.println("Noto'g'ri amal kiritildi!");
                    continue;
            }

            System.out.println("Natija: " + natija);
        }

        scanner.close();
    }
}
