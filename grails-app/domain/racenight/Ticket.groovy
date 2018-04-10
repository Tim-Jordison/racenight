package racenight

class Ticket {

    String uuid
    static hasMany = [horseBets: Bet]
    Long priceInCents
    Boolean cashedIn = false
    Date dateCashedIn
    Boolean active = false
    Date dateActivated
    Event event
    Long payoutInCents


    static constraints = {
        uuid nullable: false, unique: true
        event nullable: false
        priceInCents nullable: true
        horseBets nullable: true
        dateCashedIn nullable: true
        dateActivated nullable: true
        payoutInCents nullable: true

    }
}
