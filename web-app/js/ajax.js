// Generated by CoffeeScript 1.9.3
(function() {
  window.RACENIGHT = window.RACENIGHT || {};

  RACENIGHT.ajaxQueues = {};

  RACENIGHT.ajaxRequest = function(args) {
    console.log("BLAH");
    return $.ajax({
      url: args.controller + "/" + args.action + "?dateTAG=" + new Date().getTime(),
      data: args.params
    }, console.log("SOMETING HERE???"), {
      error: function(jqXHR, textStatus, errorThrown) {
        return console.log('ajax error');
      },
      success: args.success
    });
  };

}).call(this);
