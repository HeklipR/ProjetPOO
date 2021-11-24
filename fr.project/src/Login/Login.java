package Login;

public class Login {

    private String role;
    private String login;
    private String password;


    public Login(String role, String login, String password) {
        this.role = role;
        this.login = login;
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "Login{" +
                "role='" + role + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public void AccountcheckBDD(){

    }


}
