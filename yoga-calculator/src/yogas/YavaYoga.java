package yogas;

import birthChart.BirthChart;
import chartBlocks.Houses;
import chartBlocks.Planets;

import java.util.ArrayList;
import java.util.List;

/*
 * Yava Yoga (Nabhasa): the reverse of {@link VajraYoga} — natural malefics occupy Lagna and the 7th
 * (each house at least one), while natural benefics occupy the 4th and 10th (each at least one).
 */
public class YavaYoga extends AbstractYoga {

    public YavaYoga() {
        setYogaName("Yava Yoga");
        setYogaEffect("Kendra pattern likened to barley grain: malefics on the self–partner axis and benefics on sukha–karma can yield nourishment through effort — substance, patience, and gradual prosperity when other factors agree.");
    }

    @Override
    public boolean isYogaPresent(BirthChart birthChartData) {
        return houseHasNaturalMalefic(birthChartData, Houses.FIRST_HOUSE)
                && houseHasNaturalMalefic(birthChartData, Houses.SEVENTH_HOUSE)
                && houseHasNaturalBenefic(birthChartData, Houses.FOURTH_HOUSE)
                && houseHasNaturalBenefic(birthChartData, Houses.TENTH_HOUSE);
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
}
