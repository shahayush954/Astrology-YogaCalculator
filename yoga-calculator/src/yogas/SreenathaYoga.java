package yogas;

import birthChart.BirthChart;
import chartBlocks.Houses;
import chartBlocks.Planets;
import chartBlocks.Rashis;

/*
Sreenatha Yoga occurs when:
1. The lord of the 7th house is exalted and placed in the 10th house.
2. The lord of the 10th house is in the same house as the lord of the 9th house (conjunction).
 */
public class SreenathaYoga extends AbstractYoga {

    public SreenathaYoga() {
        setYogaName("Sreenatha Yoga");
        setYogaEffect("The native gains prosperity, good spouse and career success. The combination of 7th lord exalted in 10th and 10th lord with 9th lord bestows wealth, partnership benefits and recognition in profession.");
    }

    @Override
    public boolean isYogaPresent(BirthChart birthChartData) {
        return lordOfSeventhExaltedInTenth(birthChartData)
                && lordOfTenthWithLordOfNinth(birthChartData);
    }

    private boolean lordOfSeventhExaltedInTenth(BirthChart birthChartData) {
        Planets lordOfSeventh = birthChartData.getLordOfHouse(Houses.SEVENTH_HOUSE);
        if (lordOfSeventh == null) return false;
        Houses houseOfLord = birthChartData.getPlanetHouses().get(lordOfSeventh);
        if (houseOfLord != Houses.TENTH_HOUSE) return false;
        Rashis lordRashi = birthChartData.getPlanetWiseRashis().get(lordOfSeventh);
        Rashis exaltationRashi = birthChartData.getExaltationRashi(lordOfSeventh);
        return lordRashi != null && exaltationRashi != null && lordRashi == exaltationRashi;
    }

    private boolean lordOfTenthWithLordOfNinth(BirthChart birthChartData) {
        Planets lordOfTenth = birthChartData.getLordOfHouse(Houses.TENTH_HOUSE);
        Planets lordOfNinth = birthChartData.getLordOfHouse(Houses.NINTH_HOUSE);
        if (lordOfTenth == null || lordOfNinth == null) return false;
        Houses houseOfTenthLord = birthChartData.getPlanetHouses().get(lordOfTenth);
        Houses houseOfNinthLord = birthChartData.getPlanetHouses().get(lordOfNinth);
        return houseOfTenthLord != null && houseOfNinthLord != null && houseOfTenthLord == houseOfNinthLord;
    }
}
