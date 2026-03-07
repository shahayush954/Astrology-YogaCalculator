package yogas;

import birthChart.BirthChart;
import chartBlocks.Houses;
import chartBlocks.Planets;

/*
lf there are planets in the 12th from the Moon, Anapha Yoga is formed.
In Anapha also the Sun is not taken into account. The remarks made for Sunapha apply to this also with
slight variation.
 */
public class AnaphaYoga extends AbstractYoga{

    public AnaphaYoga() {
        setYogaName("Anapha Yoga");
        setYogaEffect("Well-formed organs, majestic appearance, good reputation, polite, generous, self-respect, fond of dress and sense pleasures. In later life, renunciation and austerity. ");
    }

    @Override
    public boolean isYogaPresent(BirthChart birthChartData) {
        Houses houseOfMoon = birthChartData.getPlanetHouses().get(Planets.MOON);
        Houses twelvthFromMoon = birthChartData.getNthHouseFromGivenHouse(houseOfMoon, 12);

        if (birthChartData.getHouseWisePlanets().containsKey(twelvthFromMoon)) {
            return birthChartData.getHouseWisePlanets().get(twelvthFromMoon).size() != 1
                    || !birthChartData.getHouseWisePlanets().get(twelvthFromMoon).contains(Planets.SUN);
        }

        return false;
    }
}
