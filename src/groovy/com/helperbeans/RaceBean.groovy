package com.helperbeans
import racenight.Horse
import racenight.Race

public class RaceBean {
    Race race
    List<Horse> horses

    public RaceBean(Race race, List<Horse> horses) {
        this.race = race
        this.horses = horses
    }
}
