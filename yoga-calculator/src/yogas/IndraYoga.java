package yogas;

import birthChart.BirthChart;
import chartBlocks.Houses;
import chartBlocks.Planets;

/*
 * Indra Yoga: the lords of the 5th and 11th houses exchange places (5th lord in the 11th, 11th lord
 * in the 5th), and the Moon occupies the 5th house.
 */
public class IndraYoga extends AbstractYoga {

    public IndraYoga() {
        setYogaName("Indra Yoga");
        setYogaEffect("Parivartana between trikona and labha lords, with the Moon in the 5th, can magnify creativity, children, fulfilment, and gains when the chart supports it — a chart pattern likened to sovereignty and generous command.");
    }

    @Override
    public boolean isYogaPresent(BirthChart birthChartData) {
        Planets lordOfFifth = birthChartData.getLordOfHouse(Houses.FIFTH_HOUSE);
        Planets lordOfEleventh = birthChartData.getLordOfHouse(Houses.ELEVENTH_HOUSE);
        if (lordOfFifth == null || lordOfEleventh == null) {
            return false;
        }

        Houses fifthLordHouse = birthChartData.getPlanetHouses().get(lordOfFifth);
        Houses eleventhLordHouse = birthChartData.getPlanetHouses().get(lordOfEleventh);
        Houses moonHouse = birthChartData.getPlanetHouses().get(Planets.MOON);
        if (fifthLordHouse == null || eleventhLordHouse == null || moonHouse == null) {
            return false;
        }

        boolean interchange = Houses.ELEVENTH_HOUSE.equals(fifthLordHouse)
                && Houses.FIFTH_HOUSE.equals(eleventhLordHouse);
        return interchange && Houses.FIFTH_HOUSE.equals(moonHouse);
    }
}
