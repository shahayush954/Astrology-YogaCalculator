package yogas;

import birthChart.BirthChart;
import chartBlocks.Houses;
import chartBlocks.Planets;

/*
Sakata Yoga is formed when Jupiter is in the 6th, 8th or 12th house from the Moon,
or when the Moon is in the 6th, 8th or 12th house from Jupiter.
 */
public class SakataYoga extends AbstractYoga {

    public SakataYoga() {
        setYogaName("Sakata Yoga");
        setYogaEffect("Financial ups and downs, fluctuations in fortune and mental peace. The native may face obstacles, delays and uncertainty despite efforts. Effects can be modified by other chart factors. The native loses fortune and may reclaim it. He will be ordinary and insignificant. He will suffer from poverty, privation and misery. He will be stubborn and hated by relatives");
    }

    @Override
    public boolean isYogaPresent(BirthChart birthChartData) {
        Houses houseOfMoon = birthChartData.getPlanetHouses().get(Planets.MOON);
        Houses houseOfJupiter = birthChartData.getPlanetHouses().get(Planets.JUPITER);

        boolean jupiterInDusthanaFromMoon = isPlanetInDusthanaFrom(houseOfMoon, houseOfJupiter, birthChartData);
        boolean moonInDusthanaFromJupiter = isPlanetInDusthanaFrom(houseOfJupiter, houseOfMoon, birthChartData);

        return jupiterInDusthanaFromMoon || moonInDusthanaFromJupiter;
    }

    private boolean isPlanetInDusthanaFrom(Houses fromHouse, Houses planetHouse, BirthChart birthChartData) {
        for (int offset : BirthChart.DUSTHANA_OFFSETS) {
            Houses nthHouse = birthChartData.getNthHouseFromGivenHouse(fromHouse, offset);
            if (planetHouse == nthHouse) {
                return true;
            }
        }
        return false;
    }
}
