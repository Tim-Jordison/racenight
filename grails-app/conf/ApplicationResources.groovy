modules = {

    base {
        resource url: 'css/baseLayout.css'
        dependsOn 'jquery'
    }

    oddsTable {
        resource url: 'js/oddsTable.js'
        resource url: 'css/oddsTable.css'
    }

    table {
        resource url: 'css/table.css'
    }

    renamer {
        resource url: 'js/renamer.js'
        resource url: 'css/renamer.css'
    }

    ajax {
        resource url: 'js/ajax.js'
    }

    homescreen {
        resource url: 'css/homescreen.css'
    }

    event {
        dependsOn("ajax, renamer, table")
        resource url: 'js/event.js'
        resource url: 'css/event.css'

    }

    ticket {
        dependsOn("ajax, renamer, table")
        resource url: 'css/ticket.css'
        resource url: 'js/ticket.js'
        resource url: 'css/event.css'
    }

    printSources {
        resource url: 'css/print.css'
    }

    races {
        dependsOn("ajax, renamer, table")
        resource url: 'js/race.js'
        resource url: 'css/race.css'
    }
}