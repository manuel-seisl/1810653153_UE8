import javax.swing.*;

public class Login
{

    // Login

    public static void login(){

        try {

            // Eingabe Benutzername und Passwort

            String username = JOptionPane.showInputDialog(null, "Bitte Benutzername eingeben:", "Login", JOptionPane.INFORMATION_MESSAGE);
            String password = JOptionPane.showInputDialog(null, "Bitte Passwort eingeben:", "Login", JOptionPane.INFORMATION_MESSAGE);

            // Checken ob Benutzer - Benutzername und Passwort eingegeben hat, ansonsten Login noch einmal anzeigen

            if (username.equals("") || password.equals("")){
                JOptionPane.showMessageDialog(null, "Sie haben keinen Benutzernamen oder Passwort eingegeben!");
                login();
            } else {
                User user = new User(username, password, false);
            }

        } catch (Exception ex){
            ex.printStackTrace();
        }

    }

    // Registrierung

    public static void register(){

        try {

            // Eingabe Benutzername und Passwort

            String username = JOptionPane.showInputDialog(null, "Bitte Benutzername eingeben:", "Registrierung", JOptionPane.INFORMATION_MESSAGE);
            String password = JOptionPane.showInputDialog(null, "Bitte Passwort eingeben:", "Registrierung", JOptionPane.INFORMATION_MESSAGE);

            // Checken ob Benutzer - Benutzername und Passwort eingegeben hat, ansonsten Registeriung noch einmal anzeigen

            if (username.equals("") || password.equals("")){
                JOptionPane.showMessageDialog(null, "Sie konnten nicht registriert werden. Sie haben keinen Benutzernamen oder Passwort eingegeben!");
                register();
            } else {
                User user = new User(username, password, true);
            }


        } catch (Exception ex){
            ex.printStackTrace();
        }

    }

}
