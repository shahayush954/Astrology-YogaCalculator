package yogas;

import birthChart.BirthChart;
import chartBlocks.Houses;
import chartBlocks.Planets;

/*
 * Sareera Soukhya Yoga: at least one of the Lagna lord, Jupiter, or Venus occupies a kendra (quadrant)
 * from Lagna — the 1st, 4th, 7th, or 10th whole-sign house.
 */
public class SareeraSoukhyaYoga extends AbstractYoga {

    public SareeraSoukhyaYoga() {
        setYogaName("Sareera Soukhya Yoga");
        setYogaEffect("When the Lagna lord, Jupiter, or Venus sits in an angle from Lagna, the chart can favour bodily comfort, vitality, and pleasant physical experience when other factors support it.");
    }

    @Override
    public boolean isYogaPresent(BirthChart birthChartData) {
        Planets lagnaLord = birthChartData.getLordOfHouse(Houses.FIRST_HOUSE);
        if (lagnaLord != null && isKendraFromLagna(birthChartData.getPlanetHouses().get(lagnaLord))) {
            return true;
        }
        if (isKendraFromLagna(birthChartData.getPlanetHouses().get(Planets.JUPITER))) {
            return true;
        }
        return isKendraFromLagna(birthChartData.getPlanetHouses().get(Planets.VENUS));
    }

    private static boolean isKendraFromLagna(Houses house) {
        return house != null && BirthChart.KENDRA_HOUSES.contains(house);
    }
}
