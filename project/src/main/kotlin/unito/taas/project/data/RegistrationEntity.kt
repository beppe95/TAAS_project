package unito.taas.project.data

import javax.persistence.*


@Entity
class RegistrationEntity(
        @Id @GeneratedValue val id: Long,
        val userId: Long,
        @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "tournament_id") val matchId: MatchEntity,
        val outcome: String
)