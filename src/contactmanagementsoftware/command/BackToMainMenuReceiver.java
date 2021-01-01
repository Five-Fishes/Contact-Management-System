package contactmanagementsoftware.command;

public class BackToMainMenuReceiver extends Receiver {

    public void backToMainMenu(){
        jPanel2.setVisible(false);
        jPanel1.setVisible(true);
    }
}
