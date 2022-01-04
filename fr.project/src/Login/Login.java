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

    /**
     * Getter pour récupérer le role de l'utilisateur
     * @return
     */
    public String getRole() {
        return role;
    }

    /**
     * Getters et Setters
     */
    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
    //ToString de la class Login (Pour les test à supprimer plus tard)

    /**
     * ToString de la class Login
     * @return
     */
    @Override
    public String toString() {
        return "Login{" +
                "role='" + role + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }



    /**
     * Fonction permettant de vérifier la validité du compte ainsi que son rôle afin d'afficher les bonnes interfaces
     * @throws SQLException
     */
    public void AccountcheckBDD() throws SQLException{


    }


}
