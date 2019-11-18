package homework.ls_09_Exceptions.task1_Enums.year;

public enum Months {

    JANUARY(Seasons.WINTER, 31),
    FEBRUARY(Seasons.WINTER, 28),

    MARCH(Seasons.SPRING, 31),
    APRIL(Seasons.SPRING, 30),
    MAY(Seasons.SPRING, 31),

    JUNE(Seasons.SUMMER, 30),
    JULY(Seasons.SUMMER, 31),
    AUGUST(Seasons.SUMMER, 31),

    SEPTEMBER(Seasons.FALL, 30),
    OCTOBER(Seasons.FALL, 31),
    NOVEMBER(Seasons.FALL, 30),

    DECEMBER(Seasons.WINTER, 31);

    int days;
    Seasons seasons;

    Months(Seasons seasons, int days) {
        this.seasons = seasons;
        this.days = days;
    }

    public int getDays() {
        return days;
    }

    public Seasons getSeasons() {
        return seasons;
    }

}
