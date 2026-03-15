package yogas;

import birthChart.BirthChart;
import chartBlocks.BirthPeriod;
import chartBlocks.Gender;
import chartBlocks.Planets;
import chartBlocks.Rashis;

/*
Maha Bhagya Yoga occurs when:
1. The native is male, born during morning, and the Sun, Moon and Lagna all occupy odd signs; or
2. The native is female, born during evening, and the Sun, Moon and Lagna all occupy even signs.
Odd signs: 1,3,5,7,9,11 (Aries, Gemini, Leo, Libra, Sagittarius, Aquarius). Even signs: 2,4,6,8,10,12.
 */
public class MahaBhagyaYoga extends AbstractYoga {

    public MahaBhagyaYoga() {
        setYogaName("Maha Bhagya Yoga");
        setYogaEffect("The native is considered highly fortunate. This rare combination bestows prosperity, good character, respect and a generally auspicious life. The person may enjoy marital harmony, wealth and recognition. A male born under this Yoga will have good character, will be a source of pleasure to others, will be liberal, generous, famous, a ruler or an equal to him and lives to a good old age. A female born in this combination will be blessed with long-lived children and wealth and she will be of good conduct");
    }

    @Override
    public boolean isYogaPresent(BirthChart birthChartData) {
        Rashis lagna = birthChartData.getLagna();
        Rashis sunRashi = birthChartData.getPlanetWiseRashis().get(Planets.SUN);
        Rashis moonRashi = birthChartData.getPlanetWiseRashis().get(Planets.MOON);

        if (lagna == null || sunRashi == null || moonRashi == null) {
            return false;
        }

        boolean maleMorningAllOdd = birthChartData.getGender() == Gender.MALE
                && birthChartData.getBirthPeriod() == BirthPeriod.MORNING
                && isOddSign(lagna) && isOddSign(sunRashi) && isOddSign(moonRashi);

        boolean femaleEveningAllEven = birthChartData.getGender() == Gender.FEMALE
                && birthChartData.getBirthPeriod() == BirthPeriod.EVENING
                && isEvenSign(lagna) && isEvenSign(sunRashi) && isEvenSign(moonRashi);

        return maleMorningAllOdd || femaleEveningAllEven;
    }

    private boolean isOddSign(Rashis rashi) {
        Integer num = Rashis.getRashiNumber(rashi);
        return num != null && num % 2 == 1;
    }

    private boolean isEvenSign(Rashis rashi) {
        Integer num = Rashis.getRashiNumber(rashi);
        return num != null && num % 2 == 0;
    }
}
