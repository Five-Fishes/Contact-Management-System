package contactmanagementsoftware.command;

import java.awt.event.ActionEvent;

public class ReadFromFileCommand implements Command{

    ReadFromFileReceiver readFromFileReceiver;

    public ReadFromFileCommand(ReadFromFileReceiver readFromFileReceiver){
        this.readFromFileReceiver = readFromFileReceiver;
    }

    @Override
    public void execute(ActionEvent evt) {
        readFromFileReceiver.readFromFile();
    }

    @Override
    public void undo(ActionEvent evt) {

    }
}
