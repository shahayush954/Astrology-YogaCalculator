package yogas;

import birthChart.BirthChart;
import chartBlocks.Houses;
import chartBlocks.Planets;
import chartBlocks.Rashis;

/*
Malavya Yoga occurs when Venus occupies one of the Kendra houses (1st, 4th, 7th or 10th)
and is placed in either its own sign or its sign of exaltation.
 */
public class MalavyaYoga extends AbstractYoga {

    public MalavyaYoga() {
        setYogaName("Malavya Yoga");
        setYogaEffect("This is one of the PanchaMahaPurush Yogas. The native enjoys luxury, comfort and artistic or material success. Venus in a Kendra in own or exaltation sign bestows wealth, vehicles, property, good spouse and a refined, pleasure-loving life. The person will have a well-developed physique, will be strong-minded, wealthy, happy with children and wife, will command vehicles, endowed with clean sense-organs and renowned and learned");
    }

    @Override
    public boolean isYogaPresent(BirthChart birthChartData) {
        Houses houseOfVenus = birthChartData.getPlanetHouses().get(Planets.VENUS);
        if (houseOfVenus == null || !BirthChart.KENDRA_HOUSES.contains(houseOfVenus)) {
            return false;
        }

        Rashis venusRashi = birthChartData.getPlanetWiseRashis().get(Planets.VENUS);
        if (venusRashi == null) {
            return false;
        }

        boolean inOwnSign = birthChartData.getOwnHousePlanets().containsKey(Planets.VENUS);
        Rashis exaltationRashi = birthChartData.getExaltationRashi(Planets.VENUS);
        boolean inExaltedSign = exaltationRashi != null && venusRashi == exaltationRashi;

        return inOwnSign || inExaltedSign;
    }
}
