window.RACENIGHT = window.RACENIGHT || {};


$(document).on "click",".renamer-field", ->
#$(".renamer-field").on "click", ->
  console.log(this.innerHTML)
  newValue = prompt("Rename field", this.innerHTML);
  domainClass = $(this).attr("data-class")
  id = $(this).attr("data-id")
  console.log(domainClass)
  console.log(newValue)
  console.log(id)
  element = this
  if (newValue)
    $.ajax
      url: "/ajaxRenaming/index?dateTAG=" + new Date().getTime()
      data: {newValue: newValue, domainClass: domainClass, id: id}
      error: (jqXHR, textStatus, errorThrown) ->
        console.log('ajax error')
      success: (data) ->
        if (data.newValue)
          console.log("here newValue = "+data.newValue)
          element.innerHTML = data.newValue
        else
          console.log("error")