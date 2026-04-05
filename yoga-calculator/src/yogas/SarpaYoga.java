package yogas;

import birthChart.BirthChart;
import chartBlocks.Houses;
import chartBlocks.Planets;

/*
 * Sarpa Yoga (negative): the Sun, Mars, and Saturn each occupy a Kendra from Lagna (1st, 4th, 7th,
 * or 10th whole-sign house). See {@link BirthChart#KENDRA_HOUSES}. Contrast {@link SrikYoga}
 * (Mercury, Venus, Jupiter in Kendras).
 */
public class SarpaYoga extends AbstractYoga {

    public SarpaYoga() {
        setYogaName("Sarpa Yoga");
        setYogaEffect("When the Sun, Mars, and Saturn all sit in angles from Lagna, pressure, conflict, and hard edges can dominate the pillars of self, home, partnership, and career unless the chart gives strong relief.");
    }

    @Override
    public boolean isYogaPresent(BirthChart birthChartData) {
        return planetInKendra(birthChartData, Planets.SUN)
                && planetInKendra(birthChartData, Planets.MARS)
                && planetInKendra(birthChartData, Planets.SATURN);
    }

    private static boolean planetInKendra(BirthChart birthChart, Planets planet) {
        Houses house = birthChart.getPlanetHouses().get(planet);
        return house != null && BirthChart.KENDRA_HOUSES.contains(house);
    }
}
