package org.example;

import java.util.Comparator;

public class AthleteComparator implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        AthleteManager athleteManager = new AthleteManager();

        o1 = (Athlete) o1;
        o2 = (Athlete) o2;

        if(athleteManager.timeConvertor(((Athlete) o1).getSkiTimeResult() + ((Athlete) o1).getTotalShootingResult()) > athleteManager.timeConvertor(((Athlete) o2).getSkiTimeResult()) + ((Athlete) o2).getTotalShootingResult()) {
            return -1;
        }

        return 1;
    }
}
