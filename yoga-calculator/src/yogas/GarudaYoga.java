package yogas;

import birthChart.BirthChart;
import birthChart.NavamsaBirthChart;
import chartBlocks.BirthPeriod;
import chartBlocks.Planets;
import chartBlocks.Rashis;

import java.util.List;
import java.util.Map;

/*
 * Garuda Yoga: Navamsa (D9) must be entered. The lord of the Navamsa sign occupied by the Moon must
 * be exalted in the Rashi chart, and birth must be in the daytime (here: {@link BirthPeriod#MORNING},
 * sunrise to sunset).
 */
public class GarudaYoga extends AbstractYoga {

    public GarudaYoga() {
        setYogaName("Garuda Yoga");
        setYogaEffect("Elevates the mind and intuitive strength when the chart agrees: an exalted lord of the Moon’s Navamsa sign, born by day, suggests sharp discernment, protection, and upward spiritual or intellectual flight.");
    }

    @Override
    public boolean isYogaPresent(BirthChart birthChartData) {
        NavamsaBirthChart d9 = birthChartData.getNavamsaBirthChart();
        if (d9 == null) {
            return false;
        }

        BirthPeriod period = birthChartData.getBirthPeriod();
        if (period == null || !BirthPeriod.MORNING.equals(period)) {
            return false;
        }

        Rashis moonNavamsaSign = d9.getPlanetWiseRashis().get(Planets.MOON);
        Planets lordOfMoonNavamsa = lordOfRashi(d9.getRashiLords(), moonNavamsaSign);
        if (lordOfMoonNavamsa == null) {
            return false;
        }

        Rashis rashiInD1 = birthChartData.getPlanetWiseRashis().get(lordOfMoonNavamsa);
        Rashis exaltation = birthChartData.getExaltationRashi(lordOfMoonNavamsa);
        return rashiInD1 != null && exaltation != null && rashiInD1.equals(exaltation);
    }

    private static Planets lordOfRashi(Map<Planets, List<Rashis>> rashiLords, Rashis rashi) {
        if (rashi == null) {
            return null;
        }
        return rashiLords.entrySet().stream()
                .filter(e -> e.getValue() != null && e.getValue().contains(rashi))
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);
    }
}
