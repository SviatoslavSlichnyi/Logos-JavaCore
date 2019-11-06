package homework.ls_06_interfaces.task1;

public class DailyWorker implements Salary {

    private final static long paymentPerHour = 15;
    private long workedDays;

    public DailyWorker(long workedDays) {
        this.workedDays = workedDays;
    }

    public long salary() {
        return paymentPerHour * 24 * workedDays;
    }

    @Override
    public String toString() {
        return "DailyWorker{" +
                "workedDays=" + workedDays + ";" +
                "salary=" + salary() + "$" +
                '}';
    }
}
