package CRUDExemple;

public class Employes {



    private int id,salary;
    private String lastname;
    private String firstname;
    private String city;


    public Employes(int id, String lastname, String firstname, String city, int salary) {
        this.id = id;
        this.lastname = lastname;
        this.firstname = firstname;
        this.city = city;
        this.salary = salary;
    }

    public Employes() {

    }

    @Override
    public String toString() {
        return "Employes{" +
                "id=" + id +
                ", salary=" + salary +
                ", lastname='" + lastname + '\'' +
                ", firstname='" + firstname + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }



}
