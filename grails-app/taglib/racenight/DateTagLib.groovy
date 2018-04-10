package racenight

class DateTagLib {
    static namespace = "racenight"

    def dateAndTime = {attrs, body ->
        if (attrs.date) {
            out << attrs.date.format("EEEE, MMMM d, yyyy h:mm a");
        }
        else {
            out << "";
        }
    }
}
