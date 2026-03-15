# Astrology Yoga Calculator

A small Java console application for checking whether a set of Vedic astrology yogas are present in a manually entered birth chart.

The program asks for the chart's `Lagna` and the house placement of each planet, builds an in-memory representation of the chart, and evaluates a fixed set of yoga rules. Matching yogas are then printed with short descriptions of their traditional effects.

## Features

- Interactive command-line input for Lagna and planetary house placements
- Internal birth chart model with house-wise and planet-wise lookups
- Support for both positive and negative yoga checks
- Simple rule-based design that is easy to extend with additional yogas
- Runs as a lightweight Java application with no external dependencies

## Implemented Yogas

The current codebase evaluates the following yogas:

### Positive Yogas

| Yoga | Implemented In |
| --- | --- |
| GajKesari Yoga | `yoga-calculator/src/yogas/GajKesariYoga.java` |
| Sunapha Yoga | `yoga-calculator/src/yogas/SunaphaYoga.java` |
| Anapha Yoga | `yoga-calculator/src/yogas/AnaphaYoga.java` |
| Dhurdhura Yoga | `yoga-calculator/src/yogas/DhurdhuraYoga.java` |
| Adhi Yoga | `yoga-calculator/src/yogas/AdhiYoga.java` |
| Chatussagara Yoga | `yoga-calculator/src/yogas/ChatussagaraYoga.java` |
| Vasumathi Yoga | `yoga-calculator/src/yogas/VasumathiYoga.java` |
| Rajalakshana Yoga | `yoga-calculator/src/yogas/RajalakshanaYoga.java` |
| Amala Yoga | `yoga-calculator/src/yogas/AmalaYoga.java` |
| Parvata Yoga | `yoga-calculator/src/yogas/ParvataYoga.java` |
| Vesi Yoga | `yoga-calculator/src/yogas/VesiYoga.java` |
| Vasi Yoga | `yoga-calculator/src/yogas/VasiYoga.java` |
| Obhayachari Yoga | `yoga-calculator/src/yogas/ObhayachariYoga.java` |
| Hamsa Yoga | `yoga-calculator/src/yogas/HamsaYoga.java` |
| Malavya Yoga | `yoga-calculator/src/yogas/MalavyaYoga.java` |
| Ruchaka Yoga | `yoga-calculator/src/yogas/RuchakaYoga.java` |
| Bhadra Yoga | `yoga-calculator/src/yogas/BhadraYoga.java` |
| Budha Aditya Yoga | `yoga-calculator/src/yogas/BudhaAdityaYoga.java` |
| Maha Bhagya Yoga | `yoga-calculator/src/yogas/MahaBhagyaYoga.java` |
| Pushkala Yoga | `yoga-calculator/src/yogas/PushkalaYoga.java` (stub) |
| Lakshmi Yoga | `yoga-calculator/src/yogas/LakshmiYoga.java` (stub) |
| Gauri Yoga | `yoga-calculator/src/yogas/GauriYoga.java` (stub) |
| Bharathi Yoga | `yoga-calculator/src/yogas/BharathiYoga.java` (stub) |
| Chapa Yoga | `yoga-calculator/src/yogas/ChapaYoga.java` |

### Negative Yogas

| Yoga | Implemented In |
| --- | --- |
| Kemadruma Yoga | `yoga-calculator/src/yogas/KemaDrumaYoga.java` |
| Chandra Mangala Yoga | `yoga-calculator/src/yogas/ChandraMangalaYoga.java` |
| Sakata Yoga | `yoga-calculator/src/yogas/SakataYoga.java` |
| Vanchana Chora Bheethi Yoga | `yoga-calculator/src/yogas/VanchanaChoraBheethiYoga.java` (stub) |
| Sasa Yoga | `yoga-calculator/src/yogas/SasaYoga.java` |

Note: The positive/negative grouping follows the codebase. Obhayachari Yoga is present when both Vesi and Vasi yogas are present. Maha Bhagya uses gender and birth period (morning/evening). Stub yogas return false until implemented.

## How It Works

The application flow is:

1. Ask the user for the birth chart's `Lagna`.
2. Ask for the **Birth Period** (Morning: sunrise to sunset, or Evening: sunset to sunrise).
3. Ask for the **Gender** of the native (Male or Female).
4. Ask for the house number of each planet.
5. Build derived chart data such as:
   - house -> rashi
   - planet -> house
   - house -> planets
   - planet -> rashi
   - planets placed in their own signs
6. Evaluate the configured yoga rules.
7. Print all matching positive yogas, then all matching negative yogas.

The current program uses manual house entry only. It does not calculate planetary positions from date, time, or location.

## Project Structure

```text
Astrology-YogaCalculator/
|-- README.md
`-- yoga-calculator/
    |-- yoga-calculator.iml
    `-- src/
        |-- YogaChecker.java
        |-- birthChart/
        |   `-- BirthChart.java
        |-- chartBlocks/
        |   |-- BirthPeriod.java
        |   |-- Gender.java
        |   |-- Houses.java
        |   |-- Planets.java
        |   `-- Rashis.java
        `-- yogas/
            |-- AbstractYoga.java
            |-- Yoga.java
            |-- AdhiYoga.java
            |-- AmalaYoga.java
            |-- AnaphaYoga.java
            |-- BharathiYoga.java
            |-- BhadraYoga.java
            |-- BudhaAdityaYoga.java
            |-- ChapaYoga.java
            |-- ChandraMangalaYoga.java
            |-- ChatussagaraYoga.java
            |-- DhurdhuraYoga.java
            |-- GajKesariYoga.java
            |-- GauriYoga.java
            |-- HamsaYoga.java
            |-- KemaDrumaYoga.java
            |-- LakshmiYoga.java
            |-- MahaBhagyaYoga.java
            |-- MalavyaYoga.java
            |-- ObhayachariYoga.java
            |-- ParvataYoga.java
            |-- PushkalaYoga.java
            |-- RajalakshanaYoga.java
            |-- RuchakaYoga.java
            |-- SakataYoga.java
            |-- SasaYoga.java
            |-- SunaphaYoga.java
            |-- VanchanaChoraBheethiYoga.java
            |-- VasiYoga.java
            |-- VasumathiYoga.java
            `-- VesiYoga.java
```

