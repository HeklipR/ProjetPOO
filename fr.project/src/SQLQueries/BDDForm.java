package SQLQueries;

public class BDDForm {

    //à modifier et mettre le JSONParser à la place pour avoir un fichier Config

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
