package yogas;

import birthChart.BirthChart;
import chartBlocks.Houses;
import chartBlocks.Planets;

import java.util.ArrayList;
import java.util.List;

/*
 * Matsya Yoga: the Lagna and 9th houses contain natural malefics; the 5th contains at least one
 * natural malefic and at least one natural benefic; the 4th and 8th contain natural malefics.
 */
public class MatsyaYoga extends AbstractYoga {

    public MatsyaYoga() {
        setYogaName("Matsya Yoga");
        setYogaEffect("A mixed pattern likened to the fish (Matsya): challenge and pressure on self and fortune houses, tension in sukha and randhra, yet the 5th mixing benefics and malefics can yield adaptability, learning through difficulty, and eventual uplift when the chart moderates the combination.");
    }

    @Override
    public boolean isYogaPresent(BirthChart birthChartData) {
        return houseHasNaturalMalefic(birthChartData, Houses.FIRST_HOUSE)
                && houseHasNaturalMalefic(birthChartData, Houses.NINTH_HOUSE)
                && houseHasNaturalMaleficAndBenefic(birthChartData, Houses.FIFTH_HOUSE)
                && houseHasNaturalMalefic(birthChartData, Houses.FOURTH_HOUSE)
                && houseHasNaturalMalefic(birthChartData, Houses.EIGHT_HOUSE);
    }

    private static boolean houseHasNaturalMalefic(BirthChart birthChart, Houses house) {
        List<Planets> inHouse = birthChart.getHouseWisePlanets().getOrDefault(house, new ArrayList<>());
        List<Planets> malefics = birthChart.getNaturalMaleficPlanets();
        return inHouse.stream().anyMatch(malefics::contains);
    }

    private static boolean houseHasNaturalBenefic(BirthChart birthChart, Houses house) {
        List<Planets> inHouse = birthChart.getHouseWisePlanets().getOrDefault(house, new ArrayList<>());
        List<Planets> benefics = birthChart.getNaturalBeneficPlanets();
        return inHouse.stream().anyMatch(benefics::contains);
    }

    private static boolean houseHasNaturalMaleficAndBenefic(BirthChart birthChart, Houses house) {
        return houseHasNaturalMalefic(birthChart, house) && houseHasNaturalBenefic(birthChart, house);
    }
}
