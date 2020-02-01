package com.newbegin.project.newbegin.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Collection;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "usr")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Pattern(regexp = "^[a-z0-9_-]{4,10}$", message = "минимум 4 буквы")
    private String username;

    @Pattern(regexp = "(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9@#$%]).{6,}", message = "Пароль должен быть от 6 символов" +
            ", содержать верхний и нижний регистр, цифры и символы")
    private String password;

    @Transient
    @NotBlank(message = "должен быть заполнен")
    private String password2;

    @Email
    private String email;

    private boolean active;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

    public boolean isActive() {
        return active;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return isActive();
    }
}
