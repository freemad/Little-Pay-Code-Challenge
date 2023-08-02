# LittlePay Code Challenge
### coded by "Emad Mokhatab" @ 23-08-02

---

## General Information
- Code has been written in Java 8 language
- "Apache Common CSV" & "Apache Common Lang" packages have been used for CSV files manipulation.
- "Lombok" package has been used to avoid boiler-plate codes.
- "JUnit 5" packages have been used.

## Build and Run Service
- To build/clean-rebuild the program, open a terminal in the package root and type "mvn clean install".
- The 1st argument should be the path and filename of Taps CSV file which is fed into the service (Input).
- The 2nd argument should be the path and filename of Trips CSV file that will be generated (Output).
- To run the service in the terminal type "java -jar LittlePayCodeChallenge-1.0-SNAPSHOT.jar ./taps.csv ./trips.csv"
- Which taps.csv and trips.csv are input and output files in the root directory respectively.

## Assumptions
- All Base Data like "Stops", "Cards", "Buses", "Companies", etc. are introduced before to the system and there is no new Base Data in the Taps CSV file.
- The file is ingested after Business Process Reset (All the Busses came back to the garage and no passenger is in them). So if a Tap-Off occurs without a relevant Tap-On prior to it, a Business Exception will be raised, because a Business/Operation error should generate the state.
- All the repositories are hard-coded in the package; in a real-world project it's not possible. But because there is no DBMS introduced, they haven't been used in this phase.
- No Framework was introduced so they haven't been used in this phase.
- Sure either DBMSes or Java Frameworks can be used to improve the project usability.

## Suggestions
- The Base Data can be stored in a DBMSes
- A Java Framework, like Spring Boot, can be used in.
- Some parts of the project can be refactored, design-patterns applied and clean-coded if there is enough time.
- Some Solution Architecture/Design can be applied into the project to be more realistic.
- It can be ready to be deployed in containers.
