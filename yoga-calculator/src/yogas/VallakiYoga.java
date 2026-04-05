package yogas;

import birthChart.BirthChart;
import chartBlocks.Planets;
import chartBlocks.Rashis;

import java.util.HashSet;
import java.util.Set;

/*
 * Vallaki Yoga (Nabhasa): the seven classical grahas (Sun through Saturn) each occupy a different
 * whole-sign rashi — seven distinct signs among them (“seven independent rashis”). Rahu and Ketu are
 * ignored and may share signs with each other or with the seven. See also {@link DamniYoga} (six
 * distinct signs), {@link PasaYoga} (five), and {@link KedaraYoga} (four).
 */
public class VallakiYoga extends AbstractYoga {

    public VallakiYoga() {
        setYogaName("Vallaki Yoga");
        setYogaEffect("When every traditional graha sits in a different sign among the twelve, like strings of the veena, the chart spreads influence across the zodiac — variety of experience, many-sided talent, and breadth of connection when other factors agree.");
    }

    @Override
    public boolean isYogaPresent(BirthChart birthChartData) {
        Set<Rashis> distinctSigns = new HashSet<>();
        for (Planets planet : Planets.SEVEN_GRAHAS) {
            Rashis rashi = birthChartData.getPlanetWiseRashis().get(planet);
            if (rashi == null) {
                return false;
            }
            distinctSigns.add(rashi);
        }
        return distinctSigns.size() == 7;
    }
}
