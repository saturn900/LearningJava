package jd.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/","/hello","/css","/img","/login").permitAll()
                .antMatchers("/home").authenticated()
                .antMatchers("/routes", "/payments").hasRole("CLIENT")
                .antMatchers("/registerClien").hasRole("MANAGER")
                .antMatchers("/registerManager").hasRole("ROOT")
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("user").password("password").roles("USER")
                .and()
                .withUser("client").password("12").roles("CLIENT")
                .and()
                .withUser("manager").password("34").roles("MANAGER", "CLIENT")
                .and()
                .withUser("root").password("secret").roles("ROOT", "MANAGER", "CLIENT");
    }
}
