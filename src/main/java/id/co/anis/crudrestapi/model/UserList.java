package id.co.anis.crudrestapi.model;

import java.util.List;

/**
 * Created By Anis
 * created on 3/29/2020 - 7:35 PM on crudrestapi
 */
public class UserList {
    private List<User> userList;

    public UserList() {
    }

    public UserList(List<User> userList) {
        this.userList = userList;
    }

    public List<User> getUserList() {
        return userList;
    }
}
