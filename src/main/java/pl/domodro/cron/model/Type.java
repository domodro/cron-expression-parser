package pl.domodro.cron.model;

public enum Type {
    MINUTE(0, 59, false),
    HOUR(0, 23, false),
    DAY_OF_MONTH(1, 31, false),
    MONTH(1, 12, false),
    DAY_OF_WEEK(0, 6, true),
    COMMAND(-1, -1, false);

    private final int minValue;
    private final int maxValue;
    private final boolean overlapping;

    Type(int minValue, int maxValue, boolean overlapping) {
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.overlapping = overlapping;
    }

    public int minValue() {
        return minValue;
    }

    public int maxValue() {
        return maxValue;
    }

    public boolean isOverlapping() {
        return overlapping;
    }
}
