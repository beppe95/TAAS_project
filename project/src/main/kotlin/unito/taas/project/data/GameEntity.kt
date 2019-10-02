package unito.taas.project.data

import javax.persistence.Id
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.validation.constraints.NotBlank

@Entity
class GameEntity(
        @Id @GeneratedValue val id: Long,
        @NotBlank val gameName: String,
        @NotBlank val availableModes: String,
        @NotBlank val image: String
)
