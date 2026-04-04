package yogas;

import birthChart.BirthChart;
import chartBlocks.Houses;
import chartBlocks.Planets;
import chartBlocks.Rashis;

/*
 * Vidyut Yoga: the lord of the 11th is in deep exaltation (modelled here as occupying its exaltation
 * sign in the whole-sign chart), conjoins Venus, and that shared house is a Kendra (1st, 4th, 7th,
 * or 10th) counted from the Lagna lord’s house.
 */
public class VidyutYoga extends AbstractYoga {

    public VidyutYoga() {
        setYogaName("Vidyut Yoga");
        setYogaEffect("Lightning-like uplift in gains, magnetism, and recognition when the chart agrees: an exalted 11th lord with Venus in a Kendra from the Lagna lord electrifies the house of fulfilment and allies.");
    }

    @Override
    public boolean isYogaPresent(BirthChart birthChartData) {
        Planets lordOfEleventh = birthChartData.getLordOfHouse(Houses.ELEVENTH_HOUSE);
        Planets lagnaLord = birthChartData.getLordOfHouse(Houses.FIRST_HOUSE);
        if (lordOfEleventh == null || lagnaLord == null) {
            return false;
        }

        if (!isExalted(birthChartData, lordOfEleventh)) {
            return false;
        }

        Houses eleventhLordHouse = birthChartData.getPlanetHouses().get(lordOfEleventh);
        Houses venusHouse = birthChartData.getPlanetHouses().get(Planets.VENUS);
        if (eleventhLordHouse == null || venusHouse == null || !eleventhLordHouse.equals(venusHouse)) {
            return false;
        }

        Houses lagnaLordHouse = birthChartData.getPlanetHouses().get(lagnaLord);
        if (lagnaLordHouse == null) {
            return false;
        }

        return isKendraFromReference(birthChartData, lagnaLordHouse, eleventhLordHouse);
    }

    private static boolean isExalted(BirthChart birthChart, Planets planet) {
        Rashis rashi = birthChart.getPlanetWiseRashis().get(planet);
        Rashis exaltation = birthChart.getExaltationRashi(planet);
        return rashi != null && exaltation != null && rashi.equals(exaltation);
    }

    private static boolean isKendraFromReference(BirthChart birthChart, Houses reference, Houses target) {
        for (Houses kendra : BirthChart.KENDRA_HOUSES) {
            int offset = kendra.getHouseNumber();
            if (birthChart.getNthHouseFromGivenHouse(reference, offset).equals(target)) {
                return true;
            }
        }
        return false;
    }
}
