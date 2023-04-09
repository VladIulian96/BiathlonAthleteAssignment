package org.example;

public class Athlete {

    private final String athleteNumber;
    private final String athleteName;
    private final String countryCode;

    private final String firstShootingResult;
    private final String secondShootingResult;
    private final String thirdShootingResult;
    private int totalShootingResult = 0;

    public Athlete(String athleteNumber, String athleteName, String countryCode, String skiTimeResult, String firstShootingResult, String secondShootingResult, String thirdShootingResult) {
        this.athleteNumber = athleteNumber;
        this.athleteName = athleteName;
        this.countryCode = countryCode;
        this.skiTimeResult = skiTimeResult;
        this.firstShootingResult = firstShootingResult;
        this.secondShootingResult = secondShootingResult;
        this.thirdShootingResult = thirdShootingResult;
    }

    public String getAthleteNumber() {
        return athleteNumber;
    }

    public String getAthleteName() {
        return athleteName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getFirstShootingResult() {
        return firstShootingResult;
    }

    public String getSecondShootingResult() {
        return secondShootingResult;
    }

    public String getThirdShootingResult() {
        return thirdShootingResult;
    }

    public int getTotalShootingResult() {
        return totalShootingResult;
    }

    public void setTotalShootingResult(int totalShootingResult) {
        this.totalShootingResult = totalShootingResult;
    }

    public String getSkiTimeResult() {
        return skiTimeResult;
    }

    public String getFinalStanding() {
        return finalStanding;
    }

    public void setFinalStanding(String finalStanding) {
        this.finalStanding = finalStanding;
    }

    private final String skiTimeResult;
    private String finalStanding;


}
