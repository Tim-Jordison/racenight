package com.helperbeans

import racenight.Race

/**
 * Created by coop2 on 2015-10-12.
 */
class RaceStubBean {
    Race race
    Long horseCount
    String horsesPlacements

    public RaceStubBean(Race race, Long horseCount, String horsesPlacements) {
        this.race = race
        this.horseCount = horseCount
        this.horsesPlacements = horsesPlacements
    }
}
