package unito.taas.project

import com.google.cloud.firestore.Firestore
import com.google.firebase.FirebaseApp
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController


@RestController
class FirebaseController(@Autowired private val app: FirebaseApp,
                         @Autowired val firestore: Firestore) {

    @GetMapping("/db/{collection}", produces = ["application/json"])
    fun db(@PathVariable collection: String): ResponseEntity<Any> {
        val future = firestore.collection(collection).get()
        val documents = future.get().documents

        val responseBody = arrayListOf<Any>()
        for (document in documents) {
            responseBody.add(HashMap(document.data).apply {
                this[collection + "_id"] = document.id })
        }
        return ResponseEntity.ok(responseBody)
    }
}