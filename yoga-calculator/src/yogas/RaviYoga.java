package yogas;

import birthChart.BirthChart;
import chartBlocks.Houses;
import chartBlocks.Planets;

/*
 * Ravi Yoga: the Sun occupies the 10th house, and the lord of the 10th occupies the 3rd house
 * together with Saturn (same house / conjunction).
 */
public class RaviYoga extends AbstractYoga {

    public RaviYoga() {
        setYogaName("Ravi Yoga");
        setYogaEffect("The luminosity of the Sun on the angle of career, with the 10th lord and Saturn joined in the 3rd, can strengthen initiative, effort, and public standing through sustained work when the chart supports it.");
    }

    @Override
    public boolean isYogaPresent(BirthChart birthChartData) {
        if (!Houses.TENTH_HOUSE.equals(birthChartData.getPlanetHouses().get(Planets.SUN))) {
            return false;
        }

        Planets lordOfTenth = birthChartData.getLordOfHouse(Houses.TENTH_HOUSE);
        if (lordOfTenth == null) {
            return false;
        }

        Houses third = Houses.THIRD_HOUSE;
        Houses tenthLordHouse = birthChartData.getPlanetHouses().get(lordOfTenth);
        Houses saturnHouse = birthChartData.getPlanetHouses().get(Planets.SATURN);
        if (tenthLordHouse == null || saturnHouse == null) {
            return false;
        }

        return third.equals(tenthLordHouse) && third.equals(saturnHouse);
    }
}
