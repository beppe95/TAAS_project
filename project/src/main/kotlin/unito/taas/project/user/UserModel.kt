package unito.taas.project.user

import org.springframework.stereotype.Service

@Service
class UserModel{
    /*
    * @ModelAttribute methods are invoked before the controller methods annotated with @RequestMapping are invoked.
    * The logic behind the sequence is that, the model object has to be created before any processing starts inside
    * the controller methods.
    * It is also important that you annotate the respective class as @ControllerAdvice.
    * Thus, you can add values in Model which will be identified as global.
    * */
}