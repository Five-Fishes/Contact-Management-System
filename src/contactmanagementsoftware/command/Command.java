package contactmanagementsoftware.command;

import java.awt.event.ActionEvent;

public interface Command {

    public boolean execute(ActionEvent evt);

    public void undo(ActionEvent evt);
}
