package unito.taas.project.user

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.validation.constraints.NotBlank

//@ManyToOne, @OneToMany

@Entity
data class
UserEntity (
        @Id @NotBlank @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = 0,

        @get: NotBlank var mailAddress: String,

        @get: NotBlank var password: String
)