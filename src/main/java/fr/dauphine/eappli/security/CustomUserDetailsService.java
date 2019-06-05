package fr.dauphine.eappli.security;

import fr.dauphine.eappli.model.ApplicationUser;
import fr.dauphine.eappli.service.ServiceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private ServiceProvider provider;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        ApplicationUser user = provider.findUserByUsername(s);
        if(user == null) throw new UsernameNotFoundException("Utilisateur inconnu");
        return user;
    }
}
