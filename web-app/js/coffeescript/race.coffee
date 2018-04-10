window.RACENIGHT = window.RACENIGHT || {};

RACENIGHT.addHorse = () ->
  raceId = window.raceId
  console.log("Add horse got called with id"+raceId)
  $.ajax
    url: "/race/addHorse?dateTAG=" + new Date().getTime()
    data: {id: raceId}
    error: (jqXHR, textStatus, errorThrown) ->
      console.log('ajax error')
    success: (data) ->
      if (data.success)
        race = $("#race-"+raceId)
        table = document.getElementById("horse-table-race")
        row = table.insertRow(data.horseNumber-1)
        row.innerHTML = data.html

$(".add-horse").on "click", ->
  RACENIGHT.addHorse()

$(".set-winner").on "click", ->

  console.log($(".placement"))

  if confirm("This will reset the placements for the race. Are you sure you want to continue?")
    $.ajax
      url: "/race/resetPlacements?dateTAG=" + new Date().getTime()
      data: {raceId: raceId}
      error: (jqXHR, textStatus, errorThrown) ->
        console.log('ajax error')
      success: (data) ->
        if (data.success)
          placementNumbers = $(".placement")
          placementNumbers.each ->
            $(@)[0].innerHTML = ""
            $(@).parent().find(":checkbox").prop("checked", false);
            console.log($(@).parent().find(":checkbox"))


          $(".winner-checkbox").removeClass("hidden")
          window.placedHorses = 0
        else
          alert ("Cannot reset placements because the race results have been locked.")

$(".winner-checkbox").on "click", ->
  horseId = $(this).attr("data-horseid")
  placement = window.placedHorses + 1
  $.ajax
    url: "/race/setHorsePlacement?dateTAG=" + new Date().getTime()
    data: {placement: placement, horseId: horseId, raceId: window.raceId}
    error: (jqXHR, textStatus, errorThrown) ->
      console.log('ajax error')
    success: (data) ->
      if (data.success)
        document.getElementById(horseId+"-placement-id").innerHTML = placement
        $("#"+horseId+"-checkbox").addClass("hidden")
        window.placedHorses = placement
      else
        alert("The race results have been locked.")

$(".lock-race").on "click", ->
  if !$(this).hasClass("disabled")
    if confirm("Are you sure you want to lock the results for the race?")
      $.ajax
        url: "/race/lockResults?dateTAG=" + new Date().getTime()
        data: {raceId: window.raceId}
        error: (jqXHR, textStatus, errorThrown) ->
          console.log('ajax error')
        success: (data) ->
          if (data.success)
            $(".lock-race").addClass("disabled")#[0].innerHTML = "LOCKED"
            $(".lock-race")[0].innerHTML = "LOCKED"
            $(".winner-checkbox").addClass("hidden")
          else
            alert("Failed to lock race.")