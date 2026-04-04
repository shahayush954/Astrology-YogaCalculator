package yogas;

import birthChart.BirthChart;
import chartBlocks.Houses;
import chartBlocks.Planets;

import java.util.HashSet;
import java.util.Set;

/*
 * Sakti Yoga: like Ishu Yoga, but the four consecutive whole-sign houses begin from the 7th — the 7th,
 * 8th, 9th, and 10th. All seven classical grahas lie in that block and each of those houses holds at
 * least one of them. Rahu and Ketu are ignored.
 */
public class SaktiYoga extends AbstractYoga {

    private static final int BLOCK_START = 7;
    private static final int BLOCK_END = 10;

    public SaktiYoga() {
        setYogaName("Sakti Yoga");
        setYogaEffect("When every traditional graha sits in the four houses from the 7th through the 10th with none of those houses empty among them, partnership, transformation, dharma, and career are intensely bundled — a pattern for outward power and purpose when the chart agrees.");
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
