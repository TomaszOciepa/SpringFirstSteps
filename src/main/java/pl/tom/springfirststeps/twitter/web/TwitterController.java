package pl.tom.springfirststeps.twitter.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.tom.springfirststeps.twitter.Twitter;
import pl.tom.springfirststeps.twitter.TwitterRepository;

import java.util.List;

@Controller
@RequestMapping("/twitter")
public class TwitterController {

    @Autowired
    private TwitterRepository twitterRepository;


    @RequestMapping(method = RequestMethod.GET)
    public String twitter(Model model, @RequestParam(value = "id", defaultValue = "0") int id){

        if (id == 0){
            model.addAttribute("twittList", twitterRepository.getTwitterList());
        }else{
            model.addAttribute("twittList", twitterRepository.getTwitterList(id));
        }
        return "twitter";
    }


}
