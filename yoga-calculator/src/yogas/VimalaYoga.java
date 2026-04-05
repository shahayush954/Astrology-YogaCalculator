package yogas;

import birthChart.BirthChart;
import chartBlocks.Houses;
import chartBlocks.Planets;

/*
 * Vimala Yoga: the lord of the 12th house from Lagna occupies the 6th or the 8th house from Lagna.
 * Whole-sign houses via {@link BirthChart#getNthHouseFromGivenHouse(Houses, int)}.
 */
public class VimalaYoga extends AbstractYoga {

    public VimalaYoga() {
        setYogaName("Vimala Yoga");
        setYogaEffect("When the 12th-lord sits in the 6th or 8th from Lagna, loss and isolation themes can turn toward service, overcoming enemies, or resilience through hidden change when the chart supports it.");
    }

    @Override
    public boolean isYogaPresent(BirthChart birthChartData) {
        Planets twelfthLord = birthChartData.getLordOfHouse(Houses.TWELVTH_HOUSE);
        if (twelfthLord == null) {
            return false;
        }
        Houses lordHouse = birthChartData.getPlanetHouses().get(twelfthLord);
        if (lordHouse == null) {
            return false;
        }
        Houses sixthFromLagna = birthChartData.getNthHouseFromGivenHouse(Houses.FIRST_HOUSE, 6);
        Houses eighthFromLagna = birthChartData.getNthHouseFromGivenHouse(Houses.FIRST_HOUSE, 8);
        return lordHouse == sixthFromLagna || lordHouse == eighthFromLagna;
    }
}
