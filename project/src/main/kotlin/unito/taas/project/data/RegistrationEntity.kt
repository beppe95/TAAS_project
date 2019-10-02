package unito.taas.project.data

import javax.persistence.*
import javax.validation.constraints.NotBlank


@Entity
class RegistrationEntity(
        @Id @GeneratedValue val id: Long,
        @NotBlank val userId: Long,
        @NotBlank @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "tournament_id") val matchId: MatchEntity,
        @NotBlank val outcome: String
)