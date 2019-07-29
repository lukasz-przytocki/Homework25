import java.util.Scanner;

public class AddTransaction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TransactionDao transactionDao = new TransactionDao();

        System.out.println("Podaj typ: ");
        String type = scanner.nextLine();

        System.out.println("Podaj opis: ");
        String description = scanner.nextLine();

        System.out.println("Podaj wartość kwoty: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Podaj datę tranzakcji: ");
        String date = scanner.nextLine();

        transactionDao.add(new Transaction(1L, type, description, amount, date));

    }
}
