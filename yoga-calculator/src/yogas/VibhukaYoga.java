package yogas;

import birthChart.BirthChart;
import chartBlocks.Houses;
import chartBlocks.Planets;

import java.util.HashSet;
import java.util.Set;

/*
 * Vibhuka Yoga: the seven classical grahas all occupy only the third pair of consecutive kendras —
 * the 7th and 10th houses — and each of those two houses has at least one of them. Rahu and Ketu are ignored.
 */
public class VibhukaYoga extends AbstractYoga {

    public VibhukaYoga() {
        setYogaName("Vibhuka Yoga");
        setYogaEffect("When every traditional graha is confined to the 7th and 10th from Lagna, with both angles occupied, marriage, public life, and career share one intense band of influence — a pattern for visibility and alliances when other factors agree.");
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
            if (n != 7 && n != 10) {
                return false;
            }
            housesOccupiedBySeven.add(n);
        }
        return housesOccupiedBySeven.size() == 2;
    }
}
