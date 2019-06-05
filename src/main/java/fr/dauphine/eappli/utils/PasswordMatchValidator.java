package fr.dauphine.eappli.utils;

import fr.dauphine.eappli.model.UserDTO;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchValidator implements ConstraintValidator<PasswordMatch, UserDTO> {
    @Override
    public boolean isValid(UserDTO userDTO, ConstraintValidatorContext constraintValidatorContext) {
        return userDTO.getPassword().equals(userDTO.getConfirm());
    }

    @Override
    public void initialize(PasswordMatch constraintAnnotation) {
    }
}
