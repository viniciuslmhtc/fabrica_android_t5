package com.htcursos.htapp.models;

import java.io.Serializable;

/**
 * Created by viniciuslm on 17/10/15.
 */
public class User implements Serializable {

    private String login;

    private String password;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
