package online.mizak.mcms.account.domain;

import lombok.extern.slf4j.Slf4j;
import online.mizak.mcms.account.dto.CreateUserRequest;
import online.mizak.mcms.account.dto.UserDto;
import online.mizak.mcms.infrastructure.exceptions.NotAcceptableException;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Transactional
public class AccountFacade {

    private final UserRepository userRepository;
    private final boolean requireEmail;

    AccountFacade(UserRepository userRepository, boolean requireEmail) {
        this.userRepository = userRepository;
        this.requireEmail = requireEmail;
    }

    public UserDto createUser(CreateUserRequest createUserRequest) {
        try {
            var user = requireEmail ?  User.createDefaultUser(
                    createUserRequest.login(),
                    createUserRequest.password(),
                    createUserRequest.email()
            ) : User.createDefaultUser(
                    createUserRequest.login(),
                    createUserRequest.password()
            );
            return userRepository.save(user).toDto();
        } catch (IllegalArgumentException illegalArgumentException) {
            throw new NotAcceptableException(illegalArgumentException.getMessage());
        }
    }

    public Integer countUsers() {
        return userRepository.countAll();
    }

}
