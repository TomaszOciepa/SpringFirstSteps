package pl.tom.springfirststeps.twitter;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TwitterRepository {

    private List<Twitter> twitterList;

    public TwitterRepository() {
        this.twitterList = new ArrayList<>();
        twitterList.add(new Twitter(1, "Pierwszy twitt", LocalDateTime.now().minusMonths(2), 37.9, 29.2 ));
        twitterList.add(new Twitter(2, "Mój drugi twitt", LocalDateTime.now().minusHours(80), 87.9, 99.2 ));
        twitterList.add(new Twitter(3, "Mój trzeci twitt", LocalDateTime.now(), 57.9, 59.2 ));
    }

    public List<Twitter> getTwitterList() {
        return twitterList;
    }

    public List<Twitter> getTwitterList(int id){
        return twitterList.stream().filter(s -> s.getId() == id).collect(Collectors.toList());
    }
}
