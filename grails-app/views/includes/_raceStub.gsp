<div class="race-container ${raceBean.race.finished ? "finished" : ""}" id="race-${raceBean.race.id}">
    <div class="race-heading">
        <g:link class="text-link" controller="race" action="index" id="${raceBean.race.id}">${raceBean.race.name}</g:link>
        <span class="delete" id="race-delete-${raceBean.race.id}" data-raceid="${raceBean.race.id}">delete</span>
        <hr>
        This race has ${raceBean.horseCount} horses.
        <br>
        <g:if test="${raceBean.race.finished}">
            Results: ${raceBean.horsesPlacements}
        </g:if>
        <g:else>
            Not yet finished
        </g:else>
    </div>
</div>