package chartBlocks;

public enum Planets {

    SUN("Sun"),
    MOON("Moon"),
    JUPITER("Jupiter"),
    RAHU("Rahu"),
    MERCURY("Mercury"),
    VENUS("Venus"),
    KETU("Ketu"),
    SATURN("Saturn"),
    MARS("Mars");

    private final String planetName;
    Planets(String planetName) { this.planetName = planetName; }

    @Override
    public String toString() {
        return super.toString();
    }
}
