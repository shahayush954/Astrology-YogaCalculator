package birthChart;

import chartBlocks.Houses;
import chartBlocks.Planets;
import chartBlocks.Rashis;

import java.util.*;

/**
 * Navamsa (D9) chart: same structural model as {@link BirthChart} for the divisional chart.
 * Birth period and gender are not stored for Navamsa; use {@link BirthChart} for those.
 */
public class NavamsaBirthChart {

    Rashis Lagna = null;
    Map<Houses, Rashis> houseWiseRashis = new HashMap<>();
    Map<Planets, Houses> planetHouses = new HashMap<>();
    Map<Houses, List<Planets>> houseWisePlanets = new HashMap<>();
    Map<Planets, Rashis> planetWiseRashis = new HashMap<>();
    Map<Planets, Rashis> ownHousePlanets = new HashMap<>();

    Map<Planets, List<Rashis>> rashiLords = new HashMap(){{
        put(Planets.SUN, Arrays.asList(Rashis.getRashiFromNumber(5)));
        put(Planets.MOON, Arrays.asList(Rashis.getRashiFromNumber(4)));
        put(Planets.MERCURY, Arrays.asList(Rashis.getRashiFromNumber(3), Rashis.getRashiFromNumber(6)));
        put(Planets.VENUS, Arrays.asList(Rashis.getRashiFromNumber(2), Rashis.getRashiFromNumber(7)));
        put(Planets.MARS, Arrays.asList(Rashis.getRashiFromNumber(1), Rashis.getRashiFromNumber(8)));
        put(Planets.JUPITER, Arrays.asList(Rashis.getRashiFromNumber(9), Rashis.getRashiFromNumber(12)));
        put(Planets.SATURN, Arrays.asList(Rashis.getRashiFromNumber(10), Rashis.getRashiFromNumber(11)));
    }};

    Map<Planets, Rashis> planetWiseExaltationSigns = new HashMap(){{
        put(Planets.SUN, Rashis.ARIES);
        put(Planets.MOON, Rashis.TAURUS);
        put(Planets.JUPITER, Rashis.CANCER);
        put(Planets.RAHU, Rashis.GEMINI);
        put(Planets.MERCURY, Rashis.VIRGO);
        put(Planets.VENUS, Rashis.PISCES);
        put(Planets.KETU, Rashis.SAGITTARIUS);
        put(Planets.SATURN, Rashis.LIBRA);
        put(Planets.MARS, Rashis.CAPRICORN);
    }};

    List<Planets> maleficPlanets = new ArrayList<>(Arrays.asList(
            Planets.SUN, Planets.SATURN, Planets.MARS
    ));

    List<Planets> beneficPlanets = new ArrayList<>(Arrays.asList(
            Planets.JUPITER, Planets.VENUS
    ));

    List<Planets> neutralPlanets = new ArrayList<>(Arrays.asList(
            Planets.MOON
    ));

    List<Planets> naturalMaleficPlanets = Arrays.asList(
            Planets.SUN, Planets.SATURN, Planets.MARS
    );

    List<Planets> naturalBeneficPlanets = Arrays.asList(
            Planets.MERCURY, Planets.JUPITER, Planets.VENUS
    );

    /** Same Kendra definition as {@link BirthChart}. */
    public static final List<Houses> KENDRA_HOUSES = BirthChart.KENDRA_HOUSES;

    /** Same dusthana offsets as {@link BirthChart}. */
    public static final List<Integer> DUSTHANA_OFFSETS = BirthChart.DUSTHANA_OFFSETS;

    /** Console flow: D9 Lagna, then planet houses and derived chart data. */
    public void getNavamsaBirthChartDetails() {
        completeNavamsaChart();
    }

    private void completeNavamsaChart() {
        initializeLagna();
        initializeRashisForEachHouse();
        initializeHousesForEachPlanet();
        initializeHouseWisePlanets();
        initializePlanetWiseRashis();
        initializeOwnHousePlanets();
        initializeMaleficsAndBenefics();
    }

