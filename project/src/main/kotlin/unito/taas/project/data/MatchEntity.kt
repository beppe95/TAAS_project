package unito.taas.project.data

import org.springframework.format.annotation.DateTimeFormat
import java.time.LocalDateTime
import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
class MatchEntity(
        @Id @GeneratedValue val id: Long,
        @NotBlank @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") val matchDateTime: LocalDateTime,
        @NotBlank @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "tournament") val tournament: TournamentEntity
)