## Core Components

### `YogaChecker`

`yoga-calculator/src/YogaChecker.java` is the application entry point. It:

- creates a `BirthChart`
- collects user input
- prints some derived chart details
- iterates through the yoga registry and displays matches

### `BirthChart`

`yoga-calculator/src/birthChart/BirthChart.java` stores and derives the main chart data used by yoga rules, including:

- `Lagna`
- **Birth Period** (Morning / Evening) and **Gender** — used e.g. by Maha Bhagya Yoga
- house-wise rashis
- planet-wise houses
- house-wise planets
- planet-wise rashis
- own-house placements
- benefic and malefic groupings
- **`KENDRA_HOUSES`** — global list of the four angular houses (1st, 4th, 7th, 10th) for reuse in yoga rules
- **`DUSTHANA_OFFSETS`** — global list of dusthana house offsets (6, 8, 12) for reuse (e.g. Sakata Yoga)

It also provides utility logic such as `getNthHouseFromGivenHouse(...)` and `getRashiLords()`, which are used heavily by the yoga implementations.

### `chartBlocks`

The `chartBlocks` package contains the basic building blocks used throughout the project:

- `Houses` for the 12 houses
- `Rashis` for the 12 rashis
- `Planets` for the planetary constants used by the rules

### `yogas`

The `yogas` package contains the rule engine:

- `Yoga.java` defines the yoga contract and holds the active yoga registry
- `AbstractYoga.java` provides shared fields for yoga name and effect text
- each concrete class implements the rule for one yoga

## Prerequisites

- Java 8 (the IntelliJ project is configured for JDK 1.8)
- A terminal or IDE capable of running Java applications

## Running The Project

### Option 1: Run With IntelliJ IDEA

This is the easiest way to run the project.

1. Open the repository in IntelliJ IDEA.
2. Configure the project SDK to Java 8 / JDK 1.8.
3. Open `yoga-calculator/src/YogaChecker.java`.
4. Run `YogaChecker.main()`.

### Option 2: Run From The Command Line On Windows PowerShell

From the repository root:

```powershell
Set-Location ".\yoga-calculator\src"
mkdir ..\out
javac -d ..\out (Get-ChildItem -Recurse -Filter *.java | ForEach-Object { $_.FullName })
java -cp ..\out YogaChecker
```

Compilation was verified from the repository on Windows PowerShell. The program is interactive, so after launch it will prompt for input in the terminal.

If `..\out` already exists, `mkdir` may print a message or reuse the folder depending on your shell behavior.

## Usage

When the application starts, it prompts for:

- the Lagna as a number from `1` to `12`
- the Birth Period: `1` for Morning (sunrise to sunset), `2` for Evening (sunset to sunrise)
- the Gender: `1` for Male, `2` for Female
- the house placement of each planet as a number from `1` to `12`

The current planet input order is:

1. `SUN`
2. `MOON`
3. `JUPITER`
4. `RAHU`
5. `MERCURY`
6. `VENUS`
7. `KETU`
8. `SATURN`
9. `MARS`

After all inputs are provided, the app prints:

- planets that are in their own signs
- matching positive yogas
- matching negative yogas

## Example Session

The exact output depends on the chart entered, but a typical session starts like this:

```text
Enter the Lagna of the birth chart (Select accordingly):
1 for Aries
2 for Taurus
3 for Gemini
...
Choose any one of the above:
What is the house of SUN ? Enter house number from 1 to 12
What is the house of MOON ? Enter house number from 1 to 12
...
```

Once all values are entered, the application prints the detected yogas under `POSITIVE YOGAS` and `NEGATIVE YOGAS`.

## Design Notes

- The yoga list is hard-coded in `yoga-calculator/src/yogas/Yoga.java`.
- The project is currently a console application, not a library or web service.
- All chart data is entered manually by the user.
- There are no external frameworks or third-party dependencies.

## Extending The Project

To add a new yoga:

1. Create a new class in `yoga-calculator/src/yogas/`.
2. Extend `AbstractYoga`.
3. Set the yoga name and effect in the constructor.
4. Implement `isYogaPresent(BirthChart birthChartData)`.
5. Register the new class in either `positiveYogas` or `negativeYogas` inside `yoga-calculator/src/yogas/Yoga.java`.

This keeps new rules isolated and makes the project easy to grow as more yogas are implemented.

## Limitations

- No automated tests are included yet.
- No build tool wrapper is included; the project is currently managed as a plain Java/IntelliJ module.
- Input validation is minimal and focused mainly on house number range checks.
- The program does not compute charts from birth details such as date, time, and location.
- Yoga rules reflect the current implementation and may not cover every traditional interpretation or exception.

## Contributing

Contributions are welcome, especially for:

- adding more yoga rules
- improving rule accuracy
- strengthening input validation
- adding automated tests
- providing sample charts and expected outputs
- packaging the project with Maven or Gradle

If you contribute, try to keep new yoga logic self-contained inside the `yogas` package and reuse `BirthChart` utilities where possible.

## License

No license file is currently present in the repository. If you plan to publish or accept outside contributions, adding a license would be a good next step.
