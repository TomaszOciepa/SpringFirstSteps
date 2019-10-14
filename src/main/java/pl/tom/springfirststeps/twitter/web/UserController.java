package pl.tom.springfirststeps.twitter.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import pl.tom.springfirststeps.twitter.User;
import pl.tom.springfirststeps.twitter.UserRepository;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {

    private UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegistrationForm(User user, Model model){
        model.addAttribute("user", user);
        return "registerForm";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String processRegistration(@Valid User user, Errors errors){

        if (errors.hasErrors()){
            return "registerForm";
        }
        userRepository.save(user);
        return "redirect:/user/"+ user.getUsername();
    }


    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public String showUserProfle(@PathVariable String username, Model model){
        User user = userRepository.findByUsername(username);
        model.addAttribute("user", user);
        return "profile";
    }



}
