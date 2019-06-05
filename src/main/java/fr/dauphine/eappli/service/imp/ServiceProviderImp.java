package fr.dauphine.eappli.service.imp;

import fr.dauphine.eappli.model.ApplicationUser;
import fr.dauphine.eappli.repository.ApplicationUserRepository;
import fr.dauphine.eappli.service.ServiceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ServiceProviderImp implements ServiceProvider {

    @Autowired
    private ApplicationUserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public ApplicationUser addUser(ApplicationUser user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public ApplicationUser findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
