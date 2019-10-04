package unito.taas.project.data

import javax.persistence.Entity
import javax.persistence.Id
import javax.validation.constraints.NotBlank

@Entity
class GameEntity(
        @Id @NotBlank val gameName: String,
        @NotBlank val availableModes: String,
        @NotBlank val image: String
)
