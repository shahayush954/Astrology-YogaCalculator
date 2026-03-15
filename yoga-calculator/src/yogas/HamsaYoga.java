package yogas;

import birthChart.BirthChart;
import chartBlocks.Houses;
import chartBlocks.Planets;
import chartBlocks.Rashis;

/*
Hamsa Yoga occurs when Jupiter is in a Kendra house (1st, 4th, 7th or 10th) and is placed
in either its own sign or its sign of exaltation.
 */
public class HamsaYoga extends AbstractYoga {

    public HamsaYoga() {
        setYogaName("Hamsa Yoga");
        setYogaEffect("This yoga is considered one of PanchaMahaPurush Yogas. The native is wise, virtuous and respected. Jupiter in a Kendra in own or exaltation sign bestows knowledge, spirituality, good character and high standing in society. His legs will have the markings of a conch, lotus, fish and ankusa. He will possess a handsome body; he will be liked by others: he will be righteous in disposition and pure in mind.");
    }

    @Override
    public boolean isYogaPresent(BirthChart birthChartData) {
        Houses houseOfJupiter = birthChartData.getPlanetHouses().get(Planets.JUPITER);
        if (houseOfJupiter == null || !BirthChart.KENDRA_HOUSES.contains(houseOfJupiter)) {
            return false;
        }

        Rashis jupiterRashi = birthChartData.getPlanetWiseRashis().get(Planets.JUPITER);
        if (jupiterRashi == null) {
            return false;
        }

        boolean inOwnSign = birthChartData.getOwnHousePlanets().containsKey(Planets.JUPITER);
        Rashis exaltationRashi = birthChartData.getExaltationRashi(Planets.JUPITER);
        boolean inExaltedSign = exaltationRashi != null && jupiterRashi == exaltationRashi;

        return inOwnSign || inExaltedSign;
    }
}
