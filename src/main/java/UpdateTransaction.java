import java.util.Scanner;

public class UpdateTransaction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TransactionDao transactionDao = new TransactionDao();

        System.out.println("Podaj elemtnt id który chcesz zmienić");
        long id = scanner.nextLong();
        scanner.nextLine();

        System.out.println("Podaj nowy typ: ");
        String type = scanner.nextLine();

        System.out.println("Podaj opis: ");
        String description = scanner.nextLine();

        System.out.println("Podaj wartość kwoty do zmiany: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Podaj datę tranzakcji: ");
        String date = scanner.nextLine();

        transactionDao.update(new Transaction(id, type, description, amount, date));

    }
}
