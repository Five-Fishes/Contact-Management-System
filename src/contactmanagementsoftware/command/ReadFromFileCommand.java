package contactmanagementsoftware.command;

import contactmanagementsoftware.singleton.Logger;
import contactmanagementsoftware.singleton.LoggerSingleton;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class ReadFromFileCommand implements Command{

    ContactReceiver contactReceiver;
    Stack<ArrayList<Integer>> uploadedFileIndexes = new Stack<>();
    private final Logger logger = LoggerSingleton.getInstance();

    public ReadFromFileCommand(ContactReceiver contactReceiver){
        this.contactReceiver = contactReceiver;
    }

    @Override
    public boolean execute(ActionEvent evt) {
        if(contactReceiver.uploadContacts()){
            uploadedFileIndexes.push(contactReceiver.getUploadedFileIndexes());
            contactReceiver.cleanUploadedFileIndexes();
            return true;
        }
        else{
            logger.warning("Unsuccessful read from file action. You may have cancel the action or there is an error occured.");
            return false;
        }
    }

    @Override
    public void undo(ActionEvent evt) {
        if(uploadedFileIndexes.isEmpty() == false){
            Iterator<Integer> iterator = uploadedFileIndexes.pop().iterator();
            while(iterator.hasNext()){
                contactReceiver.deleteContact(iterator.next());
            }
        }
        else{
            logger.warning("Can't undo Read From File action. Previous Read from File action is unsuccessful.");
        }
    }
}
