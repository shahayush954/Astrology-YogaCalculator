package yogas;

import birthChart.BirthChart;
import chartBlocks.Houses;
import chartBlocks.Planets;
import chartBlocks.Rashis;

/*
Sasa Yoga occurs when Saturn occupies one of the Kendra houses (1st, 4th, 7th or 10th)
and is placed in either its own sign or its sign of exaltation.
 */
public class SasaYoga extends AbstractYoga {

    public SasaYoga() {
        setYogaName("Sasa Yoga");
        setYogaEffect("This is one of the PanchaMahaPurush Yogas. The native gains authority, discipline and lasting success. Saturn in a Kendra in own or exaltation sign bestows leadership, patience, responsibility and respect. The person may hold positions of power or excel in fields requiring perseverance. One born in this Yoga will command good servants. His character will be questionable' He will be head of a village or a town or even a King, will covet other's riches and will be wicked in disposition");
    }

    @Override
    public boolean isYogaPresent(BirthChart birthChartData) {
        Houses houseOfSaturn = birthChartData.getPlanetHouses().get(Planets.SATURN);
        if (houseOfSaturn == null || !BirthChart.KENDRA_HOUSES.contains(houseOfSaturn)) {
            return false;
        }

        Rashis saturnRashi = birthChartData.getPlanetWiseRashis().get(Planets.SATURN);
        if (saturnRashi == null) {
            return false;
        }

        boolean inOwnSign = birthChartData.getOwnHousePlanets().containsKey(Planets.SATURN);
        Rashis exaltationRashi = birthChartData.getExaltationRashi(Planets.SATURN);
        boolean inExaltedSign = exaltationRashi != null && saturnRashi == exaltationRashi;

        return inOwnSign || inExaltedSign;
    }
}
