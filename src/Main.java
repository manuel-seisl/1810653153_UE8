import javax.swing.*;

public class Main
{

    public static void main(String[] args){

        // Aufruf um Geheimnis auszulesen

        getSecret();

        // Anzahl an versuchte Logins auslesen

        //JOptionPane.showMessageDialog(null, "Sie haben " + FileOperations.getFailedLogins(JOptionPane.showInputDialog("Bitte Benutzername eingeben:")) + "x versucht sich einzuloggen.");

    }

    public static void getSecret(){

        // Checken ob User eingeloggt ist

        Login.login();

    }

}
