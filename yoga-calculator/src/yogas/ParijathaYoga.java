package yogas;

import birthChart.BirthChart;
import birthChart.NavamsaBirthChart;
import chartBlocks.Houses;
import chartBlocks.Planets;
import chartBlocks.Rashis;

import java.util.List;
import java.util.Map;

/*
 * Parijatha (Parijata) Yoga — requires Navamsa (D9) to be entered.
 *
 * Main: The dispositor of the Ascendant Lord (lord of the sign the Lagna lord occupies) is in own
 * sign or exalted, and occupies a Kendra (1, 4, 7, 10) or Trikona (5, 9) from Lagna.
 *
 * Alternative: The same dispositor, or the lord of the Navamsa sign occupied by the Ascendant
 * Lord, is in a Kendra, Trikona, own sign, or exaltation (all judged from the Rashi chart).
 */
public class ParijathaYoga extends AbstractYoga {

    public ParijathaYoga() {
        setYogaName("Parijatha Yoga");
        setYogaEffect("Brings happiness, comfort, honour, and stability of fortune when supported by the overall chart. The Lagna lord’s dispositor and Navamsa ties to Kendra/Trikona or dignities lift the native’s life experience toward fulfilment and respect.");
    }

    @Override
    public boolean isYogaPresent(BirthChart birthChartData) {
        NavamsaBirthChart d9 = birthChartData.getNavamsaBirthChart();
        if (d9 == null) {
            return false;
        }

        Planets lagnaLord = birthChartData.getLordOfHouse(Houses.FIRST_HOUSE);
        if (lagnaLord == null) {
            return false;
        }
        Houses houseOfLagnaLord = birthChartData.getPlanetHouses().get(lagnaLord);
        if (houseOfLagnaLord == null) {
            return false;
        }

        Planets dispositor = birthChartData.getLordOfHouse(houseOfLagnaLord);
        if (dispositor == null) {
            return false;
        }

        if (mainCondition(birthChartData, dispositor)) {
            return true;
        }

        Rashis navamsaRashiOfLagnaLord = d9.getPlanetWiseRashis().get(lagnaLord);
        Planets lordOfNavamsaSign = lordOfRashi(birthChartData.getRashiLords(), navamsaRashiOfLagnaLord);

        return alternativeSatisfied(birthChartData, dispositor)
                || alternativeSatisfied(birthChartData, lordOfNavamsaSign);
    }

    /** Dispositor in own or exalted sign, and in Kendra or Trikona from Lagna. */
    private boolean mainCondition(BirthChart birthChart, Planets dispositor) {
        Houses house = birthChart.getPlanetHouses().get(dispositor);
        if (house == null || !isKendraOrTrikonaFromLagna(house)) {
            return false;
        }
        return isInOwnSign(birthChart, dispositor) || isExaltedInRashiChart(birthChart, dispositor);
    }

    /** In Kendra/Trikona from Lagna, or in own sign, or exalted (Rashi chart). */
    private boolean alternativeSatisfied(BirthChart birthChart, Planets planet) {
        if (planet == null) {
            return false;
        }
        Houses house = birthChart.getPlanetHouses().get(planet);
        if (house == null) {
            return false;
        }
        if (isKendraOrTrikonaFromLagna(house)) {
            return true;
        }
        return isInOwnSign(birthChart, planet) || isExaltedInRashiChart(birthChart, planet);
    }

    private static boolean isKendraOrTrikonaFromLagna(Houses house) {
        int n = house.getHouseNumber();
        return n == 1 || n == 4 || n == 5 || n == 7 || n == 9 || n == 10;
    }

    private static boolean isInOwnSign(BirthChart birthChart, Planets planet) {
        Rashis r = birthChart.getPlanetWiseRashis().get(planet);
        if (r == null) {
            return false;
        }
        List<Rashis> owned = birthChart.getRashiLords().get(planet);
        return owned != null && owned.contains(r);
    }

    private static boolean isExaltedInRashiChart(BirthChart birthChart, Planets planet) {
        Rashis r = birthChart.getPlanetWiseRashis().get(planet);
        Rashis ex = birthChart.getExaltationRashi(planet);
        return r != null && ex != null && r.equals(ex);
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
