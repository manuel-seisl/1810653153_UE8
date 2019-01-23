public class Main
{

    public static void main(String[] args){

        // Aufruf um Geheimnis auszulesen

        getSecret();

    }

    public static void getSecret(){

        // Checken ob User eingeloggt ist

        Login.login();

    }

}
