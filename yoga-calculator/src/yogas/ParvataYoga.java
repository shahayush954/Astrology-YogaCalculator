package yogas;

import birthChart.BirthChart;
import chartBlocks.Houses;
import chartBlocks.Planets;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*
Parvata Yoga occurs when (1) the 1st, 4th, 7th and 10th houses from Lagna (Kendras) are occupied by
benefics and the 6th and 8th houses are either empty or occupied by benefics only; or (2) the lords
of the 1st and 12th houses are in mutual kendras (1st-7th or 4th-10th from each other).
 */
public class ParvataYoga extends AbstractYoga {

    public ParvataYoga() {
        setYogaName("Parvata Yoga");
        setYogaEffect("The native gains substantial wealth, stability and respect like a mountain. Benefics in Kendras with 6th and 8th free of malefics bestow prosperity, authority and a strong position in life. The person will become wealthy, prosperous, liberal, charitable, humorous and head of a town or village. He will be passionate also.");
    }

    @Override
    public boolean isYogaPresent(BirthChart birthChartData) {
        return (allKendrasContainBenefic(birthChartData)
                && sixthAndEighthEmptyOrOnlyBenefics(birthChartData))
                || lordsOfFirstAndTwelfthInMutualKendras(birthChartData);
    }

    private boolean lordsOfFirstAndTwelfthInMutualKendras(BirthChart birthChartData) {
        Planets lordOfFirst = birthChartData.getLordOfHouse(Houses.FIRST_HOUSE);
        Planets lordOfTwelfth = birthChartData.getLordOfHouse(Houses.TWELVTH_HOUSE);
        if (lordOfFirst == null || lordOfTwelfth == null) {
            return false;
        }
        Houses houseOfLord1 = birthChartData.getPlanetHouses().get(lordOfFirst);
        Houses houseOfLord2 = birthChartData.getPlanetHouses().get(lordOfTwelfth);
        if (houseOfLord1 == null || houseOfLord2 == null) {
            return false;
        }
        return areInMutualKendras(houseOfLord1, houseOfLord2, birthChartData);
    }

    /** Mutual kendras: 1st-7th (opposite houses) or 4th-10th from each other. */
    private boolean areInMutualKendras(Houses house1, Houses house2, BirthChart birthChartData) {
        boolean oneAndSeven = birthChartData.getNthHouseFromGivenHouse(house1, 7) == house2;
        boolean fourAndTen = birthChartData.getNthHouseFromGivenHouse(house1, 4) == house2
                && birthChartData.getNthHouseFromGivenHouse(house2, 10) == house1;
        boolean tenAndFour = birthChartData.getNthHouseFromGivenHouse(house1, 10) == house2
                && birthChartData.getNthHouseFromGivenHouse(house2, 4) == house1;
        return oneAndSeven || fourAndTen || tenAndFour;
    }

    private boolean allKendrasContainBenefic(BirthChart birthChartData) {
        List<Planets> benefics = birthChartData.getNaturalBeneficPlanets();
        for (Houses house : BirthChart.KENDRA_HOUSES) {
            List<Planets> planetsInHouse = birthChartData.getHouseWisePlanets().containsKey(house)
                    ? birthChartData.getHouseWisePlanets().get(house)
                    : new ArrayList<>();
            List<Planets> beneficsInHouse = planetsInHouse.stream()
                    .filter(benefics::contains)
                    .collect(Collectors.toList());
            if (beneficsInHouse.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    private boolean sixthAndEighthEmptyOrOnlyBenefics(BirthChart birthChartData) {
        return houseEmptyOrOnlyBenefics(birthChartData, Houses.SIXTH_HOUSE)
                && houseEmptyOrOnlyBenefics(birthChartData, Houses.EIGHT_HOUSE);
    }

    private boolean houseEmptyOrOnlyBenefics(BirthChart birthChartData, Houses house) {
        List<Planets> planetsInHouse = birthChartData.getHouseWisePlanets().containsKey(house)
                ? birthChartData.getHouseWisePlanets().get(house)
                : new ArrayList<>();
        List<Planets> malefics = birthChartData.getNaturalMaleficPlanets();
        boolean hasMalefic = planetsInHouse.stream().anyMatch(malefics::contains);
        return !hasMalefic;
    }
}
