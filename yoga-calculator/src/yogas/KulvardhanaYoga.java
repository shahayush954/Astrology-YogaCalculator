package yogas;

import birthChart.BirthChart;
import chartBlocks.Houses;
import chartBlocks.Planets;

import java.util.HashSet;
import java.util.Set;

/*
 * Kulvardhana Yoga: each of the seven classical grahas (Sun through Saturn) lies in one of the
 * houses that are the 5th whole-sign house from the Lagna, from the Sun, or from the Moon. Rahu and
 * Ketu are ignored (may be anywhere).
 */
public class KulvardhanaYoga extends AbstractYoga {

    public KulvardhanaYoga() {
        setYogaName("Kulvardhana Yoga");
        setYogaEffect("When every traditional graha clusters in the trikona arc defined from Lagna, Sun, or Moon, the chart can strongly favour children, lineage, creativity, and dharma — expansion of the ‘kula’ when other factors agree.");
    }

    @Override
    public boolean isYogaPresent(BirthChart birthChartData) {
        Houses sunHouse = birthChartData.getPlanetHouses().get(Planets.SUN);
        Houses moonHouse = birthChartData.getPlanetHouses().get(Planets.MOON);
        if (sunHouse == null || moonHouse == null) {
            return false;
        }

        Set<Houses> allowed = new HashSet<>();
        allowed.add(birthChartData.getNthHouseFromGivenHouse(Houses.FIRST_HOUSE, 5));
        allowed.add(birthChartData.getNthHouseFromGivenHouse(sunHouse, 5));
        allowed.add(birthChartData.getNthHouseFromGivenHouse(moonHouse, 5));

        for (Planets planet : Planets.SEVEN_GRAHAS) {
            Houses h = birthChartData.getPlanetHouses().get(planet);
            if (h == null || !allowed.contains(h)) {
                return false;
            }
        }
        return true;
    }
}
