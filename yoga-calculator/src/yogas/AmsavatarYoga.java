package yogas;

import birthChart.BirthChart;
import chartBlocks.Houses;
import chartBlocks.Planets;
import chartBlocks.Rashis;

/*
 * Amsaavtara (Amsavatar) Yoga: Venus and Jupiter occupy Kendras (1, 4, 7, 10); Lagna is in a movable
 * sign (Aries, Cancer, Libra, Capricorn); Saturn is exalted and placed in a Kendra.
 */
public class AmsavatarYoga extends AbstractYoga {

    public AmsavatarYoga() {
        setYogaName("Amsaavtara Yoga");
        setYogaEffect("A rare combination favouring dignity, sustained merit, and fortune when the rest of the chart agrees. Kendra support from Jupiter and Venus with a movable Lagna and exalted Saturn in an angle often lifts the native toward responsibility and lasting good name.");
    }

    @Override
    public boolean isYogaPresent(BirthChart birthChartData) {
        Rashis lagna = birthChartData.getLagna();
        if (lagna == null || !BirthChart.MOVABLE_RASHIS.contains(lagna)) {
            return false;
        }
        if (!planetInKendra(birthChartData, Planets.VENUS)
                || !planetInKendra(birthChartData, Planets.JUPITER)) {
            return false;
        }
        return saturnExaltedInKendra(birthChartData);
    }

    private static boolean planetInKendra(BirthChart birthChart, Planets planet) {
        Houses house = birthChart.getPlanetHouses().get(planet);
        return house != null && BirthChart.KENDRA_HOUSES.contains(house);
    }

    private static boolean saturnExaltedInKendra(BirthChart birthChart) {
        Houses saturnHouse = birthChart.getPlanetHouses().get(Planets.SATURN);
        if (saturnHouse == null || !BirthChart.KENDRA_HOUSES.contains(saturnHouse)) {
            return false;
        }
        Rashis saturnRashi = birthChart.getPlanetWiseRashis().get(Planets.SATURN);
        Rashis exaltation = birthChart.getExaltationRashi(Planets.SATURN);
        return saturnRashi != null && exaltation != null && saturnRashi.equals(exaltation);
    }
}
