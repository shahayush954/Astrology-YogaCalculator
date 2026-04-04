package yogas;

import birthChart.BirthChart;
import chartBlocks.Houses;
import chartBlocks.Planets;

import java.util.HashSet;
import java.util.Set;

/*
 * Ishu Yoga: like Yupa Yoga, but the four consecutive whole-sign houses begin from the 4th — the 4th,
 * 5th, 6th, and 7th. All seven classical grahas lie in that block and each of those houses holds at
 * least one of them. Rahu and Ketu are ignored.
 */
public class IshuYoga extends AbstractYoga {

    private static final int BLOCK_START = 4;
    private static final int BLOCK_END = 7;

    public IshuYoga() {
        setYogaName("Ishu Yoga");
        setYogaEffect("When every traditional graha sits in the four houses from the 4th through the 7th with none of those houses empty among them, sukha, progeny, service, and partnership themes are heavily concentrated — a pattern for rooted growth and alliances when the chart agrees.");
    }

    @Override
    public boolean isYogaPresent(BirthChart birthChartData) {
        Set<Integer> housesOccupiedBySeven = new HashSet<>();
        for (Planets planet : Planets.SEVEN_GRAHAS) {
            Houses house = birthChartData.getPlanetHouses().get(planet);
            if (house == null) {
                return false;
            }
            int n = house.getHouseNumber();
            if (n < BLOCK_START || n > BLOCK_END) {
                return false;
            }
            housesOccupiedBySeven.add(n);
        }
        return housesOccupiedBySeven.size() == 4;
    }
}