    private void initializeLagna() {
        while (Lagna == null) {
            System.out.println("Enter the Navamsa (D9) Lagna (Select accordingly): ");
            System.out.println("1 for " + Rashis.ARIES);
            System.out.println("2 for " + Rashis.TAURUS);
            System.out.println("3 for " + Rashis.GEMINI);
            System.out.println("4 for " + Rashis.CANCER);
            System.out.println("5 for " + Rashis.LEO);
            System.out.println("6 for " + Rashis.VIRGO);
            System.out.println("7 for " + Rashis.LIBRA);
            System.out.println("8 for " + Rashis.SCORPIO);
            System.out.println("9 for " + Rashis.SAGITTARIUS);
            System.out.println("10 for " + Rashis.CAPRICORN);
            System.out.println("11 for " + Rashis.AQUARIUS);
            System.out.println("12 for " + Rashis.PISCES);
            System.out.println("Choose any one of the above: ");
            Scanner sc = new Scanner(System.in);
            int lagna = sc.nextInt();
            this.Lagna = Rashis.getRashiFromNumber(lagna);
        }
    }

    private void initializeRashisForEachHouse() {
        if (this.Lagna == null) return;

        Integer rashiNumber = Rashis.getRashiNumber(this.Lagna);
        for (int i=1; i<=12; i++) {
            houseWiseRashis.put(Houses.getHouseByNumber(i), Rashis.getRashiFromNumber(rashiNumber));
            rashiNumber = (rashiNumber % 12) + 1;
        }
    }

    private void initializeHousesForEachPlanet() {
        if (this.Lagna == null) return;
        Planets[] allPlanets = Planets.values();
        int i=0;
        Scanner sc = new Scanner(System.in);
        while (i<allPlanets.length) {
            System.out.println("Navamsa (D9): What is the house of " + allPlanets[i] + " ? Enter house number from 1 to 12");
            int planetHouse = sc.nextInt();

            if (planetHouse < 1 || planetHouse > 12)  {
                System.out.println("Invalid House Number!");
                continue;
            }

            planetHouses.put(allPlanets[i], Houses.getHouseByNumber(planetHouse));
            i++;
        }
    }

    private void initializeHouseWisePlanets() {
        for (Map.Entry<Planets, Houses> entry : planetHouses.entrySet()) {
            Houses house = entry.getValue();
            Planets planet = entry.getKey();
            List<Planets> planetsList = houseWisePlanets.getOrDefault(house, new ArrayList<>());
            planetsList.add(planet);
            houseWisePlanets.put(house, planetsList);
        }
    }

    private void initializePlanetWiseRashis() {
        for (Map.Entry<Planets, Houses> entry : planetHouses.entrySet()) {
            Houses house = entry.getValue();
            Planets planet = entry.getKey();
            Rashis rashi = houseWiseRashis.get(house);
            planetWiseRashis.put(planet, rashi);
        }
    }

    private void initializeOwnHousePlanets() {
        for (Map.Entry<Planets, Houses> entry : planetHouses.entrySet()) {
            Planets planet = entry.getKey();
            Houses house = entry.getValue();
            Rashis planetRashi = houseWiseRashis.get(house);

            if (rashiLords.containsKey(planet) && rashiLords.get(planet).contains(planetRashi)) {
                ownHousePlanets.put(planet, planetRashi);
            }
        }
    }

    private void initializeMaleficsAndBenefics() {
        Houses houseOfRahu = planetHouses.get(Planets.RAHU);
        Houses houseOfKetu = planetHouses.get(Planets.KETU);
        Houses houseOfMercury = planetHouses.get(Planets.MERCURY);

        boolean isBeneficWithRahu = false;
        boolean isBeneficWithKetu = false;
        boolean isBeneficWithMercury = false;

        boolean isMaleficWithRahu = false;
        boolean isMaleficWithKetu = false;
        boolean isMaleficWithMercury = false;

        for(Planets benefic : beneficPlanets) {
            isBeneficWithRahu = houseWisePlanets.get(houseOfRahu).contains(benefic);
            isBeneficWithKetu = houseWisePlanets.get(houseOfKetu).contains(benefic);
            isBeneficWithMercury = houseWisePlanets.get(houseOfMercury).contains(benefic);
        }

        for(Planets malefic : maleficPlanets) {
            isMaleficWithRahu = houseWisePlanets.get(houseOfRahu).contains(malefic);
            isMaleficWithKetu = houseWisePlanets.get(houseOfKetu).contains(malefic);
            isMaleficWithMercury = houseWisePlanets.get(houseOfMercury).contains(malefic);
        }

        if (isBeneficWithRahu && isMaleficWithRahu) {
            neutralPlanets.add(Planets.RAHU);
        } else if (isBeneficWithRahu) {
            beneficPlanets.add(Planets.RAHU);
        } else {
            maleficPlanets.add(Planets.RAHU);
        }

        if (isBeneficWithKetu && isMaleficWithKetu) {
            neutralPlanets.add(Planets.KETU);
        } else if (isBeneficWithKetu) {
            beneficPlanets.add(Planets.KETU);
        } else {
            maleficPlanets.add(Planets.KETU);
        }

        if (isBeneficWithMercury && isMaleficWithMercury) {
            neutralPlanets.add(Planets.MERCURY);
        } else if (isBeneficWithMercury) {
            beneficPlanets.add(Planets.MERCURY);
        } else if (isMaleficWithMercury) {
            maleficPlanets.add(Planets.MERCURY);
        } else {
            neutralPlanets.add(Planets.MERCURY);
        }
    }

