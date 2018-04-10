<div class="race-container">
    <div class="race-heading">
        <span class="button add-horse" id="add-horse-${race.id}">add horse</span>
        %{--<span class="race-button add-eight" data-raceid="${race.id}">+8</span>--}%
        <span class="button set-winner">reset winners</span>
    </div>

    <table class="pretty-table" id="horse-table-race">
        <thead>
            <tr>
                <th>Number</th>
                <th>Name</th>
                <th>Position</th>
            </tr>
        </thead>
        <tbody>

        <g:each in="${horses}" var="horse">
            <tr>
                <g:render template="/includes/horse" model="${[horse: horse, race: race]}"/>
            </tr>
        </g:each>
        </tbody>
    </table>
    <g:if test="${race.finished}">
        Results have been locked.
    </g:if>
    <g:else>
        <a class="button blue lock-race">Lock results</a>
    </g:else>
</div>