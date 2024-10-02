package online.mizak.mcms.account.domain;

import org.springframework.data.repository.Repository;

interface UserRepository extends Repository<User, Long> {
    User save(User user);

    Integer countAll();
}
