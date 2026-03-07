import birthChart.BirthChart;
import yogas.Yoga;

public class YogaChecker {

    public static final String RESET = "\u001B[0m";
    public static final String BOLD = "\u001B[1m";

    public static void main(String[] args) {
        BirthChart birthChart = new BirthChart();
        birthChart.getBirthChartDetails();
//        birthChart.printHouseWiseRashis();
//        birthChart.printPlanetHouses();
//        birthChart.printHouseWisePlanets();
//        birthChart.printPlanetWiseRashi();
        birthChart.printOwnHousePlanets();

        System.out.println("************************************************* POSITIVE YOGAS *************************************************");
        for (Yoga yoga : Yoga.positiveYogas) {
            if (yoga.isYogaPresent(birthChart)) {
                System.out.println("================================================================");
                System.out.println(BOLD + yoga.getYogaName() + RESET);
                System.out.println(yoga.getYogaEffect());
            }
        }

        System.out.println("************************************************* NEGATIVE YOGAS *************************************************");
        for (Yoga yoga : Yoga.negativeYogas) {
            if (yoga.isYogaPresent(birthChart)) {
                System.out.println("================================================================");
                System.out.println(BOLD + yoga.getYogaName() + RESET);
                System.out.println(yoga.getYogaEffect());
            }
        }
    }

}
