package unito.taas.project.data

import com.google.api.client.util.DateTime
import org.springframework.format.annotation.DateTimeFormat
import java.time.Instant
import java.time.LocalDateTime
import java.util.*
import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
class MatchEntity(
        @Id @GeneratedValue val id: Long,
        @NotBlank val matchDateTime: LocalDateTime,
        @NotBlank @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "tournament_id") val tournamentInvolved: TournamentEntity
)