package yogas;

import birthChart.BirthChart;
import chartBlocks.Houses;
import chartBlocks.Planets;

/*
If there are planets (excepting the Sun) in the second house from the Moon, Sunapha is caused.
 */
public class SunaphaYoga extends AbstractYoga{

    public SunaphaYoga() {
        setYogaName("Sunapha Yoga");
        setYogaEffect("Self-earned property, king, ruler or his equal, intelligent, wealthy and good reputation.");
    }
    @Override
    public boolean isYogaPresent(BirthChart birthChartData) {
        Houses houseOfMoon = birthChartData.getPlanetHouses().get(Planets.MOON);
        Houses secondFromMoon = birthChartData.getNthHouseFromGivenHouse(houseOfMoon, 2);

        if (birthChartData.getHouseWisePlanets().containsKey(secondFromMoon)) {
            return birthChartData.getHouseWisePlanets().get(secondFromMoon).size() != 1
                    || !birthChartData.getHouseWisePlanets().get(secondFromMoon).contains(Planets.SUN);
        }

        return false;
    }
}
