package yogas;

import birthChart.BirthChart;
import chartBlocks.Houses;
import chartBlocks.Planets;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*
When there are no planets on both sides of the Moon, Kemadruma Yoga is formed.
when no planets (excluding Sun, Rahu, and Ketu) occupy the 2nd and 12th houses from the Moon
 */
public class KemaDrumaYoga extends AbstractYoga{

    public KemaDrumaYoga() {
        setYogaName("Kemadruma Yoga");
        setYogaEffect("The person will be dirty, sorrowful, doing unrighteous deeds, poor, dependent, a rogue and a swindler");
    }
    @Override
    public boolean isYogaPresent(BirthChart birthChartData) {
        Houses houseOfMoon = birthChartData.getPlanetHouses().get(Planets.MOON);
        Houses firstFromMoon = birthChartData.getNthHouseFromGivenHouse(houseOfMoon,1);
        Houses twelvthFromMoon = birthChartData.getNthHouseFromGivenHouse(houseOfMoon, 12);

        List<Planets> planetsInFirstFromMoon = birthChartData.getHouseWisePlanets().containsKey(firstFromMoon)
                ? birthChartData.getHouseWisePlanets().get(firstFromMoon)
                : new ArrayList<>();

        List<Planets> planetsInTwelvthFromMoon = birthChartData.getHouseWisePlanets().containsKey(twelvthFromMoon)
                ? birthChartData.getHouseWisePlanets().get(twelvthFromMoon)
                : new ArrayList<>();

        planetsInFirstFromMoon = planetsInFirstFromMoon.stream()
                .filter(planets -> planets != Planets.SUN && planets != Planets.RAHU && planets != Planets.KETU)
                .collect(Collectors.toList());

        planetsInTwelvthFromMoon = planetsInTwelvthFromMoon.stream()
                .filter(planets -> planets != Planets.SUN && planets != Planets.RAHU && planets != Planets.KETU)
                .collect(Collectors.toList());

        return planetsInFirstFromMoon.isEmpty() && planetsInTwelvthFromMoon.isEmpty();
    }
}
