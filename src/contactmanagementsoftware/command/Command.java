package contactmanagementsoftware.command;

import java.awt.event.ActionEvent;

public interface Command {

    public void execute(ActionEvent evt);

    public void undo(ActionEvent evt);
}
