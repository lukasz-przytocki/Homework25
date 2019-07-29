import java.util.Scanner;

public class DeleteTransaction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TransactionDao transactionDao = new TransactionDao();
        System.out.println("Wprowadź id elementu do usunięcia");
        long id = scanner.nextLong();
        scanner.nextLine();
        transactionDao.remove(id);
        System.out.println("Success!");
    }
}
