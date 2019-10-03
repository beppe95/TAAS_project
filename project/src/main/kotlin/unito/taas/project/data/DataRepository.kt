package unito.taas.project.data

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.query.Param
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import org.springframework.data.rest.core.annotation.RestResource
import org.springframework.format.annotation.DateTimeFormat
import java.time.Instant
import java.time.LocalDateTime
import java.util.*

@RepositoryRestResource(path = "tournament")
interface TournamentRepository : JpaRepository<TournamentEntity, Long>

@RepositoryRestResource(path = "registration")
interface RegistrationRepository : JpaRepository<RegistrationEntity, Long>

@RepositoryRestResource(path = "game")
interface GameRepository : JpaRepository<GameEntity, Long> {
    @RestResource(path="byName")
    fun findGameEntitiesByGameName(gameName: String) : List<GameEntity>
    // http://localhost:8080/game/search/byName?gameName=CS
}

@RepositoryRestResource(path = "match")
interface MatchRepository : JpaRepository<MatchEntity, Long> {

    @RestResource(path="availableMatches")
    fun findMatchEntitiesByMatchDateTimeIsAfterAndTournamentInvolved_PlayersNumberGreaterThan(@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") matchDateTime: LocalDateTime, tournamentInvolved_playersNumber: Int) : List<MatchEntity>
    // http://localhost:8080/match/search/availableMatches?matchDateTime=1977-12-03T11:15:30&tournamentInvolved_playersNumber=1


    @RestResource(path="byMatchDateTimeIsAfter")
    fun findMatchEntitiesByMatchDateTimeIsAfter(@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") matchDateTime: LocalDateTime) : List<MatchEntity>
    // http://localhost:8080/match/search/byMatchDateTimeIsAfter?matchDateTime=1977-12-03T11:15:30

    @RestResource(path="byPlayersNumberGreaterThan")
    fun findMatchEntitiesByTournamentInvolved_PlayersNumberGreaterThan(tournamentInvolved_playersNumber: Int) : List<MatchEntity>
    //http://localhost:8080/match/search/byPlayersNumberGreaterThan?tournamentInvolved_playersNumber=33

}
