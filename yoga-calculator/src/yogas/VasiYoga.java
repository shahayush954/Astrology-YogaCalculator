package yogas;

import birthChart.BirthChart;
import chartBlocks.Houses;
import chartBlocks.Planets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Vasi Yoga is formed when planets other than the Moon, Rahu and Ketu occupy the 12th house from the Sun.
 */
public class VasiYoga extends AbstractYoga {

    private static final List<Planets> EXCLUDED = Arrays.asList(Planets.MOON, Planets.RAHU, Planets.KETU);

    public VasiYoga() {
        setYogaName("Vasi Yoga");
        setYogaEffect("The native may experience gains through distant lands, spirituality or foreign connections. Planets in the 12th from the Sun can bestow intuition, expenditure that brings merit, and connection with subtle or hidden matters. The subject will be happy, prosperous, liberal and the favourite of the ruling classes.");
    }

    @Override
    public boolean isYogaPresent(BirthChart birthChartData) {
        Houses houseOfSun = birthChartData.getPlanetHouses().get(Planets.SUN);
        Houses twelfthFromSun = birthChartData.getNthHouseFromGivenHouse(houseOfSun, 12);

        List<Planets> planetsInTwelfthFromSun = birthChartData.getHouseWisePlanets().containsKey(twelfthFromSun)
                ? birthChartData.getHouseWisePlanets().get(twelfthFromSun)
                : new ArrayList<>();

        return planetsInTwelfthFromSun.stream()
                .filter(planet -> !EXCLUDED.contains(planet))
                .findAny()
                .isPresent();
    }
}
