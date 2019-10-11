package pl.tom.springfirststeps.twitter;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserRepository {

    private List<User> userList;

    public UserRepository() {
        this.userList = new ArrayList<>();
        userList.add(new User("Tomek", "Ociepa", "tom", "pass123"));
    }

    public void save(User user){
        userList.add(new User(user.getFirstName(), user.getLastName(), user.getUsername(), user.getPassword()));
    }

    public User findByUsername(String username){
        List<User> user = new ArrayList<>();
        user.add(userList.stream().filter(s -> s.getUsername().equals(username)).collect(Collectors.toList()).get(0));
        User u = new User(user.get(0).getFirstName(), user.get(0).getLastName(), user.get(0).getUsername(), user.get(0).getPassword() );
        return u;
    }
}
