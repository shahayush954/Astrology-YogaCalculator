package yogas;

import birthChart.BirthChart;
import chartBlocks.Houses;
import chartBlocks.Planets;

import java.util.ArrayList;
import java.util.List;

/*
 * Makuta Yoga: Jupiter occupies the 9th house from the lord of the 9th; at least one natural
 * benefic occupies the 9th house from Jupiter; Saturn occupies the 10th house.
 */
public class MakutaYoga extends AbstractYoga {

    public MakutaYoga() {
        setYogaName("Makuta Yoga");
        setYogaEffect("Traditionally associated with crown-like dignity, fortune through dharma, and recognition when the chart supports it. The 9th-lord arc, Jupiter, a benefic on Jupiter’s 9th, and Saturn in the 10th can strengthen authority and lasting merit.");
    }

    @Override
    public boolean isYogaPresent(BirthChart birthChartData) {
        Planets lordOfNinth = birthChartData.getLordOfHouse(Houses.NINTH_HOUSE);
        if (lordOfNinth == null) {
            return false;
        }
        Houses ninthLordHouse = birthChartData.getPlanetHouses().get(lordOfNinth);
        if (ninthLordHouse == null) {
            return false;
        }
        Houses ninthFromNinthLord = birthChartData.getNthHouseFromGivenHouse(ninthLordHouse, 9);
        Houses jupiterHouse = birthChartData.getPlanetHouses().get(Planets.JUPITER);
        if (jupiterHouse == null || !ninthFromNinthLord.equals(jupiterHouse)) {
            return false;
        }

        Houses ninthFromJupiter = birthChartData.getNthHouseFromGivenHouse(jupiterHouse, 9);
        if (!houseHasNaturalBenefic(birthChartData, ninthFromJupiter)) {
            return false;
        }

        return Houses.TENTH_HOUSE.equals(birthChartData.getPlanetHouses().get(Planets.SATURN));
    }

    private static boolean houseHasNaturalBenefic(BirthChart birthChart, Houses house) {
        List<Planets> inHouse = birthChart.getHouseWisePlanets().getOrDefault(house, new ArrayList<>());
        List<Planets> benefics = birthChart.getNaturalBeneficPlanets();
        return inHouse.stream().anyMatch(benefics::contains);
    }
}
