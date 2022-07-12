import java.util.Scanner;
public class StepTracker {
    private MonthData[] monthData;
    private Convert converter;
    private int dailySteps; // необходимое количество шагов в день

    // Конструктор для StepTracker'a
    public StepTracker() {
        converter = new Convert();
        dailySteps = 10000;
        monthData = new MonthData[12];
        for (int i = 0; i < monthData.length; i++) {
            monthData[i] = new MonthData();
        }
    }

    // setter для необходимого количества шагов в день
    public void setDailySteps(int steps) {
        dailySteps = steps;
    }

    // getter и setter для пройденного количества в шагов в опреленный месяц в определенный день
    public void setMonthData(int month, int day, int steps) {
        monthData[month].setStepsCount(day, steps);
    }

    public int getDailyData(int month, int day) {
        return monthData[month].getDailySteps(day);
    }

    public int[] getMonthData(int month) {
        return monthData[month].getStepsCount();
    }

    // поиск максимального количества шагов за определенный месяц
    public int maxMonthlySteps(int month) {
        return monthData[month].maxStepsPerDay();
    }

    // поиск среднего количества шагов за месяц
    public int averageSteps(int month) {
        int stepsSum = monthData[month].sumOfSteps();
        if (stepsSum == 0) {
            return 0;
        }
        return stepsSum / monthData[month].getLengthOfMonth();
    }

    public double coveredDist(int month) {
        return converter.convertToKm(monthData[month].sumOfSteps());
    }

    public double spentCalories(int month) {
        return converter.convertToCal(monthData[month].sumOfSteps());
    }

    // поиск наибольшей последовательности подряд идущих дней
    public int findBestSeries(int month) {
        int count = 0, max = 0;
        for (int i = 0; i < monthData[month].getLengthOfMonth(); i++) {
            if (monthData[month].getDailySteps(i) >= dailySteps) {
                count++;
            } else {
                count = 0;
            }

            if (count > max) {
                max = count;
            }
        }
        return max;
    }

    public int sumOfSteps(int month) {
        return monthData[month].sumOfSteps();
    }

    // setter'ы для статистики
    public void setDailyStatistics(Scanner scanner,StepTracker tracker, Menu menu) {
        menu.monthMenu();
        int month = scanner.nextInt();
        if (tracker.checkMonthNumber(month)) {
            System.out.println("Введите верный номер месяца: ");
            month = scanner.nextInt();
        }

        System.out.println("Введите день месяца: ");
        int day = scanner.nextInt();
        if (tracker.checkDayNumber(day)) {
            System.out.println("Введите верную дату: ");
            day = scanner.nextInt();
        }

        System.out.println("Введите количество шагов, пройденных в этот день");
        int steps = scanner.nextInt();
        if (tracker.checkStepsNumber(steps)) {
            System.out.println("Введите верное количество шагов: ");
            steps = scanner.nextInt();
        }

        setMonthData(month, day-1, steps);
        System.out.println("Количество шагов сохранено");
    }

    // getter для месячной статистики
    public void getMonthStatistics(Scanner scanner,StepTracker tracker, Menu menu) {
        menu.monthMenu();
        int month = scanner.nextInt();
        if (tracker.checkMonthNumber(month)) {
            System.out.println("Введите верный номер месяца: ");
            month = scanner.nextInt();
        }

        menu.uiStepStatistics(tracker, month);
    }

    // изменение цели по количеству шагов
    public void changeDailySteps(Scanner scanner, StepTracker tracker) {
        System.out.println("Введите цель по количеству шагов: ");
        int dailySteps = scanner.nextInt();

        if (tracker.checkStepsNumber(dailySteps)) {
            System.out.println("Введите верное количество шагов: ");
            dailySteps = scanner.nextInt();
        }

        tracker.setDailySteps(dailySteps);
        System.out.println("Цель изменена");
    }

    // Проверка входимых данных
    public boolean checkMonthNumber(int monthNumber) {
        return monthNumber < 0 || monthNumber > 11;
    }

    public boolean checkDayNumber(int dayNumber) {
        return dayNumber < 0 || dayNumber > 30;
    }

    public boolean checkStepsNumber(int dailySteps) {
        return dailySteps < 0;
    }
}

class MonthData {
    private int days; // количество дней в месяце
    private int[] stepsCount; // массив для хранения шагов в каждом дне месяца
    // конструктор для объекта
    MonthData() {
        days = 30;
        stepsCount = new int[days];
    }
    // setter и getter для количества шагов пройденных за день
    public void setStepsCount(int day, int steps) {
        stepsCount[day] = steps;
    }

    public int getDailySteps(int day) {
        return stepsCount[day];
    }

    public int[] getStepsCount() { return stepsCount; }
    public int getLengthOfMonth() { // getter длина месяца
        return days;
    }

    // общее количество шагов за месяц
    public int sumOfSteps() {
        int stepsSum = 0;
        for (int steps : stepsCount) {
            stepsSum += steps;
        }
        return stepsSum;
    }

    // поиск максимального количества шагов за месяц
    public int maxStepsPerDay() {
        int max = 0;
        for (int j : stepsCount) {
            if (j > max)
                max = j;
        }
        return max;
    }
}
