import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logging
{

    // Record speichern

    public static void saveLog(User user, boolean state){

        File file = null;
        FileWriter fw = null;
        BufferedWriter writer = null;

        try {

            file = new File("log.txt");

            // Datei erstellen, falls noch nicht vorhanden

            if (!file.exists()){
                file.createNewFile();
            }

            fw = new FileWriter(file, true);
            writer = new BufferedWriter(fw);

            // Zeilenumbruch

            String seperator = System.getProperty("line.separator");

            // Aktuelles Datum

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm");
            Date currDate = new Date();
            String formattedDate = dateFormat.format(currDate);

            // Record zusammensetzen

            String record = formattedDate + " " + user.getUsername() + " " + Utils.formatPassword(String.valueOf(Encryption.decrypt(user.getPassword()))) + " " + state;

            writer.write(record + seperator);
            writer.close();

        } catch (Exception ex){
            ex.printStackTrace();
        }

    }

}
