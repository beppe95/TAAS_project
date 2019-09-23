package unito.taas.project.model

/*
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service
import unito.taas.project.user.UserPrincipalDetails
import unito.taas.project.user.UserRepository


@Service
class UserPrincipalDetailsService(private val userRepository: UserRepository) : UserDetailsService {

    override fun loadUserByUsername(username: String): UserDetails {
        val id = username.toLong()
        val user = this.userRepository.findById(id)

        return UserPrincipalDetails(user.get())
    }
}

 */