package contactmanagementsoftware.command;

import java.awt.event.ActionEvent;

public class ReadFromFileCommand implements Command{

    ReadFromFileButton readFromFileButton;

    public ReadFromFileCommand(ReadFromFileButton readFromFileButton){
        this.readFromFileButton = readFromFileButton;
    }

    @Override
    public void execute(ActionEvent evt) {
        readFromFileButton.readFromFile();
    }

    @Override
    public void undo(ActionEvent evt) {

    }
}
