package yogas;

import birthChart.BirthChart;
import chartBlocks.Houses;
import chartBlocks.Planets;

/*
 * Siva Yoga: the lord of the 5th occupies the 9th house, the lord of the 9th occupies the 11th, and
 * the lord of the 11th occupies the 5th (circular link among trikona and labha lords).
 */
public class SivaYoga extends AbstractYoga {

    public SivaYoga() {
        setYogaName("Siva Yoga");
        setYogaEffect("A closed circuit among the 5th, 9th, and 11th lords favouring dharma, progeny and creativity, fortune, and gains working together. When the chart supports it, the native may gain lasting merit, teaching, and fulfilment through purposeful networks.");
    }

    @Override
    public boolean isYogaPresent(BirthChart birthChartData) {
        Planets lordOfFifth = birthChartData.getLordOfHouse(Houses.FIFTH_HOUSE);
        Planets lordOfNinth = birthChartData.getLordOfHouse(Houses.NINTH_HOUSE);
        Planets lordOfEleventh = birthChartData.getLordOfHouse(Houses.ELEVENTH_HOUSE);
        if (lordOfFifth == null || lordOfNinth == null || lordOfEleventh == null) {
            return false;
        }

        Houses fifthLordHouse = birthChartData.getPlanetHouses().get(lordOfFifth);
        Houses ninthLordHouse = birthChartData.getPlanetHouses().get(lordOfNinth);
        Houses eleventhLordHouse = birthChartData.getPlanetHouses().get(lordOfEleventh);
        if (fifthLordHouse == null || ninthLordHouse == null || eleventhLordHouse == null) {
            return false;
        }

        return Houses.NINTH_HOUSE.equals(fifthLordHouse)
                && Houses.ELEVENTH_HOUSE.equals(ninthLordHouse)
                && Houses.FIFTH_HOUSE.equals(eleventhLordHouse);
    }
}
