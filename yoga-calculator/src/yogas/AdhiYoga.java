package yogas;

import birthChart.BirthChart;
import chartBlocks.Houses;
import chartBlocks.Planets;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*
lf benefics are situated in the 6th' 7th and 8th from the Moon or from Lagna, the combination goes under the name of Adhi Yoga
 */
public class AdhiYoga extends AbstractYoga{
    public AdhiYoga() {
        setYogaName("Adhi Yoga");
        setYogaEffect("The person will be polite and trustworthy, will have an enjoyable and happy life, surrounded [r luxuries and affluence, will inflict defeats on his enemies, will be healthy and will live long.");
    }
    @Override
    public boolean isYogaPresent(BirthChart birthChartData) {
        Houses houseOfMoon = birthChartData.getPlanetHouses().get(Planets.MOON);
        Houses sixthFromLagna = Houses.SIXTH_HOUSE;
        Houses sixthFromMoon = birthChartData.getNthHouseFromGivenHouse(houseOfMoon, 6);
        Houses seventhFromLagna = Houses.SEVENTH_HOUSE;
        Houses seventhFromMoon = birthChartData.getNthHouseFromGivenHouse(houseOfMoon, 7);
        Houses eightFromLagna = Houses.EIGHT_HOUSE;
        Houses eightFromMoon = birthChartData.getNthHouseFromGivenHouse(houseOfMoon, 8);

        List<Planets> planetsInSixthFromLagna = birthChartData.getHouseWisePlanets().containsKey(sixthFromLagna)
                ? birthChartData.getHouseWisePlanets().get(sixthFromLagna)
                : new ArrayList<>();

        List<Planets> planetsInSixthFromMoon = birthChartData.getHouseWisePlanets().containsKey(sixthFromMoon)
                ? birthChartData.getHouseWisePlanets().get(sixthFromMoon)
                : new ArrayList<>();

        List<Planets> planetsInSeventhFromLagna = birthChartData.getHouseWisePlanets().containsKey(seventhFromLagna)
                ? birthChartData.getHouseWisePlanets().get(seventhFromLagna)
                : new ArrayList<>();

        List<Planets> planetsInSeventhFromMoon = birthChartData.getHouseWisePlanets().containsKey(seventhFromMoon)
                ? birthChartData.getHouseWisePlanets().get(seventhFromMoon)
                : new ArrayList<>();

        List<Planets> planetsInEightFromLagna = birthChartData.getHouseWisePlanets().containsKey(eightFromLagna)
                ? birthChartData.getHouseWisePlanets().get(eightFromLagna)
                : new ArrayList<>();

        List<Planets> planetsInEightFromMoon = birthChartData.getHouseWisePlanets().containsKey(eightFromMoon)
                ? birthChartData.getHouseWisePlanets().get(eightFromMoon)
                : new ArrayList<>();

        List<Planets> filteredPlanetsInSixthFromMoon = planetsInSixthFromMoon.stream()
                .filter(planets -> birthChartData.getNaturalBeneficPlanets().contains(planets))
                .collect(Collectors.toList());

        List<Planets> filteredPlanetsInSeventhFromMoon = planetsInSeventhFromMoon.stream()
                .filter(planets -> birthChartData.getNaturalBeneficPlanets().contains(planets))
                .collect(Collectors.toList());

        List<Planets> filteredPlanetsInEightFromMoon = planetsInEightFromMoon.stream()
                .filter(planets -> birthChartData.getNaturalBeneficPlanets().contains(planets))
                .collect(Collectors.toList());

        if (!filteredPlanetsInSixthFromMoon.isEmpty() && !filteredPlanetsInSeventhFromMoon.isEmpty() && !filteredPlanetsInEightFromMoon.isEmpty()) {
            return true;
        }

        List<Planets> filteredPlanetsInSixthFromLagna = planetsInSixthFromLagna.stream()
                .filter(planets -> birthChartData.getNaturalBeneficPlanets().contains(planets))
                .collect(Collectors.toList());

        List<Planets> filteredPlanetsInSeventhFromLagna = planetsInSeventhFromLagna.stream()
                .filter(planets -> birthChartData.getNaturalBeneficPlanets().contains(planets))
                .collect(Collectors.toList());

        List<Planets> filteredPlanetsInEightFromLagna = planetsInEightFromLagna.stream()
                .filter(planets -> birthChartData.getNaturalBeneficPlanets().contains(planets))
                .collect(Collectors.toList());

        return !filteredPlanetsInSixthFromLagna.isEmpty()
                && !filteredPlanetsInSeventhFromLagna.isEmpty()
                && !filteredPlanetsInEightFromLagna.isEmpty();
    }
}
