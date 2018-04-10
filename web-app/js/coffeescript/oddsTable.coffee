window.RACENIGHT = window.RACENIGHT || {};

RACENIGHT.getDisplayableOddsTable = () ->
  $.ajax
    url: "/race/getOddsAndPayout?dateTAG=" + new Date().getTime()
    data: {id: window.raceId, previousBetCount: window.previousBetCount, firstCall: window.firstCall}
    error: (jqXHR, textStatus, errorThrown) ->
      console.log('ajax error')
    success: (data) ->
      if (data.html)
        $(".odds-table").html(data.html)
        window.firstCall = false



$(document).ready ->
  window.previousBetCount = 0
  window.firstCall = true
  RACENIGHT.getDisplayableOddsTable()
  setInterval () ->
    RACENIGHT.getDisplayableOddsTable()
  , window.updateInterval





