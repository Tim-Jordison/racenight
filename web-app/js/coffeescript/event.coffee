window.RACENIGHT = window.RACENIGHT || {};

RACENIGHT.delete = (raceid) ->
  console.log("Delete got called with id"+raceid)
  if (confirm("Are you sure you want to delete this?"))
    $.ajax
      url: "/race/delete?dateTAG=" + new Date().getTime()
      data: {id: raceid}
      error: (jqXHR, textStatus, errorThrown) ->
        console.log('ajax error')
      success: (data) ->
        if (data.success)
          race = $("#race-"+raceid)
          console.log(race)
          race.remove()




$(document).ready ->
  $(".add-race").on "click", ->
    $.ajax
      url: "/race/create?dateTAG=" + new Date().getTime()
      error: (jqXHR, textStatus, errorThrown) ->
        console.log('ajax error')
      success: (data) ->
        if (data.html)
          $(".races").append(data.html)
          $("#race-delete-"+data.raceId).on("click", -> RACENIGHT.delete(data.raceId))
          $("#add-horse-"+data.raceId).on("click", -> RACENIGHT.addHorse(data.raceId))
        else
          if (data.error)
            console.log("error")

$(".delete").on "click", ->
  RACENIGHT.delete($(this).attr("data-raceid"))




#          race.parentNode..removeChild(race)




#      RACENIGHT.ajaxRequest
#        controller: "race"
#        action: "create"
#        params: {name: name}
#        success: (data) ->
#          console.log("Got here a")
#          if (data.success)
#            console.log("Got here")
#            raceTable = document.getElementById("race-table")
#            row = raceTable.insertRow(0)
#            cell1 = row.insertCell(0)
#  #          cell2 = row.insertCell(1)
#            cell1.innerHTML = data.raceName
#          else
#            if (data.error)
#              console.log("error")


