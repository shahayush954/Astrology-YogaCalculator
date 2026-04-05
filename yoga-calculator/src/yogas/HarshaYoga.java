package yogas;

import birthChart.BirthChart;
import chartBlocks.Houses;
import chartBlocks.Planets;

/*
 * Harsha Yoga: the lord of the 6th house from Lagna occupies the 8th or the 12th house from Lagna
 * (not the 6th). Whole-sign houses via {@link BirthChart#getNthHouseFromGivenHouse(Houses, int)}.
 */
public class HarshaYoga extends AbstractYoga {

    public HarshaYoga() {
        setYogaName("Harsha Yoga");
        setYogaEffect("When the 6th-lord sits in the 8th or 12th from Lagna, obstacles and hidden factors can turn toward resilience, recovery, or gain through adversity when the chart supports it.");
    }

    @Override
    public boolean isYogaPresent(BirthChart birthChartData) {
        Planets sixthLord = birthChartData.getLordOfHouse(Houses.SIXTH_HOUSE);
        if (sixthLord == null) {
            return false;
        }
        Houses lordHouse = birthChartData.getPlanetHouses().get(sixthLord);
        if (lordHouse == null) {
            return false;
        }
        Houses eighthFromLagna = birthChartData.getNthHouseFromGivenHouse(Houses.FIRST_HOUSE, 8);
        Houses twelfthFromLagna = birthChartData.getNthHouseFromGivenHouse(Houses.FIRST_HOUSE, 12);
        return lordHouse == eighthFromLagna || lordHouse == twelfthFromLagna;
    }
}
