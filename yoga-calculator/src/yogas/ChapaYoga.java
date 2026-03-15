package yogas;

import birthChart.BirthChart;
import chartBlocks.Houses;
import chartBlocks.Planets;
import chartBlocks.Rashis;

/*
Chapa Yoga occurs when all of the following are satisfied:
1. The lord of the 1st house is in exaltation.
2. The lord of the 4th house is in the 10th house.
3. The lord of the 10th house is in the 4th house.
 */
public class ChapaYoga extends AbstractYoga {

    public ChapaYoga() {
        setYogaName("Chapa Yoga");
        setYogaEffect("The native gains success, recognition and a strong position in life. This combination of lord placements bestows fame, authority and the ability to achieve goals like an arrow from a bow.");
    }

    @Override
    public boolean isYogaPresent(BirthChart birthChartData) {
        return lordOfFirstInExaltation(birthChartData)
                && lordOfFourthInTenthHouse(birthChartData)
                && lordOfTenthInFourthHouse(birthChartData);
    }

    private boolean lordOfFirstInExaltation(BirthChart birthChartData) {
        Planets lordOfFirst = getLordOfHouse(birthChartData, Houses.FIRST_HOUSE);
        if (lordOfFirst == null) return false;
        Rashis lordRashi = birthChartData.getPlanetWiseRashis().get(lordOfFirst);
        Rashis exaltationRashi = birthChartData.getExaltationRashi(lordOfFirst);
        return lordRashi != null && exaltationRashi != null && lordRashi == exaltationRashi;
    }

    private boolean lordOfFourthInTenthHouse(BirthChart birthChartData) {
        Planets lordOfFourth = getLordOfHouse(birthChartData, Houses.FOURTH_HOUSE);
        if (lordOfFourth == null) return false;
        Houses houseOfLord = birthChartData.getPlanetHouses().get(lordOfFourth);
        return houseOfLord == Houses.TENTH_HOUSE;
    }

    private boolean lordOfTenthInFourthHouse(BirthChart birthChartData) {
        Planets lordOfTenth = getLordOfHouse(birthChartData, Houses.TENTH_HOUSE);
        if (lordOfTenth == null) return false;
        Houses houseOfLord = birthChartData.getPlanetHouses().get(lordOfTenth);
        return houseOfLord == Houses.FOURTH_HOUSE;
    }

    private Planets getLordOfHouse(BirthChart birthChartData, Houses house) {
        Rashis rashiInHouse = birthChartData.getHouseWiseRashis().get(house);
        if (rashiInHouse == null) return null;
        return birthChartData.getRashiLords().entrySet().stream()
                .filter(e -> e.getValue() != null && e.getValue().contains(rashiInHouse))
                .map(e -> e.getKey())
                .findFirst()
                .orElse(null);
    }
}
