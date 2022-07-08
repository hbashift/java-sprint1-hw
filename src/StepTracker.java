public class StepTracker {
    private MonthData[] monthData;
    private int dailySteps; // необходимое количество шагов в день
    // Конструктор для StepTracker'a
    public StepTracker() {
        dailySteps = 10000;
        monthData = new MonthData[12];
        for(MonthData data : monthData) {
            data = new MonthData();
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

    public void getMonthData(int month, int day) {
        monthData[month].getStepsCount(day);
    }
    // поиск максимального количества шагов за определенный месяц
    public int maxMonthlySteps(int month, int day) {
        return monthData[month].maxStepsPerDay(day);
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

    public int getStepsCount(int day) {
        return stepsCount[day];
    }
    // поиск максимального количества шагов за месяц
    public int maxStepsPerDay(int day) {
        int max = 0;
        for (int j : stepsCount) {
            if (j > max)
                max = j;
        }
        return max;
    }
}
