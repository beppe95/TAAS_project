package unito.taas.project.user

import javax.persistence.*
import javax.validation.constraints.NotBlank

@Entity
data class UserEntity(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null,

        @NotBlank @Column(unique=true)
        val mailAddress: String,

        @NotBlank
        var password: String
)