public class Utils
{

    // Passwort formatieren (z.B. aa###bb)

    public static String formatPassword(String password){

        String frmtPassword = "";

        System.out.println(password.length());

        if (password.length() > 6){
            frmtPassword = password.substring(0, 2) + "###" + password.substring(password.length() - 2, password.length());
        } else {

            for (int i = 0; i < password.length(); i++){
                frmtPassword += "#";
            }

        }

        return frmtPassword;

    }

}
