package API;

import com.darkprograms.speech.translator.GoogleTranslate;

import java.io.IOException;

public class Translate {

    public Translate(){

    }
    public static String Translate(String data)
    {
        try {
            //English to IGBO
           /* System.out.println(GoogleTranslate.translate("ig", "how are you"));

            //English to GREEK
            System.out.println(GoogleTranslate.translate("el", "how are you"));

            //English to HAUSA
            System.out.println(GoogleTranslate.translate("ha", "how are you"));*/

            //English to Yoruba
            return GoogleTranslate.translate("ja", data);

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        //System.out.println(Translate.Translate("ăn"));
    }
}
