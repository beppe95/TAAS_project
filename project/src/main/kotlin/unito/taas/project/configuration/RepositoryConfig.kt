package unito.taas.project.configuration

import org.springframework.context.annotation.Configuration
import org.springframework.data.rest.core.config.RepositoryRestConfiguration
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer
import unito.taas.project.data.GameEntity
import unito.taas.project.data.MatchEntity
import unito.taas.project.data.RegistrationEntity
import unito.taas.project.data.TournamentEntity
import kotlin.reflect.KClass


@Configuration
class RepositoryConfig : RepositoryRestConfigurer {
    override fun configureRepositoryRestConfiguration(config: RepositoryRestConfiguration): Unit = with(config) {
        exposeIdsFor(TournamentEntity::class, MatchEntity::class, RegistrationEntity::class, GameEntity::class)
    }

    private fun RepositoryRestConfiguration.exposeIdsFor(vararg kClasses: KClass<*>) =
            exposeIdsFor(*kClasses.map { it.java }.toTypedArray())
}
