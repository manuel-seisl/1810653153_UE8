import java.io.Serializable;

public class User implements Serializable
{

    private String username;
    private String password;
    private boolean registration;

    public User(String username, String password, boolean registration){

        this.username = username;
        this.password = password;
        this.registration = registration;

        checkUser();

    }

    // Checken ob Benutzer - Registrierung oder Login

    public void checkUser(){
        if (registration){
            FileOperations.saveUser(this);
            FileOperations.readUser(this);
        } else {
            FileOperations.readUser(this);
        }

    }

    public String getUsername(){
        return username;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    @Override
    public String toString(){
        return username + "|" + password;
    }
}
