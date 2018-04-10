window.RACENIGHT = window.RACENIGHT || {};

RACENIGHT.ajaxQueues = {}

RACENIGHT.ajaxRequest = (args) ->
  console.log("BLAH")
  $.ajax
    url: args.controller+"/" + args.action + "?dateTAG=" + new Date().getTime()
    data: args.params
    console.log("SOMETING HERE???")
    error: (jqXHR, textStatus, errorThrown) ->
      console.log('ajax error')
    success: args.success