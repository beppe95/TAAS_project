package unito.taas.project.model


/*
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.authentication.dao.DaoAuthenticationProvider
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity


@Configuration
@EnableWebSecurity
class SecurityConfiguration(private val userPrincipalDetailsService: UserPrincipalDetailsService) : WebSecurityConfigurerAdapter() {

    override fun configure(auth: AuthenticationManagerBuilder) {
        auth.authenticationProvider(authenticationProvider())
    }

    override fun configure(http: HttpSecurity) {
        http.authorizeRequests()
            .antMatchers("/index.html").permitAll()
            .antMatchers("/profile/**").authenticated()
            .antMatchers("/admin/**").hasRole("ADMIN")
            .antMatchers("/management/**").hasAnyRole("ADMIN", "MANAGER")
            .antMatchers("/api/public/test1").hasAuthority("ACCESS_TEST1")
            .antMatchers("/api/public/test2").hasAuthority("ACCESS_TEST2")
            .antMatchers("/api/public/users").hasRole("ADMIN")
            .and()
            .httpBasic()
    }

    @Bean
    internal fun authenticationProvider(): DaoAuthenticationProvider {
        val daoAuthenticationProvider = DaoAuthenticationProvider()
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder())
        daoAuthenticationProvider.setUserDetailsService(this.userPrincipalDetailsService)

        return daoAuthenticationProvider
    }

    @Bean internal fun passwordEncoder(): PasswordEncoder = BCryptPasswordEncoder()
}

 */