package yogas;

import birthChart.BirthChart;
import chartBlocks.Houses;
import chartBlocks.Planets;

/*
 * Brahma Yoga (standalone rule): Jupiter occupies a Kendra from the 9th lord’s house; Venus occupies a
 * Kendra from the 11th lord’s house; Mercury occupies a Kendra from the Lagna lord’s house or from
 * the 10th lord’s house. Kendras are 1st, 4th, 7th, 10th counted from each reference house.
 *
 * This is separate from the “Brahma” limb inside {@link HariHaraBrahmaYoga}.
 */
public class BrahmaYoga extends AbstractYoga {

    public BrahmaYoga() {
        setYogaName("Brahma Yoga");
        setYogaEffect("Harmonises dharma and gains lords with Jupiter and Venus in angles from them, while Mercury picks up the Lagna or career lord from a Kendra — supporting clear judgment, learning, and dharmic conduct when the chart agrees.");
    }

    @Override
    public boolean isYogaPresent(BirthChart birthChartData) {
        Planets lordOfNinth = birthChartData.getLordOfHouse(Houses.NINTH_HOUSE);
        Planets lordOfEleventh = birthChartData.getLordOfHouse(Houses.ELEVENTH_HOUSE);
        Planets lagnaLord = birthChartData.getLordOfHouse(Houses.FIRST_HOUSE);
        Planets lordOfTenth = birthChartData.getLordOfHouse(Houses.TENTH_HOUSE);
        if (lordOfNinth == null || lordOfEleventh == null || lagnaLord == null || lordOfTenth == null) {
            return false;
        }

        Houses ninthLordHouse = birthChartData.getPlanetHouses().get(lordOfNinth);
        Houses eleventhLordHouse = birthChartData.getPlanetHouses().get(lordOfEleventh);
        Houses lagnaLordHouse = birthChartData.getPlanetHouses().get(lagnaLord);
        Houses tenthLordHouse = birthChartData.getPlanetHouses().get(lordOfTenth);
        Houses jupiterHouse = birthChartData.getPlanetHouses().get(Planets.JUPITER);
        Houses venusHouse = birthChartData.getPlanetHouses().get(Planets.VENUS);
        Houses mercuryHouse = birthChartData.getPlanetHouses().get(Planets.MERCURY);
        if (ninthLordHouse == null || eleventhLordHouse == null || lagnaLordHouse == null
                || tenthLordHouse == null || jupiterHouse == null || venusHouse == null
                || mercuryHouse == null) {
            return false;
        }

        if (!isKendraFromReference(birthChartData, ninthLordHouse, jupiterHouse)) {
            return false;
        }
        if (!isKendraFromReference(birthChartData, eleventhLordHouse, venusHouse)) {
            return false;
        }

        boolean mercuryFromLagnaLord = isKendraFromReference(birthChartData, lagnaLordHouse, mercuryHouse);
        boolean mercuryFromTenthLord = isKendraFromReference(birthChartData, tenthLordHouse, mercuryHouse);
        return mercuryFromLagnaLord || mercuryFromTenthLord;
    }

    private static boolean isKendraFromReference(BirthChart birthChart, Houses reference, Houses target) {
        for (Houses kendra : BirthChart.KENDRA_HOUSES) {
            int offset = kendra.getHouseNumber();
            if (birthChart.getNthHouseFromGivenHouse(reference, offset).equals(target)) {
                return true;
            }
        }
        return false;
    }
}
