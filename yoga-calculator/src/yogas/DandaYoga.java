package yogas;

import birthChart.BirthChart;
import chartBlocks.Houses;
import chartBlocks.Planets;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/*
 * Danda Yoga: like Sakti Yoga, but the four consecutive whole-sign houses begin from the 10th and wrap
 * after the 12th — the 10th, 11th, 12th, and 1st. All seven classical grahas lie in that block and each
 * of those houses holds at least one of them. Rahu and Ketu are ignored.
 */
public class DandaYoga extends AbstractYoga {

    private static final Set<Integer> BLOCK_HOUSES = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(
            1, 10, 11, 12
    )));

    public DandaYoga() {
        setYogaName("Danda Yoga");
        setYogaEffect("When every traditional graha sits in the arc from the 10th through the 12th and into the Lagna, with none of those four houses empty among them, career, gains, closure, and self are tightly linked — a pattern for authority and discipline when the chart agrees.");
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
            if (!BLOCK_HOUSES.contains(n)) {
                return false;
            }
            housesOccupiedBySeven.add(n);
        }
        return housesOccupiedBySeven.size() == 4;
    }
}
