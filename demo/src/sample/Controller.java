package sample;
import dictionary.*;
import javafx.fxml.FXML;

import static javax.print.attribute.standard.MediaSizeName.C;

public class Controller {
    DictionaryManagement dictionaryManagement = new DictionaryManagement();
    @FXML
    private void lookup(){
        dictionaryManagement.dictionaryLookup();
    }

}
