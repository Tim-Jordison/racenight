package racenight

class Event {
    String name
    String password
    Float payoutRate
    Long betPriceInCents
    String uuid = UUID.randomUUID().toString()
    Date dateCreated

    static constraints = {
        name nullable: false, unique: true
        password nullable: false
        payoutRate max: 1.0F, min: 0.0F, nullable: false
        betPriceInCents nullable: false
        uuid nullable: false
    }
}
