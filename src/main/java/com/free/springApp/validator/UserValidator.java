package com.free.springApp.validator;

import com.free.springApp.model.User;
import com.free.springApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class UserValidator implements Validator {
    @Autowired
    private UserService userService;
    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
    User user=(User) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"username","Required");
        if(user.getUserName().length()<8 ||user.getUserName().length()>32 ){
            errors.rejectValue("username","Size.userForm.username");
        }
        if(userService.findUserByUserName(user.getUserName())!=null){
            errors.rejectValue("username","Duplicate.userForm.username");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"password","Required");
        if(user.getPassword().length()<8 ||user.getPassword().length()>32 ){
            errors.rejectValue("username","Size.userForm.password");
        }
        if(!user.getConfirmPassword().equals(user.getPassword())){
            errors.rejectValue("password","Different.userForm.password");
        }
    }
}
