package homework.ls_06_interfaces.task1;

public class Main {
    public static void main(String[] args) {

        DailyWorker dailyWorker = new DailyWorker(20);
        MonthlyWorker monthlyWorker = new MonthlyWorker(1);

        System.out.println(dailyWorker);
        System.out.println(monthlyWorker);

    }
}
