package yogas;

import birthChart.BirthChart;
import chartBlocks.Houses;
import chartBlocks.Planets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
Vasumathi Yoga is formed when benefic planets occupy the 3rd, 6th, 10th and 11th houses
either from the Lagna or from the house of the Moon.
 */
public class VasumathiYoga extends AbstractYoga {

    public VasumathiYoga() {
        setYogaName("Vasumathi Yoga");
        setYogaEffect("The native enjoys wealth, comfort and prosperity. Benefics in these houses bestow success in efforts, victory over obstacles, career growth, and gains. The person is often fortunate in matters of wealth and fulfilment of desires. The person will not be dependent but will always command plenty of wealth.");
    }

    @Override
    public boolean isYogaPresent(BirthChart birthChartData) {
        return beneficsOccupyHousesFromLagna(birthChartData) || beneficsOccupyHousesFromMoon(birthChartData);
    }

    private boolean beneficsOccupyHousesFromLagna(BirthChart birthChartData) {
        List<Houses> housesFromLagna = Arrays.asList(
                Houses.THIRD_HOUSE,
                Houses.SIXTH_HOUSE,
                Houses.TENTH_HOUSE,
                Houses.ELEVENTH_HOUSE
        );
        return allHousesContainBenefic(birthChartData, housesFromLagna);
    }

    private boolean beneficsOccupyHousesFromMoon(BirthChart birthChartData) {
        Houses houseOfMoon = birthChartData.getPlanetHouses().get(Planets.MOON);
        List<Houses> housesFromMoon = Arrays.asList(
                birthChartData.getNthHouseFromGivenHouse(houseOfMoon, 3),
                birthChartData.getNthHouseFromGivenHouse(houseOfMoon, 6),
                birthChartData.getNthHouseFromGivenHouse(houseOfMoon, 10),
                birthChartData.getNthHouseFromGivenHouse(houseOfMoon, 11)
        );
        return allHousesContainBenefic(birthChartData, housesFromMoon);
    }

    private boolean allHousesContainBenefic(BirthChart birthChartData, List<Houses> houses) {
        List<Planets> benefics = birthChartData.getNaturalBeneficPlanets();
        for (Houses house : houses) {
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
}
