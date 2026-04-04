package yogas;

import birthChart.BirthChart;
import chartBlocks.Houses;
import chartBlocks.Planets;
import chartBlocks.Rashis;

/*
 * Go Yoga: Jupiter occupies his Moolatrikona sign ({@link BirthChart#getMoolatrikonaRashi} for
 * Jupiter) together with the lord of the 2nd house (same sign / whole-sign conjunction), and the
 * lord of the Lagna is exalted.
 */
public class GoYoga extends AbstractYoga {

    public GoYoga() {
        setYogaName("Go Yoga");
        setYogaEffect("Jupiter strong in his Moolatrikona with the 2nd lord, and an exalted Lagna lord, can support wealth, voice, learning, and a respected sense of self when the chart agrees.");
    }

    @Override
    public boolean isYogaPresent(BirthChart birthChartData) {
        Rashis jupiterRashi = birthChartData.getPlanetWiseRashis().get(Planets.JUPITER);
        Rashis jupiterMoolatrikona = birthChartData.getMoolatrikonaRashi(Planets.JUPITER);
        if (jupiterRashi == null || jupiterMoolatrikona == null || !jupiterRashi.equals(jupiterMoolatrikona)) {
            return false;
        }

        Planets lordOfSecond = birthChartData.getLordOfHouse(Houses.SECOND_HOUSE);
        if (lordOfSecond == null) {
            return false;
        }
        Rashis secondLordRashi = birthChartData.getPlanetWiseRashis().get(lordOfSecond);
        if (secondLordRashi == null || !secondLordRashi.equals(jupiterRashi)) {
            return false;
        }

        Planets lagnaLord = birthChartData.getLordOfHouse(Houses.FIRST_HOUSE);
        if (lagnaLord == null) {
            return false;
        }
        Rashis lagnaLordRashi = birthChartData.getPlanetWiseRashis().get(lagnaLord);
        Rashis lagnaLordExaltation = birthChartData.getExaltationRashi(lagnaLord);
        return lagnaLordRashi != null && lagnaLordExaltation != null
                && lagnaLordRashi.equals(lagnaLordExaltation);
    }
}
