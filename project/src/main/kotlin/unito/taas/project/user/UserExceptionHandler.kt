package unito.taas.project.user

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException
import org.hibernate.exception.ConstraintViolationException
import javax.persistence.EntityNotFoundException

@ControllerAdvice
class UserExceptionHandler {

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    class UserNotFoundException : EntityNotFoundException()

    @ExceptionHandler(ConstraintViolationException::class)
    fun constraintViolationHandler(e: ConstraintViolationException): ResponseEntity<*> {
        return ResponseEntity
                .status(HttpStatus.FORBIDDEN)
                .body("Constraints Involved. Pay Attention To The Parameters")
    }

    @ExceptionHandler(UserNotFoundException::class)
    fun userNotFoundHandler(): ResponseEntity<*> {
        return ResponseEntity
                .status(HttpStatus.FORBIDDEN)
                .body("Custom 404 Page")
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException::class)
    fun methodArgumentTypeMismatchHandler(e: MethodArgumentTypeMismatchException): ResponseEntity<*> {
        return ResponseEntity
                .status(HttpStatus.FORBIDDEN)
                .body("Operation Not Allowed")
    }
}