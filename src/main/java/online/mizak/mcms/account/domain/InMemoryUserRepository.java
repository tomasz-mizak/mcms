package online.mizak.mcms.account.domain;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import static java.util.Objects.isNull;

class InMemoryUserRepository implements UserRepository {

    private final ConcurrentHashMap<Long, User> users = new ConcurrentHashMap<>();
    private final AtomicLong counter = new AtomicLong(0);

    @Override
    public User save(User user) {
        if (isNull(user.getId())) {
            user.setId(counter.incrementAndGet());
        }
        users.put(user.getId(), user);
        return user;
    }

    @Override
    public Integer countAll() {
        return users.size();
    }

}
