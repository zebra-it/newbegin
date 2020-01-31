package com.newbegin.project.newbegin.service;

        import com.newbegin.project.newbegin.model.Role;
        import com.newbegin.project.newbegin.model.User;
        import com.newbegin.project.newbegin.repository.UserReposiroty;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.security.core.userdetails.UserDetails;
        import org.springframework.security.core.userdetails.UserDetailsService;
        import org.springframework.security.core.userdetails.UsernameNotFoundException;
        import org.springframework.security.crypto.password.PasswordEncoder;
        import org.springframework.stereotype.Service;

        import java.util.Collections;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserReposiroty userReposiroty;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String usernname) throws UsernameNotFoundException {
        return userReposiroty.findByUsername(usernname);
    }

    public void addUser(User user) {
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userReposiroty.save(user);

    }
}
