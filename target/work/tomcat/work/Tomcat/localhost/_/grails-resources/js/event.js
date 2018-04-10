// Generated by CoffeeScript 1.9.3
(function() {
  window.RACENIGHT = window.RACENIGHT || {};

  RACENIGHT["delete"] = function(raceid) {
    console.log("Delete got called with id" + raceid);
    if (confirm("Are you sure you want to delete this?")) {
      return $.ajax({
        url: "/race/delete?dateTAG=" + new Date().getTime(),
        data: {
          id: raceid
        },
        error: function(jqXHR, textStatus, errorThrown) {
          return console.log('ajax error');
        },
        success: function(data) {
          var race;
          if (data.success) {
            race = $("#race-" + raceid);
            console.log(race);
            return race.remove();
          }
        }
      });
    }
  };

  $(document).ready(function() {
    return $(".add-race").on("click", function() {
      return $.ajax({
        url: "/race/create?dateTAG=" + new Date().getTime(),
        error: function(jqXHR, textStatus, errorThrown) {
          return console.log('ajax error');
        },
        success: function(data) {
          if (data.html) {
            $(".races").append(data.html);
            $("#race-delete-" + data.raceId).on("click", function() {
              return RACENIGHT["delete"](data.raceId);
            });
            return $("#add-horse-" + data.raceId).on("click", function() {
              return RACENIGHT.addHorse(data.raceId);
            });
          } else {
            if (data.error) {
              return console.log("error");
            }
          }
        }
      });
    });
  });

  $(".delete").on("click", function() {
    return RACENIGHT["delete"]($(this).attr("data-raceid"));
  });

}).call(this);