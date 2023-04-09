package org.example;

public class Athlete {

    public final String athleteNumber;
    public final String athleteName;
    public final String countryCode;

    public final String firstShootingResult;
    public final String secondShootingResult;
    public final String thirdShootingResult;
    public int totalShootingResult = 0;

    public final String skiTimeResult;
    public String finalStanding;

    public Athlete(String athleteNumber, String athleteName, String countryCode, String skiTimeResult, String firstShootingResult, String secondShootingResult, String thirdShootingResult) {
        this.athleteNumber = athleteNumber;
        this.athleteName = athleteName;
        this.countryCode = countryCode;
        this.skiTimeResult = skiTimeResult;
        this.firstShootingResult = firstShootingResult;
        this.secondShootingResult = secondShootingResult;
        this.thirdShootingResult = thirdShootingResult;
    }

}
