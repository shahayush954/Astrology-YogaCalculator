package yogas;

import birthChart.BirthChart;
import chartBlocks.Houses;
import chartBlocks.Planets;

/*
 * Dur Yoga (negative): the lord of the 10th house from Lagna occupies the 6th, 8th, or 12th house
 * from Lagna (dusthanas). Uses {@link BirthChart#DUSTHANA_OFFSETS} from {@link Houses#FIRST_HOUSE}.
 * See {@link DaridraYoga} for the 11th-lord in dusthana.
 */
public class DurYoga extends AbstractYoga {

    public DurYoga() {
        setYogaName("Dur Yoga");
        setYogaEffect("When the 10th-lord sits in a dusthana from Lagna, career, reputation, and public life may face friction, reversals, or hidden obstacles; results depend heavily on the strength of the 10th house and its lord elsewhere in the chart.");
    }

    @Override
    public boolean isYogaPresent(BirthChart birthChartData) {
        Planets tenthLord = birthChartData.getLordOfHouse(Houses.TENTH_HOUSE);
        if (tenthLord == null) {
            return false;
        }
        Houses lordHouse = birthChartData.getPlanetHouses().get(tenthLord);
        if (lordHouse == null) {
            return false;
        }
        for (int offset : BirthChart.DUSTHANA_OFFSETS) {
            Houses dusthana = birthChartData.getNthHouseFromGivenHouse(Houses.FIRST_HOUSE, offset);
            if (lordHouse == dusthana) {
                return true;
            }
        }
        return false;
    }
}
