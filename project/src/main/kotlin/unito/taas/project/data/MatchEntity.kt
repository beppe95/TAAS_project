package unito.taas.project.data

import java.util.*
import javax.persistence.*

@Entity
class MatchEntity (@Id @GeneratedValue val id: Long,
                   val matchDateTime: Date,
                   @ManyToOne(fetch= FetchType.LAZY) @JoinColumn(name="tournament_id") val tournamentInvolved: TournamentEntity)