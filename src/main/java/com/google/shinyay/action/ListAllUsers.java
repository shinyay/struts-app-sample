package com.google.shinyay.action;

import com.google.shinyay.UserService;
import com.google.shinyay.entity.User;

import javax.naming.Context;
import javax.naming.InitialContext;
import java.util.List;
import java.util.Properties;

public class ListAllUsers {

    private int id;
    private String errorMessage;
    private List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String execute() {

        try {
            UserService service;
            Properties props = new Properties();
            props.put(Context.INITIAL_CONTEXT_FACTORY,
                    "org.apache.openejb.core.LocalInitialContextFactory");
            Context ctx = new InitialContext(props);
            service = (UserService) ctx.lookup("UserServiceImplLocal");
            this.users = service.findAll();
        } catch (Exception e) {
            this.errorMessage = e.getMessage();
            return "failure";
        }

        return "success";
    }
}
