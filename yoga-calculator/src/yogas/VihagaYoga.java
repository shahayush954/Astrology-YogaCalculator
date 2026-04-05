package yogas;

import birthChart.BirthChart;
import chartBlocks.Houses;
import chartBlocks.Planets;

import java.util.HashSet;
import java.util.Set;

/*
 * Vihaga Yoga: the seven classical grahas all occupy only the 4th and 10th houses (the other pair of
 * opposite kendras), and each of those two houses has at least one of them. Rahu and Ketu are ignored.
 */
public class VihagaYoga extends AbstractYoga {

    public VihagaYoga() {
        setYogaName("Vihaga Yoga");
        setYogaEffect("When every traditional graha is confined to the 4th and 10th from Lagna, with both angles occupied, home and career absorb the whole planetary field — a pattern likened to a bird’s span between foundation and visibility when the chart agrees.");
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
            if (n != 4 && n != 10) {
                return false;
            }
            housesOccupiedBySeven.add(n);
        }
        return housesOccupiedBySeven.size() == 2;
    }
}
