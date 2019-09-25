package unito.taas.project.unito.taas.project

import com.google.firebase.auth.FirebaseAuthException
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class UserExceptionHandler {

    @ExceptionHandler(FirebaseAuthException::class)
    fun authExceptionHandler(e: FirebaseAuthException): ResponseEntity<String> {
        return ResponseEntity.badRequest().body(e.errorCode)
    }
}