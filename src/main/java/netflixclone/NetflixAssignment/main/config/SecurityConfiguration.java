package netflixclone.NetflixAssignment.main.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.Ordered;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

import javax.sql.DataSource;


@EnableWebSecurity
@ComponentScan("org.springframework.security.samples.mvc")
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{


    @Autowired
    DataSource dataSource;


    //setup authentication
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

    auth.jdbcAuthentication()
            .dataSource(dataSource)
            .usersByUsernameQuery("SELECT username,password,enabled "
                + "FROM users "
                + "WHERE username = ?")
            .authoritiesByUsernameQuery("SELECT username,authority "
                + "FROM authorities "
                + "WHERE username = ?");

    }


    //setup authorization
    protected void configure(HttpSecurity http) throws Exception{

    http.authorizeRequests()
            .antMatchers("/admin").hasRole("ADMIN")
//            .antMatchers("/user").hasAnyRole("ADMIN","USER")
//            .antMatchers("/**").permitAll()
            .and()
            .formLogin();
//            .loginPage("/login.html")
//            .failureUrl("/login-error.html");



    }

    //password encoder
    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }


//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }



}

