import javax.swing.*;
import java.io.*;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileOperations
{

    // Logger

    private static final Logger log = Logger.getLogger(FileOperations.class.getName());

    // Benutzer aus Textdatei auslesen

    public static void readUser(User user) {

        File file = null;
        FileReader fr = null;
        BufferedReader reader = null;
        Date currDate = new Date();

        try {

            file = new File("user.txt");

            if (!file.exists()){
                file.createNewFile();
            }

            fr = new FileReader(file);
            reader = new BufferedReader(fr);

            log.addHandler(new FileHandler("log.xml"));

            boolean userExists = false;

            while (true){

                String line = reader.readLine();
                if (line == null) break;

                if (line.equals(user.toString())){
                    userExists = true;
                }

            }

            if (!userExists){
                log.log(Level.INFO, "Test");
                JOptionPane.showMessageDialog(null, "Sie konnten nicht eingeloggt werden. Bitte registrieren Sie sich!", "Login fehlerhaft", JOptionPane.ERROR_MESSAGE);
                Login.register();
                return;
            }

            log.log(Level.INFO, "Test1");

            JOptionPane.showMessageDialog(null, "Das Geheimnis lautet: " + getSecret(), "Geheimnis", JOptionPane.INFORMATION_MESSAGE);

        } catch(Exception ex){
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

            if (!file.exists()){
                file.createNewFile();
            }

            fw = new FileWriter(file, true);
            writer = new BufferedWriter(fw);

            String seperator = System.getProperty("line.separator");

            writer.write(user.toString() + seperator);
            writer.close();

            JOptionPane.showMessageDialog(null, "Sie wurden erfolgreich registriert!");

        } catch(Exception ex){
            ex.printStackTrace();
        }

    }

    // Geheimnis auslesen

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

        } catch(Exception ex){
            ex.printStackTrace();
        }

        return secret;

    }

}
