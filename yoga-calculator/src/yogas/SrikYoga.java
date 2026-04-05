package yogas;

import birthChart.BirthChart;
import chartBlocks.Houses;
import chartBlocks.Planets;

/*
 * Srik Yoga: Mercury, Venus, and Jupiter each occupy a Kendra from Lagna (1st, 4th, 7th, or 10th
 * whole-sign house). See {@link BirthChart#KENDRA_HOUSES}. Contrast {@link SarpaYoga} (Sun, Mars,
 * Saturn in Kendras).
 */
public class SrikYoga extends AbstractYoga {

    public SrikYoga() {
        setYogaName("Srik Yoga");
        setYogaEffect("When the three natural benefics (Mercury, Jupiter, Venus) all sit in angles from Lagna, learning, harmony, and graceful strength can gather in visible sectors of life when the chart supports them.");
    }

    @Override
    public boolean isYogaPresent(BirthChart birthChartData) {
        return planetInKendra(birthChartData, Planets.MERCURY)
                && planetInKendra(birthChartData, Planets.VENUS)
                && planetInKendra(birthChartData, Planets.JUPITER);
    }

    private static boolean planetInKendra(BirthChart birthChart, Planets planet) {
        Houses house = birthChart.getPlanetHouses().get(planet);
        return house != null && BirthChart.KENDRA_HOUSES.contains(house);
    }
}
