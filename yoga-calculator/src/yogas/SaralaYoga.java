package yogas;

import birthChart.BirthChart;
import chartBlocks.Houses;
import chartBlocks.Planets;

/*
 * Sarala Yoga: the lord of the 8th house from Lagna occupies the 6th or the 12th house from Lagna.
 * Whole-sign houses via {@link BirthChart#getNthHouseFromGivenHouse(Houses, int)}.
 */
public class SaralaYoga extends AbstractYoga {

    public SaralaYoga() {
        setYogaName("Sarala Yoga");
        setYogaEffect("When the 8th-lord sits in the 6th or 12th from Lagna, setbacks and hidden factors can turn toward overcoming obstacles, enemies, or losses when the chart supports it.");
    }

    @Override
    public boolean isYogaPresent(BirthChart birthChartData) {
        Planets eighthLord = birthChartData.getLordOfHouse(Houses.EIGHT_HOUSE);
        if (eighthLord == null) {
            return false;
        }
        Houses lordHouse = birthChartData.getPlanetHouses().get(eighthLord);
        if (lordHouse == null) {
            return false;
        }
        Houses sixthFromLagna = birthChartData.getNthHouseFromGivenHouse(Houses.FIRST_HOUSE, 6);
        Houses twelfthFromLagna = birthChartData.getNthHouseFromGivenHouse(Houses.FIRST_HOUSE, 12);
        return lordHouse == sixthFromLagna || lordHouse == twelfthFromLagna;
    }
}
