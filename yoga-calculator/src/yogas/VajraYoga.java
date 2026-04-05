package yogas;

import birthChart.BirthChart;
import chartBlocks.Houses;
import chartBlocks.Planets;

import java.util.ArrayList;
import java.util.List;

/*
 * Vajra Yoga (Nabhasa): natural benefics occupy Lagna and the 7th house (each has at least one), while
 * natural malefics occupy the 4th and 10th (each has at least one). Natural lists: benefics Mercury,
 * Jupiter, Venus; malefics Sun, Mars, Saturn; Moon is neutral (see {@link BirthChart}).
 */
public class VajraYoga extends AbstractYoga {

    public VajraYoga() {
        setYogaName("Vajra Yoga");
        setYogaEffect("Kendra pattern likened to the thunderbolt: benefics on the self–partner axis and malefics on sukha–karma can give firmness, honour, and lasting impact when the chart supports it — courage, stability, and command tempered by duty.");
    }

    @Override
    public boolean isYogaPresent(BirthChart birthChartData) {
        return houseHasNaturalBenefic(birthChartData, Houses.FIRST_HOUSE)
                && houseHasNaturalBenefic(birthChartData, Houses.SEVENTH_HOUSE)
                && houseHasNaturalMalefic(birthChartData, Houses.FOURTH_HOUSE)
                && houseHasNaturalMalefic(birthChartData, Houses.TENTH_HOUSE);
    }

    private static boolean houseHasNaturalBenefic(BirthChart birthChart, Houses house) {
        List<Planets> inHouse = birthChart.getHouseWisePlanets().getOrDefault(house, new ArrayList<>());
        List<Planets> benefics = birthChart.getNaturalBeneficPlanets();
        return inHouse.stream().anyMatch(benefics::contains);
    }

    private static boolean houseHasNaturalMalefic(BirthChart birthChart, Houses house) {
        List<Planets> inHouse = birthChart.getHouseWisePlanets().getOrDefault(house, new ArrayList<>());
        List<Planets> malefics = birthChart.getNaturalMaleficPlanets();
        return inHouse.stream().anyMatch(malefics::contains);
    }
}
