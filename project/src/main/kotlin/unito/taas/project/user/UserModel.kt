package unito.taas.project.user

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import javax.validation.Valid
import org.springframework.http.HttpStatus
import unito.taas.project.exceptions_handler.UserNotFoundException
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.validation.constraints.NotBlank

@Service
data class UserModel (
        @Id @NotBlank @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = 0,

        @get: NotBlank
        val mailAddress: String = "",

        @get: NotBlank
        val password: String = "")  {

    @Autowired
    private lateinit var userRepository: UserRepository

    fun createNewUser(@Valid @RequestParam mailAddress: String,
                      @Valid @RequestParam password: String): UserEntity {
        return userRepository.save(UserEntity(null, mailAddress, password))
    }

    fun updateUserById(@Valid @RequestParam id: Long,
                       @Valid @RequestBody newUserEntity: UserEntity): ResponseEntity<UserEntity> {
        return userRepository.findById(id).map { existingUser ->
            val updatedUserEntity: UserEntity =
                    existingUser.copy(mailAddress = newUserEntity.mailAddress, password = newUserEntity.password)
            ResponseEntity.ok().body(userRepository.save(updatedUserEntity))
        }.orElse(ResponseEntity.notFound().build())
    }

    fun deleteUserById(@Valid @RequestParam id: Long): ResponseEntity<Void> {
        return userRepository.findById(id).map { user ->
            userRepository.delete(user)
            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())
    }


    fun getUserById(@Valid @RequestParam id: Long): ResponseEntity<UserEntity> {
        if (!userRepository.findById(id).isPresent) throw UserNotFoundException()
        return userRepository.findById(id).map { user ->
            ResponseEntity.ok(user)
        }.orElse(ResponseEntity.notFound().build())
    }

    fun findAllUsers(): Iterable<UserEntity> = userRepository.findAll()

}