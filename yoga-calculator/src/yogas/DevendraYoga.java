package yogas;

import birthChart.BirthChart;
import chartBlocks.Houses;
import chartBlocks.Planets;
import chartBlocks.Rashis;

/*
 * Devendra Yoga: Lagna is in a fixed sign; the lords of the 1st and 11th houses exchange places
 * (each sits in the other’s house); and the lords of the 2nd and 10th exchange places.
 */
public class DevendraYoga extends AbstractYoga {

    public DevendraYoga() {
        setYogaName("Devendra Yoga");
        setYogaEffect("A rare parivartana pattern on a fixed Lagna linking angles of self, gains, wealth, and career. When well supported, it can elevate status, resources, and command, much like the lord-of-heavens symbolism of Indra (Devendra).");
    }

    @Override
    public boolean isYogaPresent(BirthChart birthChartData) {
        Rashis lagna = birthChartData.getLagna();
        if (lagna == null || !BirthChart.FIXED_RASHIS.contains(lagna)) {
            return false;
        }

        Planets lagnaLord = birthChartData.getLordOfHouse(Houses.FIRST_HOUSE);
        Planets lordOfEleventh = birthChartData.getLordOfHouse(Houses.ELEVENTH_HOUSE);
        Planets lordOfSecond = birthChartData.getLordOfHouse(Houses.SECOND_HOUSE);
        Planets lordOfTenth = birthChartData.getLordOfHouse(Houses.TENTH_HOUSE);

        if (lagnaLord == null || lordOfEleventh == null || lordOfSecond == null || lordOfTenth == null) {
            return false;
        }

        Houses lagnaLordHouse = birthChartData.getPlanetHouses().get(lagnaLord);
        Houses eleventhLordHouse = birthChartData.getPlanetHouses().get(lordOfEleventh);
        Houses secondLordHouse = birthChartData.getPlanetHouses().get(lordOfSecond);
        Houses tenthLordHouse = birthChartData.getPlanetHouses().get(lordOfTenth);

        if (lagnaLordHouse == null || eleventhLordHouse == null
                || secondLordHouse == null || tenthLordHouse == null) {
            return false;
        }

        boolean lagnaEleventhExchange = lagnaLordHouse.equals(Houses.ELEVENTH_HOUSE)
                && eleventhLordHouse.equals(Houses.FIRST_HOUSE);
        boolean secondTenthExchange = secondLordHouse.equals(Houses.TENTH_HOUSE)
                && tenthLordHouse.equals(Houses.SECOND_HOUSE);

        return lagnaEleventhExchange && secondTenthExchange;
    }
}
