package Login;

public class Login {

    // Variable de la class Login
    private String role;
    private String login;
    private String password;


    //Constructeur de la classe Login
    public Login(String role, String login, String password) {
        this.role = role;
        this.login = login;
        this.password = password;
    }

    //Getter pour récupérer le role de l'utilisateur
    public String getRole() {
        return role;
    }

    //ToString de la class Login (Pour les test à supprimer plus tard)
    @Override
    public String toString() {
        return "Login{" +
                "role='" + role + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }


    //Fonction permettant de vérifier la validité du compte ainsi que son rôle afin d'afficher les bonnes interfaces
    public void AccountcheckBDD(){

    }


}
