package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AthleteManager {

    private final String path = "C:\\Users\\ramez\\OneDrive\\Desktop\\Java Development\\Proiecte\\BiathlonAthleteAssignment\\src\\main\\java\\org\\example\\Athletes.csv";
    public List<Athlete> athleteList = new ArrayList<>();

    public void runApplication() throws IOException, InputException {
        for (String athlete : readAllLinesFromCsv()) {
            addAthlete(createAthlete(athlete));
        }

        for(Athlete athlete : athleteList) {
            calculateAthleteFinalStanding(athlete);
        }
        sortAthletes();
        printAthletes();
    }

    public List<String> readAllLinesFromCsv() throws IOException {
        List<String> athleteList = new ArrayList<>();

        BufferedReader bufferedReader = new BufferedReader(new FileReader(this.path));

        while (bufferedReader.ready()) {
            athleteList.add(bufferedReader.readLine());
        }
        return athleteList;
    }

    public Athlete createAthlete(String line) throws InputException {
        String[] wordArray = line.split(",");

        if(wordArray.length == 7) {
            return new Athlete(wordArray[0], wordArray[1], wordArray[2], wordArray[3], wordArray[4], wordArray[5], wordArray[6]);
        } else {
            throw new InputException("Couldn't create an athlete!");
        }
    }

    public void addAthlete(Athlete athlete) {
        if(athlete == null)
            throw new RuntimeException("Couldn't add an athlete!");

        this.athleteList.add(athlete);
    }

    /**
     * Calculates the final standing (skiTimeResult + totalShootingResult) of the athletes
     * @param athlete
     */
    public void calculateAthleteFinalStanding(Athlete athlete) {
        if(athlete == null)
            throw new RuntimeException("Couldn't calculate the final standing!");

        char[] firstShootingResultCharArray = athlete.firstShootingResult.toCharArray();
        for(char symbol : firstShootingResultCharArray) {
            if(symbol == 'o') {
                athlete.totalShootingResult += 10;
            }
        }

        char[] secondShootingResultCharArray = athlete.secondShootingResult.toCharArray();
        for(char symbol : secondShootingResultCharArray) {
            if(symbol == 'o') {
                athlete.totalShootingResult += 10;
            }
        }

        char[] thirdShootingResultCharArray = athlete.thirdShootingResult.toCharArray();
        for(char symbol : thirdShootingResultCharArray) {
            if(symbol == 'o') {
                athlete.totalShootingResult += 10;
            }
        }

        athlete.finalStanding = timeConvertorIntoString(timeConvertor(athlete.skiTimeResult) + athlete.totalShootingResult);
    }

    public void sortAthletes() {
        this.athleteList.sort(new AthleteComparator());
    }

    public void printAthletes() {
        if(athleteList.size() > 2) {
            System.out.println("Winner - "      + athleteList.get(0).athleteName + " " + athleteList.get(0).finalStanding + " (" + athleteList.get(0).skiTimeResult + " + " + athleteList.get(0).totalShootingResult + ")");
            System.out.println("Runner-up - "   + athleteList.get(1).athleteName + " " + athleteList.get(1).finalStanding + " (" + athleteList.get(1).skiTimeResult + " + " + athleteList.get(1).totalShootingResult + ")");
            System.out.println("Third Place - " + athleteList.get(2).athleteName + " " + athleteList.get(2).finalStanding + " (" + athleteList.get(2).skiTimeResult + " + " + athleteList.get(2).totalShootingResult + ")");
        } else {
            throw new RuntimeException("Couldn't print athletes!");
        }
    }

    /**
     * @implNote Basically a remake of the Duration class from the java.time package
     * Takes a string that has 2 numbers which are split by a colon
     * and converts the number on the left from minutes to seconds
     * @returns the time in seconds
     */
    public int timeConvertor(String time) {
        int numberInSeconds;
        String[] timer = time.split(":");

        int minutes = Integer.parseInt(timer[0]);
        int seconds = Integer.parseInt(timer[1]);

        numberInSeconds = seconds + (minutes * 60);

        return numberInSeconds;
    }

    /**
     * Does the opposite of what #timeConvertor does
     * @see #timeConvertor(String)
     * Takes an int called seconds and transforms it into a string
     * @returns a formatted string that has minutes and seconds
     */
    public String timeConvertorIntoString(int numberInSeconds) {
        int minutes = 0;
        int seconds = 0;
        String number = "";

        for(int i = 0; i < numberInSeconds; i++) {
            seconds++;

            if(seconds == 60) {
                minutes += 1;
                seconds = 0;
            }
        }
        number = minutes + ":" + seconds;

        return number;
    }

}
