package in.apptonic.mvpsampleapplalit.model;

public class UserInfo {

    private String name = "";
    private String email = "";

    public UserInfo(){};

    public UserInfo(String name, String email){

        this.name = name;
        this.email = email;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
