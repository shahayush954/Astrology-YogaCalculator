package yogas;

import birthChart.BirthChart;
import chartBlocks.Houses;
import chartBlocks.Planets;

import java.util.HashSet;
import java.util.Set;

/*
 * Yupa Yoga: the seven classical grahas (Sun through Saturn) all occupy the four consecutive houses
 * from Lagna — the 1st, 2nd, 3rd, and 4th — and each of those four houses has at least one of them.
 * Rahu and Ketu are ignored.
 */
public class YupaYoga extends AbstractYoga {

    public YupaYoga() {
        setYogaName("Yupa Yoga");
        setYogaEffect("When every traditional graha sits in the first four houses from Lagna with no empty house among them, the chart emphasises self, resources, courage, and home — a dense, formative pattern for character and early environment when other factors agree.");
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
            if (n < 1 || n > 4) {
                return false;
            }
            housesOccupiedBySeven.add(n);
        }
        return housesOccupiedBySeven.size() == 4;
    }
}
