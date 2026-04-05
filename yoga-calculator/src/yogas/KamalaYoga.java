package yogas;

import birthChart.BirthChart;
import chartBlocks.Houses;
import chartBlocks.Planets;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/*
 * Kamala Yoga (Nabhasa): the seven classical grahas (Sun through Saturn) all occupy only the four
 * kendra houses from Lagna — the 1st, 4th, 7th, and 10th — and each of those four houses has at least
 * one of them. Rahu and Ketu are ignored.
 */
public class KamalaYoga extends AbstractYoga {

    private static final Set<Integer> KENDRA_HOUSE_NUMBERS = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(
            1, 4, 7, 10
    )));

    public KamalaYoga() {
        setYogaName("Kamala Yoga");
        setYogaEffect("When every traditional graha sits in the four angles from Lagna with no kendra empty among them, the chart can resemble the lotus — prominence, support from the four pillars of life, and visibility when other factors agree.");
    }

    @Override
    public boolean isYogaPresent(BirthChart birthChartData) {
        Set<Integer> occupied = new HashSet<>();
        for (Planets planet : Planets.SEVEN_GRAHAS) {
            Houses house = birthChartData.getPlanetHouses().get(planet);
            if (house == null) {
                return false;
            }
            int n = house.getHouseNumber();
            if (!KENDRA_HOUSE_NUMBERS.contains(n)) {
                return false;
            }
            occupied.add(n);
        }
        return occupied.size() == 4;
    }
}
