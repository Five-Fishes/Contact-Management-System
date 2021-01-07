package contactmanagementsoftware.command;

import contactmanagementsoftware.Acquaintances;
import contactmanagementsoftware.singleton.Logger;
import contactmanagementsoftware.singleton.LoggerSingleton;

import java.awt.event.ActionEvent;
import java.util.Stack;

public class AddContactCommand implements Command{
    ContactReceiver contactReceiver;
    Stack<Integer> selectedContactTypeIndexStack = new Stack<>();
    Stack<Integer> selectedContactIndexStack = new Stack<>();
    Stack<Boolean> isAddContactStack = new Stack<>();
    Stack<Acquaintances> beforeEditAcquaintancesStack = new Stack<>();
    private Logger logger = LoggerSingleton.getInstance();

    public AddContactCommand(ContactReceiver contactReceiver){
        this.contactReceiver = contactReceiver;
    }

    @Override
    public boolean execute(ActionEvent evt) {
        if(contactReceiver.addContact()){
            selectedContactTypeIndexStack.push(contactReceiver.getSelectedContactTypeIndex());
            selectedContactIndexStack.push(contactReceiver.getSelectedContactIndex());
            boolean isAddContact = contactReceiver.getIsAddContact();
            isAddContactStack.push(isAddContact);

            if(!isAddContact){
                beforeEditAcquaintancesStack.push(contactReceiver.getAcquaintance());
            }

            return true;
        }
        else{
            logger.warning("Error in add contact action.");
            return false;
        }
    }

    @Override
    public void undo(ActionEvent evt) {
        if(isAddContactStack.isEmpty() == false){
            if (isAddContactStack.pop()){
                contactReceiver.deleteContact(selectedContactTypeIndexStack.pop());
            } else {
                contactReceiver.deleteContact(selectedContactTypeIndexStack.peek());
                contactReceiver.addContact(selectedContactTypeIndexStack.pop(),selectedContactIndexStack.pop(), beforeEditAcquaintancesStack.pop());
            }
        }
        else{
            logger.warning("Can't undo for Add Contact action. You may have not added any acquaintance yet.");
        }
    }
}
