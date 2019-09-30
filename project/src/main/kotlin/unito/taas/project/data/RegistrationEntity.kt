package unito.taas.project.data

import java.io.Serializable
import javax.persistence.Entity
import javax.persistence.IdClass
import org.springframework.data.annotation.Id

/*
@Entity
@IdClass(RegistrationId::class)
class RegistrationEntity (@Id val userId: Long,
                          @Id val matchId: Long,
                          val outcome: String)

private class RegistrationId
(private val userId: Long, private val matchId: Long) : Serializable
*/