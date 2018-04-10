package racenight

class MoneyTagLib {
//    static defaultEncodeAs = [taglib:'html']
    static namespace = "racenight"
    //static encodeAsForTags = [tagName: [taglib:'html'], otherTagName: [taglib:'none']]
    def displayDollarsAndCentsFromCents = { attrs, body ->
        if (attrs.cents) {
            out << "\$"+String.format("%.2f", (attrs.cents / 100));
        }
        else {
            out << "\$0.00";
        }

    }

    def displayDollarsRounderDownToQuarterFromCents = { attrs, body ->
        if (attrs.cents) {
            float inDollars = (attrs.cents / 100f)
            float rounded = Math.round(inDollars*4)/4f
            out << "\$"+String.format("%.2f", rounded);
        }
        else {
            out << "\$0.00";
        }

    }
}
