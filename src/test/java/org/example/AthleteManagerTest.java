package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AthleteManagerTest {

    @Test
    void createOneAthleteWithInvalidInput() {
        AthleteManager athleteManager = new AthleteManager();
        String input = "98412jdi21jdu21idj21iu4u, 9315198hfjiaskjfoi";

        assertThrows(InputException.class, () -> athleteManager.createAthlete(input));
    }

    @Test
    void createOneAthleteWithEmptyInput() {
        AthleteManager athleteManager = new AthleteManager();
        String input = "";

        assertThrows(InputException.class, () -> athleteManager.createAthlete(input));
    }

    @Test
    void createTwoAthleteAndSortByFinalStanding() throws InputException {
        AthleteManager athleteManager = new AthleteManager();

        Athlete athlete1 = new Athlete("27","Piotr Smitzer","CZ","30:10","xxxxx","xxxxx","xxxxx");
        Athlete athlete2 = new Athlete("11","Umar Jorgson","SK","30:27","xxxox","xxxxx","xxoxo");


        athleteManager.athleteList.add(athlete1);
        athleteManager.athleteList.add(athlete2);

        athleteManager.athleteList.sort(new AthleteComparator());

        assertEquals(athlete1.getFinalStanding(), athleteManager.athleteList.get(0).getFinalStanding());
    }


}