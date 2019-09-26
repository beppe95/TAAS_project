package unito.taas.project

import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserInfo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import com.google.firebase.auth.UserRecord.CreateRequest
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam


@RestController
class AuthenticationController(@Autowired private val app: FirebaseApp,
                               @Autowired val auth: FirebaseAuth) {


    // tenere pwd? + spiegazione https://github.com/firebase/firebaseui-web/issues/122

    @PostMapping("create-user/", produces = ["application/json"])
    fun createUser(@RequestParam email: String,
                   @RequestParam password: String,
                   @RequestParam nickname: String,
                   @RequestParam photoURL: String): Array<out UserInfo>? {

        val user = auth.createUser(CreateRequest()
                                    .setEmail(email)
                                    .setPassword(password)
                                    .setDisplayName(nickname)
                                    .setPhotoUrl(photoURL)).providerData

        auth.generateEmailVerificationLink(email)

        return user
    }

    @GetMapping("reset-user-password/", produces = ["application/json"])
    fun resetUserPassword(): String? {

        // confrontare uid e mail

        return auth.generatePasswordResetLink("cesareiurlaro@gmail.com")
    }


}