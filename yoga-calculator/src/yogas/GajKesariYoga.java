package yogas;

import birthChart.BirthChart;
import chartBlocks.Houses;
import chartBlocks.Planets;

import java.util.Arrays;
import java.util.List;

/*
If Jupiter is in a kendra from the Moon the combination goes under the name Gajakesari.
 */
public class GajKesariYoga extends AbstractYoga{

    public GajKesariYoga() {
        setYogaName("GajKesari Yoga");
        setYogaEffect("Many relations, polite and generous, builder of villages and towns or magistrate over them; will have a lasting reputation even long after death.");
    }

    @Override
    public boolean isYogaPresent(BirthChart birthChartData) {
        Houses houseOfMoon = birthChartData.getPlanetHouses().get(Planets.MOON);
        Houses houseOfJupiter = birthChartData.getPlanetHouses().get(Planets.JUPITER);
        int moonHouseNum = houseOfMoon.getHouseNumber();
        Houses firstFromMoon = birthChartData.getNthHouseFromGivenHouse(houseOfMoon, 1);
        Houses fourthFromMoon = birthChartData.getNthHouseFromGivenHouse(houseOfMoon, 4);
        Houses seventhFromMoon = birthChartData.getNthHouseFromGivenHouse(houseOfMoon, 7);
        Houses tenthFromMoon = birthChartData.getNthHouseFromGivenHouse(houseOfMoon, 10);

        List<Houses> kendrasFromMoon = Arrays.asList(
                firstFromMoon, fourthFromMoon, seventhFromMoon, tenthFromMoon
        );
        return kendrasFromMoon.contains(houseOfJupiter);
    }
}
