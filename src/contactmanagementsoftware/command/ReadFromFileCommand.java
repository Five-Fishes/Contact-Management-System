package contactmanagementsoftware.command;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class ReadFromFileCommand implements Command{

    ContactReceiver contactReceiver;
    Stack<ArrayList<Integer>> uploadedFileIndexes = new Stack<>();

    public ReadFromFileCommand(ContactReceiver contactReceiver){
        this.contactReceiver = contactReceiver;
    }

    @Override
    public void execute(ActionEvent evt) {
        contactReceiver.uploadContacts();
        uploadedFileIndexes.push(contactReceiver.getUploadedFileIndexes());
        contactReceiver.cleanUploadedFileIndexes();
    }

    @Override
    public void undo(ActionEvent evt) {
        Iterator<Integer> iterator = uploadedFileIndexes.pop().iterator();
        while(iterator.hasNext()){
            contactReceiver.deleteContact(iterator.next());
        }
    }
}
