package unito.taas.project.data

import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
class RegistrationEntity(
        @Id @GeneratedValue val id: Long,
        @NotBlank val userId: String,
        @NotBlank @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "match") val match: MatchEntity,
        @NotBlank val outcome: String
)