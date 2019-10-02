package unito.taas.project.data

import javax.persistence.Id
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.validation.constraints.NotBlank

@Entity
class TournamentEntity(
        @Id @GeneratedValue val id: Long,
        @NotBlank val playersNumber: Int,
        @NotBlank val tournamentDescription: String,
        @NotBlank val tournamentMode: String,
        @NotBlank val adminId: Long
)