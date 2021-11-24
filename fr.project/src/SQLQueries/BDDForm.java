package SQLQueries;

public class BDDForm {


    public final String url="jdbc:mysql://localhost:8889/projetbdd?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
    public final String login="root";
    public final String password="root";


    public String getUrl() {
        return url;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

}
