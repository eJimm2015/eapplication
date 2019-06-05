package fr.dauphine.eappli.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Objects;

public class UserDTO {

    @Email(message = "Veuillez renseigner un email valide")
    @NotEmpty(message = "Veuillez renseigner un email")
    private String username;

    @NotEmpty(message = "Veuillez renseigner un mot de passe")
    @Size(min = 6, message = "Votre mot de passe doit au moins avoir 6 caractères")
    private String password;

    @NotEmpty(message = "Veuillez confirmer votre mot de passe")
    @Size(min = 6, message = "Votre mot de passe doit au moins avoir 6 caractères")
    private String confirm;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirm() {
        return confirm;
    }

    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDTO userDTO = (UserDTO) o;
        return username.equals(userDTO.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", confirm='" + confirm + '\'' +
                '}';
    }
}

