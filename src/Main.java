import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker tracker = new StepTracker();
        Menu.print();

        int userInput = scanner.nextInt();

        // TODO доделать обработку команд
        while (true) {
            // TODO мб стоит добавить цикл, чтобы вводить данные за несколько дней подряд
            if (userInput == 1) {
                System.out.println("Введите номер месяца: \n" +
                        "0 - январь, 1 - февраль, 2 - марта, 3 - апрель\n" +
                        "4 - май, 5 - июнь, 6 - июль, 7 - август\n" +
                        "8 - сентябрь, 9 - октябрь, 10 - ноябрь, 11 - декабрь");
                int month = scanner.nextInt();
                while (month < 0 || month > 11) {
                    System.out.println("Введите верный номер месяца");
                    month = scanner.nextInt();
                }

                System.out.print("Введите день месяца: \n");
                int day = scanner.nextInt();

                while (day < 0 || day > 30) {
                    System.out.println("Введите верный день месяца");
                    day = scanner.nextInt();
                }

                System.out.println("Введите количество шагов, пройденных в этот день");
                int steps = scanner.nextInt();
                while (steps < 0) {
                    System.out.println("Введенное количество шагов отрицательное. Введите заново!");
                    steps = scanner.nextInt();
                }

                tracker.setMonthData(month, day-1, steps);
                System.out.println("Количество шагов сохранено");
            }

            else if (userInput == 2) {
                System.out.println("Введите номер месяца, за который хотите посмтореть статистику: \n" +
                        "0 - январь, 1 - февраль, 2 - марта, 3 - апрель\n" +
                        "4 - май, 5 - июнь, 6 - июль, 7 - август\n" +
                        "8 - сентябрь, 9 - октябрь, 10 - ноябрь, 11 - декабрь");
                int month = scanner.nextInt();

                Menu.uiStepStatistics(tracker, month);
            }
            else if (userInput == 3) {
                System.out.println("Введите цель по количеству шагов: ");
                int dailySteps = scanner.nextInt();
                while (dailySteps < 0) {
                    System.out.println("Введите положительное количество шагов: ");
                    dailySteps = scanner.nextInt();
                }
                tracker.setDailySteps(dailySteps);

                System.out.println("Цель изменена");
            }

            else if (userInput == 0) {
                break;
            }

            else {
                System.out.println("Введеная команда не существует!\n");
            }
            Menu.print();
            userInput = scanner.nextInt();
        }
    }
}
