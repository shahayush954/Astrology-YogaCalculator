package yogas;

import birthChart.BirthChart;
import chartBlocks.Houses;
import chartBlocks.Planets;

/*
If Mars conjoins the Moon this yoga is formed.
 */
public class ChandraMangalaYoga extends AbstractYoga{

    public ChandraMangalaYoga() {
        setYogaName("Chandra Mangala Yoga");
        setYogaEffect("Earnings through unscrupulous means' a seller of women, treating mother harshly and doing mischief to her and other relatives. Can be positive also based on House, malefics and benefics");
    }
    @Override
    public boolean isYogaPresent(BirthChart birthChartData) {
        Houses houseOfMoon = birthChartData.getPlanetHouses().get(Planets.MOON);
        Houses houseOfMars = birthChartData.getPlanetHouses().get(Planets.MARS);

        return houseOfMoon == houseOfMars;
    }
}
