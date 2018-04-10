    <td>
        <div>${horse.number}</div>
    </td>
    <td>
        <span class="renamer-field" data-class="${com.enums.ChangeableNameDomainClassEnum.HORSE}" data-id="${horse.id}">${horse.name}</span>
    </td>
    <g:if test="${race.finished}">
        <td>${horse.placement ?: "dnf"}</td>
    </g:if>
    <g:else>
        <td><span class="placement" id="${horse.id}-placement-id">${horse.placement ?: "not set"}</span> <input type="checkbox" id="${horse.id}-checkbox" name="set-winner-check-box" data-horsename="${horse.name}" data-horseid="${horse.id}" class="winner-checkbox ${horse.placement ? "hidden" : ""}"/></td>
    </g:else>