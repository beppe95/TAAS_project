package unito.taas.project.data

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource
import java.util.*

@RepositoryRestResource(path="tournament")
interface TournamentRepository : JpaRepository<TournamentEntity, Long>

@RepositoryRestResource(path="match")
interface MatchRepository : JpaRepository<MatchEntity, Long>

@RepositoryRestResource(path="registration")
interface RegistrationRepository : JpaRepository<RegistrationEntity, Long>

@RepositoryRestResource(path="game")
interface GameRepository : JpaRepository<GameEntity, Long>

/*

 POST localhost:8080/tournament?id=1&playersNumber=13&tournamentDescription=qew&tournamentMode=qwe&adminId=1313 (header json/application)

localhost:8080/?id=42&matchDateTime=2019-10-02T13:57:22.184+0000&tournamentInvolved=qwe
* */
