public class Menu {
    public static void print() {
        System.out.println("Выберите нужное действие:");
        System.out.println("1 - Ввести количество шагов за определенный день");
        System.out.println("2 - Вывести статистику за месяц");
        System.out.println("3 - Изменить цель по количеству шагов в день");
        System.out.println("0 - Выход из приложения");
    }

    public static void uiStepStatistics(StepTracker tracker, int month) {
        int[] monthData = tracker.getMonthData(month);
        System.out.println("Количество пройденных шагов по дням: ");
        for (int day = 0; day < monthData.length; day += 10) {
            System.out.println((day+1) + " день: " + monthData[day]
                    + ", " + (day+2) + " день: " + monthData[day+1] + "\n" + (day+3) + " день: " + monthData[day+2]
                    + ", " + (day+4) + " день: " + monthData[day+3] + "\n" + (day+5) + " день: " + monthData[day+4]
                    + ", " + (day+6) + " день: " + monthData[day+5] + "\n" + (day+7) + " день: " + monthData[day+6]
                    + ", " + (day+8) + " день: " + monthData[day+7] + "\n" + (day+9) + " день: " + monthData[day+8]
                    + ", " + (day+10) + " день: " + monthData[day+9]);
        }

        System.out.println("\nОбщее количество шагов: " + tracker.sumOfSteps(month));
        System.out.println("Максимальное пройденное количество шагов в месяце: " + tracker.maxMonthlySteps(month));
        System.out.println("Среднее количество шагов: " + tracker.averageSteps(month));
        System.out.println("Количество сожженных килокалорий: " + tracker.spentCalories(month));
        System.out.println("Преодоленная дистанция: " + tracker.coveredDist(month));
        System.out.println("Лучшая серия дней: " + tracker.findBestSeries(month));
    }
}
