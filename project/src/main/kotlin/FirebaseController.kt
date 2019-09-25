package unito.taas.project

import com.google.cloud.firestore.Firestore
import com.google.firebase.FirebaseApp
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import com.google.cloud.firestore.DocumentSnapshot
import com.google.cloud.firestore.QuerySnapshot
import com.google.api.core.ApiFuture
import org.springframework.core.convert.TypeDescriptor.collection
import org.springframework.web.bind.annotation.RequestMapping

@RestController
// @RequestMapping("/api/")
class FirebaseController(@Autowired private val app: FirebaseApp,
                         @Autowired val firestore: Firestore) {

    @GetMapping("get-collection/{collection}", produces = ["application/json"])
    fun getCollection(@PathVariable collection: String): ResponseEntity<Any> {
        val future = firestore.collection(collection).get()
        val documents = future.get().documents

        val responseBody = arrayListOf<Any>()
        for (document in documents) {
            responseBody.add(HashMap(document.data).apply {
                this[collection + "_id"] = document.id })
        }
        return ResponseEntity.ok(responseBody)
    }


    @GetMapping("get-available/{collection}", produces = ["application/json"])
    fun getAvailable (@PathVariable collection: String): ResponseEntity<ArrayList<Any>> {
        val collectionRef = firestore.collection(collection)
        val query = collectionRef.whereGreaterThan("players_number", 0)
        val querySnapshot = query.get()

        val responseBody = arrayListOf<Any>()
        for (document in querySnapshot.get().documents) {
            responseBody.add(HashMap(document.data).apply {
                this[collection + "_id"] = document.id })
        }
        return ResponseEntity.ok(responseBody)
    }
}