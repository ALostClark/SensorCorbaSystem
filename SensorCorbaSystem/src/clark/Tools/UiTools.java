package clark.Tools;

import javafx.scene.control.TextArea;

public class UiTools {

    public static TextArea getUITextArea() {
        return UITextArea;
    }

    public static void setUITextArea(TextArea textarea) {
        UITextArea = textarea;
    }

    public static TextArea UITextArea;

    public static String[] startArgs1;

    public static String[] getStartArgs(){
        return startArgs1;
    }

    public static void setStartArgs(String[] startArgs){
        startArgs1 = startArgs;
    }

}
