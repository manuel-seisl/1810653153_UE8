import javax.swing.*;
import java.io.*;

public class FileOperations
{

    // Benutzer aus Textdatei auslesen

    public static void readUser(User user){

        File file = null;
        FileReader fr = null;
        BufferedReader reader = null;

        try {

            file = new File("user.txt");

            // Datei erstellen, falls noch nicht vorhanden

            if (!file.exists()){
                file.createNewFile();
            }

            fr = new FileReader(file);
            reader = new BufferedReader(fr);

            boolean userExists = false;

            while (true){

                String line = reader.readLine();

                if (line == null) break;

                if (line.equals(user.toString())){
                    userExists = true;
                }

            }

            // Falls Benutzer nicht existiert, Registrierung anzeigen

            if (!userExists){

                // Logging

                Logging.saveLog(user, false);

                // Meldung anzeigen und zu Registrierung springen

                JOptionPane.showMessageDialog(null, "Sie konnten nicht eingeloggt werden. Bitte registrieren Sie sich!", "Login fehlerhaft", JOptionPane.ERROR_MESSAGE);
                Login.register();

                return;

            }

            // Logging

            Logging.saveLog(user, true);

            // Geheimnis anzeigen

            JOptionPane.showMessageDialog(null, "Das Geheimnis lautet: " + getSecret(), "Geheimnis", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception ex){
            ex.printStackTrace();
        }

    }

    // Benutzer in Textdatei speichern

    public static void saveUser(User user){

        File file = null;
        FileWriter fw = null;
        BufferedWriter writer = null;

        try {

            file = new File("user.txt");

            // Datei erstellen, falls noch nicht vorhanden

            if (!file.exists()){
                file.createNewFile();
            }

            fw = new FileWriter(file, true);
            writer = new BufferedWriter(fw);

            String seperator = System.getProperty("line.separator");

            writer.write(user.toString() + seperator);
            writer.close();

            // Meldung anzeigen

            JOptionPane.showMessageDialog(null, "Sie wurden erfolgreich registriert!");

            // Geheimnis anzeigen

            JOptionPane.showMessageDialog(null, "Das Geheimnis lautet: " + getSecret(), "Geheimnis", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception ex){
            ex.printStackTrace();
        }

    }

    // Geheimnis aus Textdatei auslesen

    public static String getSecret(){

        File file = null;
        FileReader fr = null;
        BufferedReader reader = null;
        String secret = "Kein Geheimnis verfügbar!";

        try {

            file = new File("secret.txt");
            fr = new FileReader(file);
            reader = new BufferedReader(fr);

            while (true){

                String line = reader.readLine();
                if (line == null) break;

                secret = line;

            }

        } catch (Exception ex){
            ex.printStackTrace();
        }

        return secret;

    }

}
