package contactmanagementsoftware.command;

import java.awt.event.ActionEvent;

public class VFDCommand implements Command{

    VFDReceiver vfdReceiver;

    public VFDCommand(VFDReceiver vfdReceiver) {
        this.vfdReceiver = vfdReceiver;
    }
    @Override
    public void execute(ActionEvent evt) {
        vfdReceiver.viewFullDetail();
    }

    @Override
    public void undo(ActionEvent evt) {

    }
}
