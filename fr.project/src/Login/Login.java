package Login;

import java.sql.SQLException;

public class Login {

    // Variable de la class Login
    private String role;
    private String login;
    private String password;



    /**
     * Constructeur de la classe Login
     * @param role
     * @param login
     * @param password
     */
    public Login(String role, String login, String password) {
        this.role = role;
        this.login = login;
        this.password = password;
    }


    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
