package Model;

import java.util.ArrayList;

public class User extends Person {

    private String password;
    private ArrayList<FilmList> filmList = new ArrayList<>();

    public User(String name) {
        super(name);
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
