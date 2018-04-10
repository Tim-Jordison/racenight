package racenight

class Race {
    String name
    Boolean finished
    Date dateFinished
    String s3ImageLocation
    static belongsTo = [event: Event]

    static constraints = {
        dateFinished nullable: true
        s3ImageLocation nullable: true
    }
}
