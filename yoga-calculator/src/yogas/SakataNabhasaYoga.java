package yogas;

import birthChart.BirthChart;
import chartBlocks.Houses;
import chartBlocks.Planets;

import java.util.HashSet;
import java.util.Set;

/*
 * Sakata Nabhasa Yoga (negative): the seven classical grahas all occupy only the 1st and 7th houses
 * (opposite kendras), and each of those two houses has at least one of them. Rahu and Ketu are ignored.
 * Distinct rule from {@link SakataYoga} (Jupiter–Moon dusthana geometry).
 */
public class SakataNabhasaYoga extends AbstractYoga {

    public SakataNabhasaYoga() {
        setYogaName("Sakata Nabhasa Yoga");
        setYogaEffect("When all traditional grahas crowd only Lagna and the 7th, the chart can lean toward imbalance, relational stress, and narrow outlets for the grahas; comfort and stability may suffer unless other factors strongly counteract.");
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
            if (n != 1 && n != 7) {
                return false;
            }
            housesOccupiedBySeven.add(n);
        }
        return housesOccupiedBySeven.size() == 2;
    }
}
