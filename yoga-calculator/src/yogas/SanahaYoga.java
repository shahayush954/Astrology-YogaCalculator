package yogas;

import birthChart.BirthChart;
import chartBlocks.Houses;
import chartBlocks.Planets;

import java.util.HashSet;
import java.util.Set;

/*
 * Sanaha Yoga: the seven classical grahas all occupy only the second pair of consecutive kendras —
 * the 4th and 7th houses — and each of those two houses has at least one of them. Rahu and Ketu are ignored.
 */
public class SanahaYoga extends AbstractYoga {

    public SanahaYoga() {
        setYogaName("Sanaha Yoga");
        setYogaEffect("When every traditional graha is confined to the 4th and 7th from Lagna, with both angles occupied, home, happiness, and partnership are densely packed — a pattern for emotional and relational focus when the chart agrees.");
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
            if (n != 4 && n != 7) {
                return false;
            }
            housesOccupiedBySeven.add(n);
        }
        return housesOccupiedBySeven.size() == 2;
    }
}
