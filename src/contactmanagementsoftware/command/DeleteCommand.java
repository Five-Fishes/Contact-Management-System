package contactmanagementsoftware.command;

import contactmanagementsoftware.Acquaintances;
import contactmanagementsoftware.singleton.Logger;
import contactmanagementsoftware.singleton.LoggerSingleton;

import java.awt.event.ActionEvent;
import java.util.Stack;

public class DeleteCommand implements Command{
    ContactReceiver contactReceiver;
    Stack<Integer> selectedContactTypeIndexStack = new Stack<>();
    Stack<Integer> selectedContactIndexStack = new Stack<>();
    Stack<Acquaintances> deletedAcquaintancesStack = new Stack<>();
    private Logger logger = LoggerSingleton.getInstance();

    public DeleteCommand (ContactReceiver contactReceiver) {
        this.contactReceiver = contactReceiver;
    }

    @Override
    public void execute(ActionEvent evt) {
        if(contactReceiver.deleteContact()){
            selectedContactTypeIndexStack.push(contactReceiver.getSelectedContactTypeIndex());
            selectedContactIndexStack.push(contactReceiver.getSelectedContactIndex());
            deletedAcquaintancesStack.push(contactReceiver.getAcquaintance());
        }
        else{
            logger.warning("Error or cancelled delete contact action.");
        }
    }

    @Override
    public void undo(ActionEvent evt) {
        if(selectedContactTypeIndexStack.isEmpty() == false){
            contactReceiver.addContact(selectedContactTypeIndexStack.pop(), selectedContactIndexStack.pop(), deletedAcquaintancesStack.pop());
        }
        else{
            logger.warning("Can't undo Delete Contact action. You may have not delete any acquaintance yet.");
        }
    }
}
