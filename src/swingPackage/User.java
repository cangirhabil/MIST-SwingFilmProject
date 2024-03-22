package swingPackage;

import java.util.List;

public class User extends Person {

    private String password;
    private List<Film> filmsInTheList;

    public User(String name) {
        super(name);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Film> getFilmsInTheList() {
        return filmsInTheList;
    }

    public void setFilmsInTheList(List<Film> filmsInTheList) {
        this.filmsInTheList = filmsInTheList;
    }

}
