package yogas;

import birthChart.BirthChart;
import birthChart.NavamsaBirthChart;
import chartBlocks.Houses;
import chartBlocks.Planets;
import chartBlocks.Rashis;

/*
 * Chandika Yoga: fixed-sign Lagna; the lord of the 6th (D1) aspects the Lagna (1st house); Navamsa
 * (D9) must be entered — the Sun in the Rashi chart associates with both the D9 lord of the 6th
 * and the D9 lord of the 9th (same house as the Sun for each of those grahas in D1).
 */
public class ChandikaYoga extends AbstractYoga {

    public ChandikaYoga() {
        setYogaName("Chandika Yoga");
        setYogaEffect("Said to invoke fierce protective and commanding qualities when the chart agrees: fixed Lagna, 6th-lord aspect on the self, and the Sun joined in D1 with the grahas that rule the 6th and 9th in Navamsa can intensify courage, honour, and spiritual fire.");
    }

    @Override
    public boolean isYogaPresent(BirthChart birthChartData) {
        NavamsaBirthChart d9 = birthChartData.getNavamsaBirthChart();
        if (d9 == null) {
            return false;
        }

        Rashis lagna = birthChartData.getLagna();
        if (lagna == null || !BirthChart.FIXED_RASHIS.contains(lagna)) {
            return false;
        }

        Planets lordOfSixth = birthChartData.getLordOfHouse(Houses.SIXTH_HOUSE);
        if (lordOfSixth == null || !birthChartData.planetAspectsHouse(lordOfSixth, Houses.FIRST_HOUSE)) {
            return false;
        }

        Planets navamsaLordOfSixth = d9.getLordOfHouse(Houses.SIXTH_HOUSE);
        Planets navamsaLordOfNinth = d9.getLordOfHouse(Houses.NINTH_HOUSE);
        if (navamsaLordOfSixth == null || navamsaLordOfNinth == null) {
            return false;
        }

        Houses sunHouse = birthChartData.getPlanetHouses().get(Planets.SUN);
        if (sunHouse == null) {
            return false;
        }

        Houses houseOfNavSixthLord = birthChartData.getPlanetHouses().get(navamsaLordOfSixth);
        Houses houseOfNavNinthLord = birthChartData.getPlanetHouses().get(navamsaLordOfNinth);
        if (houseOfNavSixthLord == null || houseOfNavNinthLord == null) {
            return false;
        }

        boolean sunWithNavSixthLord = sunHouse.equals(houseOfNavSixthLord);
        boolean sunWithNavNinthLord = sunHouse.equals(houseOfNavNinthLord);
        return sunWithNavSixthLord && sunWithNavNinthLord;
    }
}
