package unito.taas.project

import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.ui.ModelMap
import org.springframework.ui.set
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import unito.taas.project.user.UserEntity

// https://stackoverflow.com/questions/8688135/modelattribute-annotation-when-to-use-it/26916920#26916920
// https://stackoverflow.com/questions/3423262/what-is-modelattribute-in-spring-mvc
/*
- @ModelAttribute (method): ADD attribute into the model on every request - for example from a database,
  especially when using @SessionAttributes.
- @ModelAttribute (parameter): retrieve argument from the model and get its value.
   If such does not exists, Spring creates an empty object using its defaults.
*/

@Controller
@ControllerAdvice
class ExampleModel {

    private val usersMap = HashMap<Long, UserEntity>()

    @ModelAttribute
    fun addEasterEgg(model: ModelMap) {
        model["easterEgg"] = UserEntity(42, "Babbo", "Natale")
    }

    @PostMapping("/model-user")
    fun modelUser(@ModelAttribute("easterEgg") user: UserEntity,
                      model: ModelMap, result: BindingResult): ResponseEntity<UserEntity?> {

        if (result.hasErrors()) throw Exception()
        usersMap[user.id!!] = user

        return ResponseEntity.ok(usersMap[user.id!!]!!)
    }
}