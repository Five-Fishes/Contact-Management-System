package contactmanagementsoftware.command;

import java.awt.event.ActionEvent;

public class VFDCommand implements Command{

    VFDButton vfdButton;

    public VFDCommand(VFDButton vfdButton) {
        this.vfdButton = vfdButton;
    }
    @Override
    public void execute(ActionEvent evt) {
        vfdButton.viewFullDetail();
    }

    @Override
    public void undo(ActionEvent evt) {

    }
}
