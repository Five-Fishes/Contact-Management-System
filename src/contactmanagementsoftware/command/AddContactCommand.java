package contactmanagementsoftware.command;

import contactmanagementsoftware.Acquaintances;

import java.awt.event.ActionEvent;
import java.util.Stack;

public class AddContactCommand implements Command{
    ContactReceiver contactReceiver;
    Stack<Integer> indexes = new Stack<>();
    Stack<Integer> tindexes = new Stack<>();
    Stack<Boolean> flags = new Stack<>();
    Stack<Acquaintances> acquaintances = new Stack<>();


    public AddContactCommand(ContactReceiver contactReceiver){
        this.contactReceiver = contactReceiver;
    }

    @Override
    public void execute(ActionEvent evt) {
        contactReceiver.addContact();
        indexes.push(contactReceiver.getIndex());
        tindexes.push(contactReceiver.getTindex());
        boolean flag = contactReceiver.getFlag();
        flags.push(flag);

        if(!flag){
            acquaintances.push(contactReceiver.getAcquaintance());
        }
    }

    @Override
    public void undo(ActionEvent evt) {
        if (flags.pop()){
            contactReceiver.deleteContact(indexes.pop());
        } else {
            contactReceiver.deleteContact(indexes.peek());
            contactReceiver.addContact(indexes.pop(),tindexes.pop(), acquaintances.pop());
        }
    }
}
