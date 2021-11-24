package CRUD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class EmployesDAO {


    private final String url="jdbc:mysql://localhost:8889/tp_jdbc?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
    private final String login="root";
    private final String password="root";
    private Connection con;
    private Statement test;

    public EmployesDAO() throws SQLException, ClassNotFoundException {
        this.con = CRUD.SingleConnection.getInstance(url,password,login);
    }


    public CRUD.Employes findById(String id) throws SQLException {

        String rqt1 = "SELECT * FROM employes WHERE id = ?" ;
        PreparedStatement test = this.con.prepareStatement(rqt1);
        test.setString(1, id);
        ResultSet res = test.executeQuery();
        res.next();
       CRUD.Employes Wow = new CRUD.Employes(res.getInt("id"), res.getString("lastname"), res.getString("firstname"), res.getString("city"), res.getInt("salary"));

        return Wow;
    }


    public List<CRUD.Employes> findAll(){
        List<CRUD.Employes> l = new ArrayList<CRUD.Employes>();
        try{
            test = con.createStatement();
            ResultSet res = test.executeQuery("SELECT * FROM employes");
            while (res.next()){
                CRUD.Employes e = new CRUD.Employes();
                e.setId(res.getInt("id"));
                e.setLastname(res.getString("lastname"));
                e.setFirstname(res.getString("firstname"));
                e.setCity(res.getString("city"));
                e.setSalary(res.getInt("salary"));
                l.add(e);
            }
        }catch (Exception e ){
            e.printStackTrace();
        }
        return l;
    }

}
