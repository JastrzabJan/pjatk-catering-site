package pjatk.mas.project.cateringsite.security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import pjatk.mas.project.cateringsite.service.user.AdministratorService;
import pjatk.mas.project.cateringsite.service.user.ClientService;
import pjatk.mas.project.cateringsite.service.user.ConsultantService;
import pjatk.mas.project.cateringsite.service.user.ManagerService;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, proxyTargetClass = true)
public class SpringSecurityConfig  extends WebSecurityConfigurerAdapter {


    private final AccessDeniedHandler accessDeniedHandler;

    final DataSource dataSource;

    public SpringSecurityConfig(AccessDeniedHandler accessDeniedHandler, DataSource dataSource) {
        this.accessDeniedHandler = accessDeniedHandler;
        this.dataSource = dataSource;
    }

    @Autowired
    private ClientService clientService;
    @Autowired
    private ManagerService managerService;
    @Autowired
    private AdministratorService administratorService;
    @Autowired
    private ConsultantService consultantService;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(clientService)
                .passwordEncoder(passwordEncoder())
                .and()
                .userDetailsService(managerService)
                .passwordEncoder(passwordEncoder())
                .and()
                .userDetailsService(administratorService)
                .passwordEncoder(passwordEncoder())
                .and()
                .userDetailsService(consultantService)
                .passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {

        http
                .headers()
                    .frameOptions().sameOrigin()
                    .and()
                .authorizeRequests()
                    .antMatchers("/resources/**","/assets/**", "/webjars/**", "/").permitAll()
                    .antMatchers("/registration*", "/login*", "/error*").anonymous()
                    .antMatchers("/offers*", "/cart*", "/client*", "/home*", "/orderform*").hasAnyRole("Client", "Consultant", "Manager", "Administrator")
                    .antMatchers("/consultant*").hasAnyRole("Consultant", "Manager", "Administrator")
                    .antMatchers("/manager*").hasAnyRole("Manager", "Administrator")
                    .antMatchers("/administrator*").hasRole("Administrator")
                    .anyRequest().authenticated()
                    .and()
                .formLogin()
                    .loginPage("/login")
                    .defaultSuccessUrl("/home")
                    .failureUrl("/login?error")
                    .permitAll()
                    .and()
                .logout()
                    .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                    .logoutSuccessUrl("/login?logout")
                    .deleteCookies("my-remember-me-cookie")
                    .permitAll()
                    .and()
                .rememberMe()
                //.key("my-secure-key")
                    .rememberMeCookieName("my-remember-me-cookie")
                    .tokenRepository(persistentTokenRepository())
                    .tokenValiditySeconds(24 * 60 * 60)
                    .and()
                .exceptionHandling().accessDeniedHandler(accessDeniedHandler);
    }

    PersistentTokenRepository persistentTokenRepository(){
        JdbcTokenRepositoryImpl tokenRepositoryImpl = new JdbcTokenRepositoryImpl();
        tokenRepositoryImpl.setDataSource(dataSource);
        return tokenRepositoryImpl;
    }
}
