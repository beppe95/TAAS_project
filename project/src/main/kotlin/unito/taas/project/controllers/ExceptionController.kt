package unito.taas.project.controllers

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.NoHandlerFoundException


@Controller
class UserExceptionHandler {


//    @ExceptionHandler(NoHandlerFoundException::class)
//    fun authExceptionHandler(request: HttpServletRequest?, response: HttpServletResponse?): RedirectView? {
//
//    }


    @ExceptionHandler(Exception::class)
    fun handleMyException(): String =
            "/"


}