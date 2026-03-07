import birthChart.BirthChart;

public class YogaChecker {

    public static void main(String[] args) {
        BirthChart birthChart = new BirthChart();
        birthChart.getBirthChartDetails();
        birthChart.printHouseWiseRashis();
        birthChart.printPlanetHouses();
        birthChart.printHouseWisePlanets();
        birthChart.printPlanetWiseRashi();
        birthChart.printOwnHousePlanets();
    }

}
