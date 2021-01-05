package contactmanagementsoftware.command;

import contactmanagementsoftware.Acquaintances;

import java.awt.event.ActionEvent;
import java.util.Stack;

public class DeleteCommand implements Command{
    ContactReceiver contactReceiver;
    Stack<Integer> indexes = new Stack<>();
    Stack<Integer> tindexes = new Stack<>();
    Stack<Acquaintances> acquaintances = new Stack<>();

    public DeleteCommand (ContactReceiver contactReceiver) {
        this.contactReceiver = contactReceiver;
    }

    @Override
    public void execute(ActionEvent evt) {
        contactReceiver.deleteContact();
        indexes.push(contactReceiver.getIndex());
        tindexes.push(contactReceiver.getTindex());
        acquaintances.push(contactReceiver.getAcquaintance());
    }

    @Override
    public void undo(ActionEvent evt) {
        contactReceiver.addContact(indexes.pop(), tindexes.pop(), acquaintances.pop());
    }
}
