package unito.taas.project.unito.taas.project

import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserInfo
import com.google.firebase.auth.UserRecord
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import com.google.firebase.auth.UserRecord.CreateRequest
import org.springframework.web.bind.annotation.RequestParam
import com.google.firebase.auth.ExportedUserRecord




@RestController
class AuthenticationController(@Autowired private val app: FirebaseApp,
                               @Autowired val auth: FirebaseAuth) {


    @PostMapping("create-user/", produces = ["application/json"])
    fun createUser(@RequestParam email: String,
                   @RequestParam password: String,
                   @RequestParam nickname: String,
                   @RequestParam photoURL: String): Array<out UserInfo>? =

            auth.createUser(CreateRequest()
                            .setEmail(email)
                            .setPassword(password)
                            .setDisplayName(nickname)
                            .setPhotoUrl(photoURL)).providerData
}