    public void printHouseWiseRashis() {
        System.out.println("==================== Navamsa (D9) — House wise Rashis: ");
        for (Map.Entry<Houses, Rashis> entry : houseWiseRashis.entrySet()) {
            System.out.println("House: " + entry.getKey() + "  Rashi: " + entry.getValue());
        }
        System.out.println();
        System.out.println();
    }

    public void printPlanetHouses() {
        System.out.println("==================== Navamsa (D9) — Houses for each Planet: ");
        for (Map.Entry<Planets, Houses> entry : planetHouses.entrySet()) {
            System.out.println("Planet: " + entry.getKey() + " House: " + entry.getValue());
        }
        System.out.println();
        System.out.println();
    }

    public void printHouseWisePlanets() {
        System.out.println("==================== Navamsa (D9) — House containing planets: ");
        for (Map.Entry<Houses, List<Planets>> entry : houseWisePlanets.entrySet()) {
            System.out.println("House: " + entry.getKey() + " Planets: " + entry.getValue());
        }
        System.out.println();
        System.out.println();
    }

    public void printPlanetWiseRashi() {
        System.out.println("==================== Navamsa (D9) — Rashis of each planet: ");
        for (Map.Entry<Planets, Rashis> entry : planetWiseRashis.entrySet()) {
            System.out.println("Planet: " + entry.getKey() + " Rashi: " + entry.getValue());
        }
        System.out.println();
        System.out.println();
    }

    public void printOwnHousePlanets() {
        System.out.println("==================== Navamsa (D9) — Planets in own sign: ");
        for (Map.Entry<Planets, Rashis> entry : ownHousePlanets.entrySet()) {
            System.out.println("Planet: " + entry.getKey() + " is placed in its own Rashi: " + entry.getValue());
        }
        System.out.println();
        System.out.println();
    }

    public Rashis getLagna() {
        return Lagna;
    }

    public Map<Houses, Rashis> getHouseWiseRashis() {
        return houseWiseRashis;
    }

    public Map<Planets, Houses> getPlanetHouses() {
        return planetHouses;
    }

    public Map<Houses, List<Planets>> getHouseWisePlanets() {
        return houseWisePlanets;
    }

    public Map<Planets, Rashis> getPlanetWiseRashis() {
        return planetWiseRashis;
    }

    public Map<Planets, Rashis> getOwnHousePlanets() {
        return ownHousePlanets;
    }

    public Map<Planets, List<Rashis>> getRashiLords() {
        return rashiLords;
    }

    public Houses getNthHouseFromGivenHouse(Houses start, int delta) {
        int startNum = start.getHouseNumber();
        int result = (((startNum + delta) - 1) % 12);
        result = result == 0 ? 12 : result;
        return Houses.getHouseByNumber(result);
    }

    public List<Planets> getNaturalMaleficPlanets() {
        return naturalMaleficPlanets;
    }

    public List<Planets> getNaturalBeneficPlanets() {
        return naturalBeneficPlanets;
    }

    public Rashis getExaltationRashi(Planets planet) {
        return planetWiseExaltationSigns.get(planet);
    }

    public Planets getLordOfHouse(Houses house) {
        Rashis rashiInHouse = houseWiseRashis.get(house);
        if (rashiInHouse == null) return null;
        return rashiLords.entrySet().stream()
                .filter(e -> e.getValue() != null && e.getValue().contains(rashiInHouse))
                .map(e -> e.getKey())
                .findFirst()
                .orElse(null);
    }
}
