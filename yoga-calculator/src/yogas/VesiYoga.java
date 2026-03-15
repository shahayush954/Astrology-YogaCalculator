package yogas;

import birthChart.BirthChart;
import chartBlocks.Houses;
import chartBlocks.Planets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Vesi Yoga is formed when planets other than the Moon, Rahu and Ketu occupy the 2nd house from the Sun.
 */
public class VesiYoga extends AbstractYoga {

    public VesiYoga() {
        setYogaName("Vesi Yoga");
        setYogaEffect("The native gains wealth, comforts and support from others. Planets in the 2nd from the Sun strengthen finances and family and bestow a comfortable life. The person will be fortunate, happy, virtuous, famous and aristocratic.");
    }

    @Override
    public boolean isYogaPresent(BirthChart birthChartData) {
        Houses houseOfSun = birthChartData.getPlanetHouses().get(Planets.SUN);
        Houses secondFromSun = birthChartData.getNthHouseFromGivenHouse(houseOfSun, 2);

        List<Planets> planetsInSecondFromSun = birthChartData.getHouseWisePlanets().containsKey(secondFromSun)
                ? birthChartData.getHouseWisePlanets().get(secondFromSun)
                : new ArrayList<>();

        List<Planets> excluded = Arrays.asList(Planets.MOON, Planets.RAHU, Planets.KETU);
        return planetsInSecondFromSun.stream()
                .filter(planet -> !excluded.contains(planet))
                .findAny()
                .isPresent();
    }
}
