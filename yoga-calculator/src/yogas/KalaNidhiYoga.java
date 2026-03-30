package yogas;

import birthChart.BirthChart;
import chartBlocks.Houses;
import chartBlocks.Planets;
import chartBlocks.Rashis;

/*
 * Kala Nidhi Yoga: Jupiter is in the 2nd or 5th house; Jupiter occupies the same sign (rashi) as
 * Mercury or Venus; and Mercury and Venus each either join Jupiter (same house) or aspect Jupiter’s
 * house from their placements.
 */
public class KalaNidhiYoga extends AbstractYoga {

    public KalaNidhiYoga() {
        setYogaName("Kala Nidhi Yoga");
        setYogaEffect("Traditionally associated with depth in learning, the arts, and honour through knowledge. Jupiter in a wealth or trine house, tied by sign to Mercury or Venus and supported by both through conjunction or aspect, strengthens refinement and creative or intellectual legacy.");
    }

    @Override
    public boolean isYogaPresent(BirthChart birthChartData) {
        Houses jupiterHouse = birthChartData.getPlanetHouses().get(Planets.JUPITER);
        if (jupiterHouse == null) {
            return false;
        }
        if (!isSecondOrFifth(jupiterHouse)) {
            return false;
        }

        Rashis jupiterRashi = birthChartData.getPlanetWiseRashis().get(Planets.JUPITER);
        Rashis mercuryRashi = birthChartData.getPlanetWiseRashis().get(Planets.MERCURY);
        Rashis venusRashi = birthChartData.getPlanetWiseRashis().get(Planets.VENUS);
        if (jupiterRashi == null || mercuryRashi == null || venusRashi == null) {
            return false;
        }

        boolean sameSignAsMercuryOrVenus = jupiterRashi.equals(mercuryRashi) || jupiterRashi.equals(venusRashi);
        if (!sameSignAsMercuryOrVenus) {
            return false;
        }

        return joinsOrAspectsJupiterHouse(birthChartData, Planets.MERCURY, jupiterHouse)
                && joinsOrAspectsJupiterHouse(birthChartData, Planets.VENUS, jupiterHouse);
    }

    private static boolean isSecondOrFifth(Houses house) {
        return house == Houses.SECOND_HOUSE || house == Houses.FIFTH_HOUSE;
    }

    private static boolean joinsOrAspectsJupiterHouse(BirthChart birthChart, Planets planet, Houses jupiterHouse) {
        Houses planetHouse = birthChart.getPlanetHouses().get(planet);
        if (planetHouse == null) {
            return false;
        }
        if (planetHouse.equals(jupiterHouse)) {
            return true;
        }
        return birthChart.planetAspectsHouse(planet, jupiterHouse);
    }
}
