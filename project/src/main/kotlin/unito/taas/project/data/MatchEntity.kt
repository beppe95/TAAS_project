package unito.taas.project.data

import java.util.*
import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
class MatchEntity(
        @Id @GeneratedValue val id: Long,
        @NotBlank val matchDateTime: Date,
        @NotBlank @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "tournament_id") val tournamentInvolved: TournamentEntity
)