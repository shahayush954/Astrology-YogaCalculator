package yogas;

import birthChart.BirthChart;
import chartBlocks.Houses;
import chartBlocks.Planets;

/*
 * Daridra Yoga (negative): the lord of the 11th house from Lagna occupies the 6th, 8th, or 12th house
 * from Lagna (dusthanas). Same geometry as {@link DurYoga} but for the 11th lord. Uses
 * {@link BirthChart#DUSTHANA_OFFSETS} from {@link Houses#FIRST_HOUSE}.
 */
public class DaridraYoga extends AbstractYoga {

    public DaridraYoga() {
        setYogaName("Daridra Yoga");
        setYogaEffect("When the 11th-lord sits in a dusthana from Lagna, gains, friendships, and fulfilment of desires may be strained, delayed, or undermined; income stability often needs support from other chart factors.");
    }

    @Override
    public boolean isYogaPresent(BirthChart birthChartData) {
        Planets eleventhLord = birthChartData.getLordOfHouse(Houses.ELEVENTH_HOUSE);
        if (eleventhLord == null) {
            return false;
        }
        Houses lordHouse = birthChartData.getPlanetHouses().get(eleventhLord);
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
