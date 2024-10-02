package online.mizak.mcms.account;

import jakarta.annotation.Nonnull;
import online.mizak.mcms.account.domain.AccountFacade;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component("AccountWarmup")
class Warmup implements ApplicationListener<ApplicationReadyEvent> {

    private final AccountFacade accountFacade;

    Warmup(AccountFacade accountFacade) {
        this.accountFacade = accountFacade;
    }

    @Override
    public void onApplicationEvent(@Nonnull ApplicationReadyEvent event) {
    }

}
