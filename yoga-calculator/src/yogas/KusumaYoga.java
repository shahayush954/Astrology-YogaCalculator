package yogas;

import birthChart.BirthChart;
import chartBlocks.Houses;
import chartBlocks.Planets;

/*
 * Kusuma Yoga: Jupiter occupies the Lagna, the Moon occupies the 7th house, and the Sun occupies
 * the 8th house counted from the Moon.
 */
public class KusumaYoga extends AbstractYoga {

    public KusumaYoga() {
        setYogaName("Kusuma Yoga");
        setYogaEffect("Traditionally linked to dignity, influence, and a flourishing position in life when other factors agree. Jupiter rising, the Moon in the horizon, and the Sun in the 8th from the Moon can support leadership, reputation, and sustained honour.");
    }

    @Override
    public boolean isYogaPresent(BirthChart birthChartData) {
        if (!Houses.FIRST_HOUSE.equals(birthChartData.getPlanetHouses().get(Planets.JUPITER))) {
            return false;
        }
        Houses moonHouse = birthChartData.getPlanetHouses().get(Planets.MOON);
        if (moonHouse == null || !Houses.SEVENTH_HOUSE.equals(moonHouse)) {
            return false;
        }
        Houses eighthFromMoon = birthChartData.getNthHouseFromGivenHouse(moonHouse, 8);
        Houses sunHouse = birthChartData.getPlanetHouses().get(Planets.SUN);
        return sunHouse != null && eighthFromMoon.equals(sunHouse);
    }
}
