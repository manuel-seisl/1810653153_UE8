public class Encryption
{

    private static final int OFFSET = 3;

    // Verschlüsselung - verschieben vom Zeichen um 3 Stellen / ASCII

    public static char[] encrypt(String text){

        char[] textArray = text.toCharArray();
        char[] cryptArray = new char[textArray.length];

        for (int i = 0; i < textArray.length; i++){
            int currOffset = (textArray[i] + OFFSET) % 128;
            cryptArray[i] = (char)(currOffset);
        }

        return cryptArray;

    }

    // Entschlüsselung

    public static char[] decrypt(char[] cryptTextArray){

        char[] cryptArray = new char[cryptTextArray.length];

        int currOffset;

        for (int i = 0; i < cryptTextArray.length; i++){

            if ((cryptTextArray[i] - OFFSET) < 0){
                currOffset = cryptTextArray[i] - OFFSET + 128;
            } else {
                currOffset = (cryptTextArray[i] - OFFSET) % 128;
            }

            cryptArray[i] = (char)(currOffset);

        }

        return cryptArray;

    }

}
