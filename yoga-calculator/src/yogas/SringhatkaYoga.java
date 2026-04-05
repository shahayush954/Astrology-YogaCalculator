package yogas;

import birthChart.BirthChart;
import chartBlocks.Houses;
import chartBlocks.Planets;

import java.util.HashSet;
import java.util.Set;

/*
 * Sringhatka Yoga: the seven classical grahas (Sun through Saturn) all occupy only the trikona houses
 * from Lagna — the 1st, 5th, and 9th — and each of those three houses has at least one of them.
 * Rahu and Ketu are ignored.
 */
public class SringhatkaYoga extends AbstractYoga {

    public SringhatkaYoga() {
        setYogaName("Sringhatka Yoga");
        setYogaEffect("When every traditional graha clusters in the dharma trikona from Lagna, with all three houses (1st, 5th, 9th) sharing the load, the chart can strongly emphasise purpose, creativity, fortune, and spiritual or ethical leanings when other factors agree.");
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
            if (n != 1 && n != 5 && n != 9) {
                return false;
            }
            occupied.add(n);
        }
        return occupied.size() == 3;
    }
}
