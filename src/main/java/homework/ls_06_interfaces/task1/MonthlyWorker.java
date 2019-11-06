package homework.ls_06_interfaces.task1;

public class MonthlyWorker implements Salary {

    private final static long paymentPerHour = 8;
    private long workedMonths;

    public MonthlyWorker(long workedMonths) {
        this.workedMonths = workedMonths;
    }

    public long salary() {
        return paymentPerHour * 24 * 31 * workedMonths;
    }

    @Override
    public String toString() {
        return "MonthlyWorker{" +
                "workedDays=" + workedMonths + ";" +
                "salary=" + salary() + "$" +
                '}';
    }
}
