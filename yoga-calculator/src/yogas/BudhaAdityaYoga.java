package yogas;

import birthChart.BirthChart;
import chartBlocks.Houses;
import chartBlocks.Planets;

/*
Budha Aditya Yoga occurs when Mercury and the Sun are placed in the same house.
 */
public class BudhaAdityaYoga extends AbstractYoga {

    public BudhaAdityaYoga() {
        setYogaName("Budha Aditya Yoga");
        setYogaEffect("The native is intelligent, articulate and gains recognition. The combination of Mercury and Sun in the same house bestows sharp intellect, success in education or administration, and the ability to influence or lead through communication. The person may hold positions of authority or excel in fields requiring both intellect and confidence.");
    }

    @Override
    public boolean isYogaPresent(BirthChart birthChartData) {
        Houses houseOfMercury = birthChartData.getPlanetHouses().get(Planets.MERCURY);
        Houses houseOfSun = birthChartData.getPlanetHouses().get(Planets.SUN);

        return houseOfMercury != null && houseOfSun != null && houseOfMercury == houseOfSun;
    }
}
