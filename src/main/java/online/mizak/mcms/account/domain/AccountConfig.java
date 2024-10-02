package online.mizak.mcms.account.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class AccountConfig {

    static AccountFacade accountFacade() {
        return new AccountFacade(new InMemoryUserRepository(), false);
    }

    @Bean
    AccountFacade accountFacade(
            UserRepository userRepository,
            @Value("${mcms.account.requireEmail}") Boolean requireEmail
    ) {
        return new AccountFacade(userRepository, requireEmail);
    }


}
