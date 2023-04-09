package org.example;

import org.junit.jupiter.api.Test;

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

}