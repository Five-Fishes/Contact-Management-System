package contactmanagementsoftware.command;

import java.awt.event.ActionEvent;

public class BackToMainMenuCommand implements Command{

    BackToMainMenuButton backToMainMenuButton;

    public BackToMainMenuCommand (BackToMainMenuButton backToMainMenuButton){
        this.backToMainMenuButton = backToMainMenuButton;
    }

    @Override
    public void execute(ActionEvent evt) {
        backToMainMenuButton.backToMainMenu();
    }

    @Override
    public void undo(ActionEvent evt) {

    }
}
