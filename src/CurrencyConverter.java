import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;
import java.util.Scanner;

public class CurrencyConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Valyuta kurslari
        BigDecimal usdToUzbekSumRate = new BigDecimal("12500"); // O'zbek so'mi uchun 1 AQSh dollari
        BigDecimal usdToEuroRate = new BigDecimal("0.85"); // Euro uchun 1 AQSh dollari

        // Foydalanuvchi kiritishi kerak bo'lgan qiymat
        System.out.print("Kiritilayotgan summani kiriting ($): ");
        String userInput = scanner.nextLine();

        // Foydalanuvchi kiritgan qiymatni BigDecimalga o'tkazamiz
        BigDecimal userAmount = new BigDecimal(userInput);

        // O'zbek so'miga almashtiramiz
        BigDecimal sumInUzbekSum = userAmount.multiply(usdToUzbekSumRate);

        // Euroga almashtiramiz
        BigDecimal sumInEuro = userAmount.multiply(usdToEuroRate);

        // Natijalarni ekranga chiqaramiz
        System.out.println("Natija sumida: " + formatCurrency(sumInUzbekSum, "UZS"));
        System.out.println("Natija euroda: " + formatCurrency(sumInEuro, "EUR"));
    }

    // Qiymatlarni valyuta formatida ekranga chiqarish uchun funktsiya
    private static String formatCurrency(BigDecimal amount, String currencyCode) {
        Currency currency = Currency.getInstance(currencyCode);
        Locale locale = new Locale("uz", "UZ"); // O'zbekiston uchun locale

        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
        currencyFormatter.setCurrency(currency);

        return currencyFormatter.format(amount);
    }
}
