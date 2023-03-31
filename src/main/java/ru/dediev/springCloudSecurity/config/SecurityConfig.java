package ru.dediev.springCloudSecurity.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.dediev.springCloudSecurity.model.entity.Permission;
import ru.dediev.springCloudSecurity.model.entity.Role;
import ru.dediev.springCloudSecurity.security.JwtConfigurer;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final JwtConfigurer jwtConfigurer;

    public SecurityConfig(JwtConfigurer jwtConfigurer) {
        this.jwtConfigurer = jwtConfigurer;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/**").hasRole(Role.ADMIN.name())
                .antMatchers("/api/v1/auth/login").permitAll()
                .antMatchers("/api/v1/filestorage/**").permitAll()
                .antMatchers("/api/v1/users/delete/**").hasAuthority(Permission.DEVELOPERS_WRITE.getPermission())
                .antMatchers("/api/v1/users/get/**").hasAuthority(Permission.DEVELOPERS_WRITE.getPermission())
                .antMatchers("/api/v1/users/getall/").hasAuthority(Permission.DEVELOPERS_READ.getPermission())
                .antMatchers("/api/v1/users/register/").hasAuthority(Permission.DEVELOPERS_READ.getPermission())
                .anyRequest()
                .authenticated()
                .and()
                .apply(jwtConfigurer);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    protected PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }
}
