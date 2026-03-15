package yogas;

import birthChart.BirthChart;
import chartBlocks.Houses;
import chartBlocks.Planets;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*
Amala Yoga occurs when the 10th house from Lagna or the 10th house from the Moon
is occupied by a benefic planet.
 */
public class AmalaYoga extends AbstractYoga {

    public AmalaYoga() {
        setYogaName("Amala Yoga");
        setYogaEffect("The native gains good reputation, clean character and success in career. Benefic in the 10th bestows recognition, authority and a spotless name in society. The person will achieve lasting fame and reputation. His character will be spotless and he will lead a prosperous life.");
    }

    @Override
    public boolean isYogaPresent(BirthChart birthChartData) {
        return houseContainsBenefic(birthChartData, Houses.TENTH_HOUSE)
                || houseContainsBenefic(birthChartData, birthChartData.getNthHouseFromGivenHouse(
                        birthChartData.getPlanetHouses().get(Planets.MOON), 10));
    }

    private boolean houseContainsBenefic(BirthChart birthChartData, Houses house) {
        List<Planets> planetsInHouse = birthChartData.getHouseWisePlanets().containsKey(house)
                ? birthChartData.getHouseWisePlanets().get(house)
                : new ArrayList<>();
        List<Planets> beneficsInHouse = planetsInHouse.stream()
                .filter(planet -> birthChartData.getNaturalBeneficPlanets().contains(planet))
                .collect(Collectors.toList());
        return !beneficsInHouse.isEmpty();
    }
}
