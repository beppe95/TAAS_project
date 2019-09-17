package unito.taas.project

import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.Mockito.verify
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager

import unito.taas.project.user.UserModel

@DataJpaTest
class ReposTest @Autowired constructor(
        val entityManager: TestEntityManager) {

    @Test
    fun `Check insert user`() {
        val userModel = Mockito.mock(UserModel::class.java)
        userModel.createNewUser("mockuser@gmail.com", "mockpwd")
        verify(userModel).createNewUser("mockuser@gmail.com", "mockpwd")
    }

    /***@Test
    fun `Check update user`() {
    val mockUser1 = UserEntity(null, "mockuser@gmail.com", "mockpwd")
    entityManager.persistAndFlush(mockUser1)

    val newPWD = "new_mockpwd"
    user

    }

    @Test
    fun `Check delete user`() {
    println("TODO")
    }

    @Test
    fun `Check get user by id`() {
    val mockUser1 = UserEntity(null, "mockuser@gmail.com", "mockpwd")
    entityManager.persistAndFlush(mockUser1)
    val mockUser2 = userRepository.findById(mockUser1.id!!).get()
    assertThat(mockUser1).isEqualTo(mockUser2)
    }

    @Test
    fun `Check get all user`() {
    val usersList = arrayListOf<UserEntity>(
    UserEntity(null, "mockuser1@gmail.com", "mockpwd1"),
    UserEntity(null, "mockuser2@gmail.com", "mockpwd2"),
    UserEntity(null, "mockuser3@gmail.com", "mockpwd3"),
    UserEntity(null, "mockuser4@gmail.com", "mockpwd4"))

    usersList.forEach{entityManager.persistAndFlush(it)}

    val gotList = userRepository.findAll()
    assertThat(gotList).isEqualTo(usersList)
    }***/
}