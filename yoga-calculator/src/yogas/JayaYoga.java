package yogas;

import birthChart.BirthChart;
import chartBlocks.Houses;
import chartBlocks.Planets;
import chartBlocks.Rashis;

import java.util.List;

/*
 * Jaya Yoga: the lord of the 6th house is debilitated, and the lord of the 10th is either exalted
 * or in its own sign (Rashi chart).
 */
public class JayaYoga extends AbstractYoga {

    public JayaYoga() {
        setYogaName("Jaya Yoga");
        setYogaEffect("Victory and rise through overcoming obstacles when the chart supports it: a weakened 6th-lord reduces chronic friction, while a strong 10th-lord lifts career, name, and command.");
    }

    @Override
    public boolean isYogaPresent(BirthChart birthChartData) {
        Planets lordOfSixth = birthChartData.getLordOfHouse(Houses.SIXTH_HOUSE);
        Planets lordOfTenth = birthChartData.getLordOfHouse(Houses.TENTH_HOUSE);
        if (lordOfSixth == null || lordOfTenth == null) {
            return false;
        }
        if (!isDebilitated(birthChartData, lordOfSixth)) {
            return false;
        }
        return isExaltedOrOwnSign(birthChartData, lordOfTenth);
    }

    private static boolean isDebilitated(BirthChart birthChart, Planets planet) {
        Rashis debilitation = birthChart.getDebilitationRashi(planet);
        if (debilitation == null) {
            return false;
        }
        Rashis rashi = birthChart.getPlanetWiseRashis().get(planet);
        return rashi != null && rashi.equals(debilitation);
    }

    private static boolean isExaltedOrOwnSign(BirthChart birthChart, Planets planet) {
        Rashis rashi = birthChart.getPlanetWiseRashis().get(planet);
        if (rashi == null) {
            return false;
        }
        Rashis exaltation = birthChart.getExaltationRashi(planet);
        if (exaltation != null && rashi.equals(exaltation)) {
            return true;
        }
        List<Rashis> owned = birthChart.getRashiLords().get(planet);
        return owned != null && owned.contains(rashi);
    }
}
