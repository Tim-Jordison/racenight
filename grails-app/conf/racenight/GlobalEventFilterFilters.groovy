package racenight

class GlobalEventFilterFilters {

    def filters = {
        all(controller:'*', action:'*') {
            before = {
                String uuid = session.getValue("eventUUID")
                if (!uuid){
                    if (controllerName != "events" && controllerName != null) {
                        redirect(uri: '/')
                        return
                    } else if (controllerName == null){
                        return
                    } else if (!(actionName == "create" || actionName == "list" || actionName == "save" || actionName == "loginToEvent")){
                        redirect(controllerName:'events', action: 'loginToEvent')
                        return
                    } else {
                        System.out.println("Continue to page")
                        return
                    }
                } else {
                    params.EVENTUUID = uuid
                    return
                }
            }
            after = { Map model ->
                params.EVENTUUID = session.getValue("eventUUID")
                return
            }
//            afterView = { Exception e ->
//
//            }
        }
    }
}
