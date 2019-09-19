package unito.taas.project.user

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.validation.Valid

@RestController
@RequestMapping("/api")
class UserController (@Autowired private val userRepository: UserRepository) {

    @PostMapping("/users")
    fun getAllUsers(): ResponseEntity<MutableList<UserEntity>> =
        ResponseEntity.ok(userRepository.findAll())

    @PostMapping("/get-user")
    fun getUserById(@Valid @RequestParam id: Long) : ResponseEntity<Optional<UserEntity>> =
        ResponseEntity.ok(userRepository.findById(id))


    @PostMapping("/new-user")
    fun createNewUser(@Valid @RequestParam mailAddress: String,
                      @Valid @RequestParam password: String): ResponseEntity<UserEntity> =
            ResponseEntity.ok(userRepository.saveAndFlush(UserEntity(mailAddress = mailAddress, password = password)))


    @PostMapping("/update-user")
    fun updateUserById(@Valid @RequestParam id: Long,
                       @Valid @RequestParam password: String): ResponseEntity<UserEntity> {
        try {
            val user = userRepository.getOne(id)
            user.password = password
            return ResponseEntity.ok(userRepository.save(user))
        } catch (e: Exception) {
            throw UserExceptionHandler.UserNotFoundException()
        }
    }

    @PostMapping("/delete-user")
    fun deleteUserById(@Valid @RequestParam id: Long) {
        try {
            userRepository.deleteById(id)
        } catch (e: Exception) {
            throw UserExceptionHandler.UserNotFoundException()
        }
    }

}