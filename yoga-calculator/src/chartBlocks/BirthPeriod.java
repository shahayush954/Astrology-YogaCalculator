package chartBlocks;

public enum BirthPeriod {

    MORNING("Morning (Sunrise to Sunset)"),
    EVENING("Evening (Sunset to Sunrise)");

    private final String description;

    BirthPeriod(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}
