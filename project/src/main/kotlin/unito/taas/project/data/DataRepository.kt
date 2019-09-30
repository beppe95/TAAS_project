package unito.taas.project.data

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource
interface TournamentRepository : JpaRepository<TournamentEntity, Long>

@RepositoryRestResource
interface MatchRepository : JpaRepository<MatchEntity, Long>
/*
@RepositoryRestResource
interface RegistrationRepository : JpaRepository<RegistrationEntity, Long>

 */

@RepositoryRestResource
interface GameRepository : JpaRepository<GameEntity, Long>

