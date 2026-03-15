package yogas;

import birthChart.BirthChart;
import chartBlocks.Houses;
import chartBlocks.Planets;
import chartBlocks.Rashis;

/*
Ruchaka Yoga occurs when Mars occupies one of the Kendra houses (1st, 4th, 7th or 10th)
and is placed in either its own sign or its sign of exaltation.
 */
public class RuchakaYoga extends AbstractYoga {

    public RuchakaYoga() {
        setYogaName("Ruchaka Yoga");
        setYogaEffect("This is one of the PanchaMahaPurush Yogas. The native is courageous, energetic and capable of leadership. Mars in a Kendra in own or exaltation sign bestows valour, property, authority and success in competitive or martial pursuits. The person may excel in sports, defence or positions requiring initiative. The person born in Ruchaka will have a strong physique, famous, well-versed in ancient lore, King or an equal to a King, conforming to traditions and customs. He will have a ruddy complexion, attractive body, charitable disposition, wealthy, long-lived and leader of an army.");
    }

    @Override
    public boolean isYogaPresent(BirthChart birthChartData) {
        Houses houseOfMars = birthChartData.getPlanetHouses().get(Planets.MARS);
        if (houseOfMars == null || !BirthChart.KENDRA_HOUSES.contains(houseOfMars)) {
            return false;
        }

        Rashis marsRashi = birthChartData.getPlanetWiseRashis().get(Planets.MARS);
        if (marsRashi == null) {
            return false;
        }

        boolean inOwnSign = birthChartData.getOwnHousePlanets().containsKey(Planets.MARS);
        Rashis exaltationRashi = birthChartData.getExaltationRashi(Planets.MARS);
        boolean inExaltedSign = exaltationRashi != null && marsRashi == exaltationRashi;

        return inOwnSign || inExaltedSign;
    }
}
