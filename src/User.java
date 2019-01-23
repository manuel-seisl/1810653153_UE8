import java.io.Serializable;

public class User implements Serializable
{

    private String username;
    private char[] password;
    private boolean registration;

    public User(String username, String password, boolean registration){

        this.username = username;
        this.password = Encryption.encrypt(password);
        this.registration = registration;

        checkUser();

    }

    // Checken ob Benutzer - Registrierung oder Login angezeigt bekommt

    public void checkUser(){
        if (registration){
            FileOperations.saveUser(this);
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

    public char[] getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = Encryption.encrypt(password);
    }

    @Override
    public String toString(){
        return username + "|" + String.valueOf(password);
    }
}
