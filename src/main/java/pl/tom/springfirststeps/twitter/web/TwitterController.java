package pl.tom.springfirststeps.twitter.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.tom.springfirststeps.twitter.TwitterRepository;

@Controller
@RequestMapping("/twitter")
public class TwitterController {

    @Autowired
    private TwitterRepository twitterRepository;


    @RequestMapping(method = RequestMethod.GET)
    public String twitter(Model model){
        model.addAttribute("twittList", twitterRepository.getTwitterList());
        return "twitter";
    }
}
