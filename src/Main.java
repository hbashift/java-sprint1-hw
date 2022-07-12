import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Menu menu = new Menu();
        Scanner scanner = new Scanner(System.in);
        StepTracker tracker = new StepTracker();
        menu.print();

        int userInput = scanner.nextInt();

        while (true) {
            if (userInput == 1) {
                tracker.setDailyStatistics(scanner,tracker, menu);
            }

            else if (userInput == 2) {
                tracker.getMonthStatistics(scanner,tracker, menu);
            }
            else if (userInput == 3) {
                tracker.changeDailySteps(scanner, tracker);
            }

            else if (userInput == 0) {
                break;
            }

            else {
                System.out.println("Введеная команда не существует!\n");
            }
            menu.print();
            userInput = scanner.nextInt();
        }
    }
}
