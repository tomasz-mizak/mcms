package online.mizak.mcms.account.domain;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import online.mizak.mcms.account.dto.UserDto;
import online.mizak.mcms.util.EmailValidator;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.Version;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

class User implements UserDetails {

    enum Role {
        Default,
        Admin,
    }

    @Id
    @GeneratedValue
    @Setter @Getter
    private Long id;

    @Version
    private Integer version;

    @Column(nullable = false, unique = true, length = 32)
    private String login;

    @Column(nullable = false, length = 32)
    private String password;

    private String email;
    private Role role;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    static User createDefaultUser(String login, String password) throws IllegalArgumentException {

        if (login.isBlank()) throw new IllegalArgumentException("User login cannot be blank.");

        if (!(login.length() >= 5 && login.length() <= 32))
            throw new IllegalArgumentException("User login must be between 5 and 32 characters.");

        if (password.isBlank()) throw new IllegalArgumentException("User password cannot be blank.");

        if (!(password.length() >= 5 && password.length() <= 32))
            throw new IllegalArgumentException("User password must be between 5 and 32 characters.");

        var user = new User();
        user.role = Role.Default;
        user.login = login;
        user.password = password;
        return user;
    }

    static User createDefaultUser(String login, String password, String email) throws IllegalArgumentException {

        if (email.isBlank() && !EmailValidator.validate(email)) {
            throw new IllegalArgumentException("User email address is invalid.");
        }

        var user = createDefaultUser(login, password);
        user.email = email;
        return user;
    }

    static User createAdminUser(String login, String password) throws IllegalArgumentException {
        var user = createDefaultUser(login, password);
        user.role = Role.Admin;
        return user;
    }

    UserDto toDto() {
        return new UserDto(id, login, email, role.name());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return "";
    }

    @Override
    public String getUsername() {
        return "";
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }

}
