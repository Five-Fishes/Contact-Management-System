package contactmanagementsoftware.command;

import java.awt.event.ActionEvent;

public class AddCommand implements Command{

    AddButton addbutton;

    public AddCommand(AddButton addButton){
        this.addbutton = addButton;
    }

    @Override
    public void execute(ActionEvent evt) {
        addbutton.addForm(evt);
    }

    @Override
    public void undo(ActionEvent evt) {
        addbutton.addForm(evt);
    }
}
