package fr.dauphine.eappli.service;

import fr.dauphine.eappli.model.ApplicationUser;

public interface ServiceProvider {
    ApplicationUser addUser(ApplicationUser user);
    ApplicationUser findUserByUsername(String username);
}
