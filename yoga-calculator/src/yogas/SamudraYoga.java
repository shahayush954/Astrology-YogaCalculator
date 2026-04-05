package yogas;

import birthChart.BirthChart;
import chartBlocks.Houses;
import chartBlocks.Planets;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/*
 * Samudra Yoga (Nabhasa): the seven classical grahas (Sun through Saturn) all occupy only the six
 * even whole-sign houses from Lagna — the 2nd, 4th, 6th, 8th, 10th, and 12th — and each of those six
 * houses has at least one of them. Rahu and Ketu are ignored.
 */
public class SamudraYoga extends AbstractYoga {

    private static final Set<Integer> EVEN_HOUSE_NUMBERS = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(
            2, 4, 6, 8, 10, 12
    )));

    public SamudraYoga() {
        setYogaName("Samudra Yoga");
        setYogaEffect("When every traditional graha fills only the even houses from Lagna with none of those six empty, the chart can resemble the ocean — breadth of resource, flux of circumstance, and depth of experience when other factors agree.");
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
            if (!EVEN_HOUSE_NUMBERS.contains(n)) {
                return false;
            }
            occupied.add(n);
        }
        return occupied.size() == 6;
    }
}
