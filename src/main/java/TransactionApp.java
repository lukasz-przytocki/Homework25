import java.sql.Date;
import java.util.Scanner;

public class TransactionApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {

            System.out.println("Operacje na tranzakcjach:");
            System.out.println("1. Dodawanie");
            System.out.println("2. Modyfikacja");
            System.out.println("3. Usuwanie");
            System.out.println("4. Wyświetlanie przychodów");
            System.out.println("5. Wyświetlanie wydatków");
            System.out.println("0. Koniec");

            int enteredInput = scanner.nextInt();
            scanner.nextLine();

            switch (enteredInput) {
                case 1:
                    AddTransaction.main(new String[0]);
                    break;
                case 2:
                    UpdateTransaction.main(new String[0]);
                    break;
                case 3:
                    DeleteTransaction.main(new String[0]);
                    break;
                case 4:
                    DisplayIncome.main(new String[0]);
                    break;
                case 5:
                    DisplayOutcome.main(new String[0]);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Błędny wybór!");
            }
        }


    }
}
