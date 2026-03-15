package yogas;

import birthChart.BirthChart;
import chartBlocks.Houses;
import chartBlocks.Planets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Chatussagara Yoga is formed when the 1st, 4th, 7th and 10th houses (Kendras)
either from the Lagna or from the house of the Moon are occupied with planets.
 */
public class ChatussagaraYoga extends AbstractYoga {

    public ChatussagaraYoga() {
        setYogaName("Chatussagara Yoga");
        setYogaEffect("The native gains stability, success in career and authority, property and assets, and strong relationships.The four angular houses (Kendras) being occupied strengthens the chart and brings recognition and lasting achievements. The person will earn a good reputation, be an equal to a ruler, have a long and prosperous life, be blessed with good children and health and his name will travel to the confines of the four oceans.");
    }

    @Override
    public boolean isYogaPresent(BirthChart birthChartData) {
        return kendrasOccupiedFromLagna(birthChartData) || kendrasOccupiedFromMoon(birthChartData);
    }

    private boolean kendrasOccupiedFromLagna(BirthChart birthChartData) {
        List<Houses> kendrasFromLagna = Arrays.asList(
                Houses.FIRST_HOUSE,
                Houses.FOURTH_HOUSE,
                Houses.SEVENTH_HOUSE,
                Houses.TENTH_HOUSE
        );
        return allHousesOccupied(birthChartData, kendrasFromLagna);
    }

    private boolean kendrasOccupiedFromMoon(BirthChart birthChartData) {
        Houses houseOfMoon = birthChartData.getPlanetHouses().get(Planets.MOON);
        List<Houses> kendrasFromMoon = Arrays.asList(
                birthChartData.getNthHouseFromGivenHouse(houseOfMoon, 1),
                birthChartData.getNthHouseFromGivenHouse(houseOfMoon, 4),
                birthChartData.getNthHouseFromGivenHouse(houseOfMoon, 7),
                birthChartData.getNthHouseFromGivenHouse(houseOfMoon, 10)
        );
        return allHousesOccupied(birthChartData, kendrasFromMoon);
    }

    private boolean allHousesOccupied(BirthChart birthChartData, List<Houses> houses) {
        for (Houses house : houses) {
            List<Planets> planetsInHouse = birthChartData.getHouseWisePlanets().containsKey(house)
                    ? birthChartData.getHouseWisePlanets().get(house)
                    : new ArrayList<>();
            if (planetsInHouse.isEmpty()) {
                return false;
            }
        }
        return true;
    }
}
