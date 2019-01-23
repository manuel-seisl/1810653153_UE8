package Aufgabe5;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class Main
{

    public static void main(String[] args){

        // Zufallszahl zwischen 1 und 50 in Textdatei schreiben

        writeFile();

        // Checken wie oft übergebene Zahl in Textdatei vorhanden ist

        System.out.println(getNumberQuantity(Integer.parseInt(JOptionPane.showInputDialog("Bitte Zahl zwischen 1 und 50 eingeben:"))));

    }

    public static int getNumberQuantity(int number){

        File file = null;
        FileReader fr = null;
        BufferedReader reader = null;
        ArrayList<Integer> list = new ArrayList<Integer>();

        try {

            file = new File("numbers.txt");

            fr = new FileReader(file);
            reader = new BufferedReader(fr);

            while (true) {

                String line = reader.readLine();
                if (line == null) break;

                if (Integer.parseInt(line) == number){
                    list.add(Integer.parseInt(line));
                }

            }

        } catch(Exception ex){
            ex.printStackTrace();
        }

        return list.size();

    }

    public static void writeFile(){

        File file = null;
        FileWriter fw = null;
        BufferedWriter writer = null;
        String seperator = System.getProperty("line.separator");
        Random random = new Random();

        try {

            file = new File("numbers.txt");

            if (!file.exists()){
                file.createNewFile();
            }

            fw = new FileWriter(file);
            writer = new BufferedWriter(fw);

            for (int i = 0; i < 50; i++){
                int randomNumber = random.nextInt(50) + 1;
                writer.write(randomNumber + seperator);
            }

            writer.close();

        } catch (Exception ex){
            ex.printStackTrace();
        }

    }

}
