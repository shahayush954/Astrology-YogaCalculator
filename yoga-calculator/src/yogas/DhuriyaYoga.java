package yogas;

import birthChart.BirthChart;
import chartBlocks.Houses;
import chartBlocks.Planets;

import java.util.HashSet;
import java.util.Set;

/*
 * Dhuriya Yoga: the seven classical grahas all occupy only the pair of consecutive kendras that wrap
 * from the 10th into the 1st — houses 10 and 1 — and each of those two houses has at least one of them.
 * Rahu and Ketu are ignored.
 */
public class DhuriyaYoga extends AbstractYoga {

    public DhuriyaYoga() {
        setYogaName("Dhuriya Yoga");
        setYogaEffect("When every traditional graha is confined to the 10th and Lagna, with both angles occupied, karma and self close the kendra loop — a pattern for duty, recognition, and personal drive when the chart agrees.");
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
            if (n != 1 && n != 10) {
                return false;
            }
            housesOccupiedBySeven.add(n);
        }
        return housesOccupiedBySeven.size() == 2;
    }
}
