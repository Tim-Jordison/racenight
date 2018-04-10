window.RACENIGHT = window.RACENIGHT || {};

class Bet

  #this.find = (name) ->
  constructor: (name, raceId, horseId, count, horseName, horseNumber, raceName, tablePosition) ->
    @name = name
    @raceId = raceId
    @horseId = horseId
    @count = count
    @horseName = horseName
    @horseNumber = horseNumber
    @raceName = raceName
    @tablePosition = tablePosition

$(".horse-button").on "click", ->
  raceId = $(this).attr("data-raceId")
  horseId = $(this).attr("data-horseId")
  horseName = $(this).attr("data-horseName")
  horseNumber = $(this).attr("data-horseNumber")
  raceName = $(this).attr("data-raceName")
  name = raceId+"-"+horseId
  bet = window.bets[name]
  if (bet)
    bet.count += 1
  else
    bet = new Bet(name, raceId, horseId, 1, horseName, horseNumber, raceName, window.numberOfBets)
    window.numberOfBets = window.numberOfBets+1
  window.bets[name] = bet
  console.log(window.bets)
  table = document.getElementById("bets-table")
  rows = table.rows
  if (bet.count > 1)
    previousRow = rows[bet.tablePosition+1]
    cells = previousRow.cells
    cells[0].innerHTML = horseNumber+": "+horseName+" ("+raceName+")"
#    cells[0].innerHTML = horseName+"("+horseNumber+") / "+raceName
    cells[1].innerHTML = bet.count
  else
    row = table.insertRow(bet.tablePosition+1)
    row.innerHTML = "<td>"+horseNumber+": "+horseName+" ("+raceName+")</td><td>"+bet.count+"</td>"
#    row.innerHTML = "<td>"+horseName+"("+horseNumber+") / "+raceName+"</td><td>"+bet.count+"</td>"

  console.log("numberOfBets "+numberOfBets)
  if (window.total == 0)
    console.log("add total")
    window.total = window.total+1
    row = table.insertRow(numberOfBets+1)
    row.innerHTML = "<td>Total</td><td>"+window.total+"</td>"
    $(".create-ticket").removeClass("hidden")
  else
    console.log("total already exists")

    window.total = window.total+1
    rows[window.numberOfBets+1].cells[1].innerHTML = window.total

$(".create-ticket").on "click", ->
  if $(this).hasClass("disabled")
    console.log("easy")
  else
    $(this).addClass("disabled")
    $(this).innerHTML = "processing"
    ticketUUID = window.ticketUUID
    console.log(ticketUUID)
    $.ajax
      url: "/ticket/save?dateTAG=" + new Date().getTime()
      data: {bets: JSON.stringify(window.bets), ticketUUID: ticketUUID}
      error: (jqXHR, textStatus, errorThrown) ->
        console.log('ajax error')
      success: (data) ->
        if data.success
          console.log("here!!!")
          $(".create-button-div").removeClass("hidden")
          document.getElementById("ticket-confirm-replacement").innerHTML = data.html

$(document).ready ->
  window.bets = {}
  window.numberOfBets = 0
  window.total = 0
