package specialtasks.collections.hashMap;

//This class was created for demonstration how to override
// two important methods for storing information in Hash Tables (HashMaps)
public class MyDate {

    private int day;
    private int month;
    private int year;

    public MyDate(String date) {
        String[] data = date.split("\\.");

        if(data.length != 3) return;

        this.day = Integer.parseInt(data[0]);
        this.month = Integer.parseInt(data[1]);
        this.year = Integer.parseInt(data[2]);
    }

    @Override
    public boolean equals(Object o) {
        //Of course, it is needed to compare information
        // which contains objects, not their references
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyDate date = (MyDate) o;
        return day == date.day &&
                month == date.month &&
                year == date.year;
    }

    @Override
    public int hashCode() {
        //In this case I think that day of birth of somebody
        //  from list will be very difference between each other
        return day;
    }
}