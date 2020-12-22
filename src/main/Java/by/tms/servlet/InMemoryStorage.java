package by.tms.servlet;

import java.util.ArrayList;
import java.util.List;

public class InMemoryStorage {
    private static List<User> users = new ArrayList<>();
    private static int id = 1;

    public void save(User user){
        users.add(user);
        user.setId(id);
        id++;
    }

    public void add(User user) {
        users.add(user);
    }

    public User getByLogin(String login) {
        for (User user : users) {
            if (user.getLogin().equals(login)) {
                return user;
            }
        }
        return null;
    }
    public List<User> getInfo(){
        return users;
    }

    public boolean reg(String login){
        for(int i=0;i<users.size();i++){
            if(login.equals(users.get(i).getLogin())){
                return false;
            }
        }
        return true;
    }


}
