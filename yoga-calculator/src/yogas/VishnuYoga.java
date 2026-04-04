package yogas;

import birthChart.BirthChart;
import birthChart.NavamsaBirthChart;
import chartBlocks.Houses;
import chartBlocks.Planets;
import chartBlocks.Rashis;

import java.util.List;
import java.util.Map;

/*
 * Vishnu Yoga (requires Navamsa): the lord of the Navamsa sign occupied by the 9th lord (D9), the
 * 9th lord, and the 10th lord all occupy the 2nd house together in the Rashi chart — i.e. the 10th
 * lord joins the 2nd in conjunction with the 9th lord, and the dispositor of the 9th lord’s
 * Navamsa sign is in that same house.
 */
public class VishnuYoga extends AbstractYoga {

    public VishnuYoga() {
        setYogaName("Vishnu Yoga");
        setYogaEffect("Links dharma (9th), career (10th), and speech/wealth (2nd) with the Navamsa depth of the 9th lord. When the chart supports it, the combination can sustain honour, preservation, and right livelihood through merit and resources.");
    }

    @Override
    public boolean isYogaPresent(BirthChart birthChartData) {
        NavamsaBirthChart d9 = birthChartData.getNavamsaBirthChart();
        if (d9 == null) {
            return false;
        }

        Planets lordOfNinth = birthChartData.getLordOfHouse(Houses.NINTH_HOUSE);
        Planets lordOfTenth = birthChartData.getLordOfHouse(Houses.TENTH_HOUSE);
        if (lordOfNinth == null || lordOfTenth == null) {
            return false;
        }

        Rashis navamsaSignOfNinthLord = d9.getPlanetWiseRashis().get(lordOfNinth);
        Planets lordOfNavamsaOfNinthLord = lordOfRashi(d9.getRashiLords(), navamsaSignOfNinthLord);
        if (lordOfNavamsaOfNinthLord == null) {
            return false;
        }

        Houses second = Houses.SECOND_HOUSE;
        return second.equals(birthChartData.getPlanetHouses().get(lordOfNinth))
                && second.equals(birthChartData.getPlanetHouses().get(lordOfTenth))
                && second.equals(birthChartData.getPlanetHouses().get(lordOfNavamsaOfNinthLord));
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
