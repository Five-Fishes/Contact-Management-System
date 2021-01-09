package contactmanagementsoftware.command;

import java.awt.event.ActionEvent;

public class VFDCommand implements Command{

    NavigateReceiver navigateReceiver;

    public VFDCommand(NavigateReceiver navigateReceiver) {
        this.navigateReceiver = navigateReceiver;
    }

    @Override
    public boolean execute(ActionEvent evt) {
        navigateReceiver.viewFullDetail();
        return true;
    }

    @Override
    public void undo(ActionEvent evt) {

    }
}
