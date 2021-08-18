package LollapallozaProject.Lollapalloza.configurations;


import LollapallozaProject.Lollapalloza.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
public class WebAuthentication extends GlobalAuthenticationConfigurerAdapter{

    @Autowired
    UserRepository userRepository;

    @Override
    public void init(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(email -> {

            LollapallozaProject.Lollapalloza.models.User user1 = userRepository.findByEmail(email);
            if (user1 != null) {
                // verificar en el controller que no se pueda crear un usuario con este mail
                if (user1.getEmail().endsWith("@admin")){
                    return new  org.springframework.security.core.userdetails.User(user1.getEmail(), user1.getPassword(),
                    AuthorityUtils.createAuthorityList("ADMIN"));
                }
                return new  org.springframework.security.core.userdetails.User(user1.getEmail(), user1.getPassword(), AuthorityUtils.createAuthorityList("USER"));
            } else {
                throw new UsernameNotFoundException("Unknown client: " + email);
            }
        });
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

}