import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker tracker = new StepTracker();
        Menu.print();

        int userInput = scanner.nextInt();

        while(true) {
            // TODO доделать обработку команд
            if(userInput == 1) {
                System.out.println("Введите номер месяца: \n" +
                        "0 - январь, 1 - февраль, 2 - марта, 3 - апрель\n" +
                        "4 - май, 5 - июнь, 6 - июль, 7 - август\n" +
                        "8 - сентябрь, 9 - октябрь, 10 - ноябрь, 11 - декабрь");
                int month = scanner.nextInt();

                System.out.print("Введите день месяца: \n");
                int day = scanner.nextInt();

                System.out.println("Введите количество шагов, пройденных в этот день");
                int steps = scanner.nextInt();

                tracker.setMonthData(month, day-1, steps);
                System.out.println("Количество шагов сохранено");
            }

            else if(userInput == 0) {
                break;
            }
            Menu.print();
            userInput = scanner.nextInt();
        }
    }
}

