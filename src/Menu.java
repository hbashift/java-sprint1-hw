public class Menu {
    public void print() {
        System.out.println("Выберите нужное действие:");
        System.out.println("1 - Ввести количество шагов за определенный день");
        System.out.println("2 - Вывести статистику за месяц");
        System.out.println("3 - Изменить цель по количеству шагов в день");
        System.out.println("0 - Выход из приложения");
    }

    public void uiStepStatistics(StepTracker tracker, int month) {
        int[] monthData = tracker.getMonthData(month);
        System.out.println("Количество пройденных шагов по дням: ");
        for (int day = 0; day < monthData.length; day += 2) {
            System.out.println((day+1) + " день: " + monthData[day] + ", " + (day+2) + " день: " + monthData[day+1]);
        }

        System.out.println("\nОбщее количество шагов: " + tracker.sumOfSteps(month));
        System.out.println("Максимальное пройденное количество шагов в месяце: " + tracker.maxMonthlySteps(month));
        System.out.println("Среднее количество шагов: " + tracker.averageSteps(month));
        System.out.println("Количество сожженных килокалорий: " + tracker.spentCalories(month));
        System.out.println("Преодоленная дистанция: " + tracker.coveredDist(month));
        System.out.println("Лучшая серия дней: " + tracker.findBestSeries(month));
    }
}
