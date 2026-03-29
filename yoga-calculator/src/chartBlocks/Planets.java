package chartBlocks;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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

    /**
     * The seven classical grahas (Sun through Saturn), excluding Rahu and Ketu.
     * Shared by Malika yogas and other rules that refer to all seven planets.
     */
    public static final List<Planets> SEVEN_GRAHAS = Collections.unmodifiableList(Arrays.asList(
            SUN, MOON, MARS, MERCURY, JUPITER, VENUS, SATURN
    ));

    private final String planetName;
    Planets(String planetName) { this.planetName = planetName; }

    @Override
    public String toString() {
        return super.toString();
    }
}
