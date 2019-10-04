package unito.taas.project.data

import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
class TournamentEntity(
        @Id @GeneratedValue val id: Long,
        @NotBlank val playersNumber: Int,
        @NotBlank val tournamentDescription: String,
        @NotBlank val tournamentMode: String,
        @NotBlank val adminId: Long,
        @NotBlank @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "game") val game: GameEntity
)