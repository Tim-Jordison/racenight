package racenight

class User {
    String username
    String password

    static constraints = {
        username unique: true, email: true, nullable: false
        password nullable: false
    }
}
