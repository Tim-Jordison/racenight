package racenight

import com.enums.ChangeableNameDomainClassEnum
import grails.converters.JSON

class AjaxRenamingController {

    def index() {
        def model = [:]
        ChangeableNameDomainClassEnum domainClass = params.domainClass as ChangeableNameDomainClassEnum
        Long id = params.id as Long
        String newValue = params.newValue
        switch (domainClass){
            case ChangeableNameDomainClassEnum.RACE:
                Race race = Race.get(id)
                race.name = newValue
                race.save()
                break;
            case ChangeableNameDomainClassEnum.HORSE:
                Horse horse = Horse.get(id)
                horse.name = newValue
                horse.save()
                break;
            default:
                throw new IllegalArgumentException("Tried to rename property of invalid domain class. ${params.domainClass}")
        }

        model.newValue = newValue
        render model as JSON
    }
}
