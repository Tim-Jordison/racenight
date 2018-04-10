package racenight

class Horse {
    String name
    String jockeyName
    Integer number
    static belongsTo = [race: Race]
    Integer placement

    static constraints = {
        name nullable: false
        jockeyName nullable: true
        number nullable: false, unique: 'race'
        race nullable: false
        placement nullable: true
    }
}
