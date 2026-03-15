package yogas;

import birthChart.BirthChart;
import chartBlocks.Houses;
import chartBlocks.Planets;
import chartBlocks.Rashis;

/*
Bhadra Yoga occurs when Mercury occupies one of the Kendra houses (1st, 4th, 7th or 10th)
and is placed in either its own sign or its sign of exaltation.
 */
public class BhadraYoga extends AbstractYoga {

    public BhadraYoga() {
        setYogaName("Bhadra Yoga");
        setYogaEffect("This is one of the PanchaMahaPurush Yogas. The native is intelligent, skilled in speech and business. Mercury in a Kendra in own or exaltation sign bestows learning, wealth through trade or intellect, and success in education or communication. The person may excel in writing, commerce or analytical fields. The person will be intelligent, will have good memory, will be learned, will be well-versed in Sanskrit, will have a good command over speech, will be well-versed in logic and will be an excellent speaker. The person born in Bhadra Yoga will be strong, will have a lion-like face, well-developed chest, well-proportioned limbs, will be taciturn, will help relatives and will live up to a good old age");
    }

    @Override
    public boolean isYogaPresent(BirthChart birthChartData) {
        Houses houseOfMercury = birthChartData.getPlanetHouses().get(Planets.MERCURY);
        if (houseOfMercury == null || !BirthChart.KENDRA_HOUSES.contains(houseOfMercury)) {
            return false;
        }

        Rashis mercuryRashi = birthChartData.getPlanetWiseRashis().get(Planets.MERCURY);
        if (mercuryRashi == null) {
            return false;
        }

        boolean inOwnSign = birthChartData.getOwnHousePlanets().containsKey(Planets.MERCURY);
        Rashis exaltationRashi = birthChartData.getExaltationRashi(Planets.MERCURY);
        boolean inExaltedSign = exaltationRashi != null && mercuryRashi == exaltationRashi;

        return inOwnSign || inExaltedSign;
    }
}
