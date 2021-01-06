package contactmanagementsoftware.command;

import contactmanagementsoftware.singleton.Logger;
import contactmanagementsoftware.singleton.LoggerSingleton;
import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Invoker {
    Map<String, Command> commands = new HashMap<>();
    Stack<Command> undoCommand = new Stack<>();
    private Logger logger = LoggerSingleton.getInstance();

    public void setCommand(String action, Command command) {
        commands.put(action, command);
    }

    public void execute(String action, ActionEvent evt) {
        commands.get(action).execute(evt);
        if(action.equals("addContact") || action.equals("delete") || action.equals("readFromFile")){
            undoCommand.push(commands.get(action));
        }
    }

    public void undo(ActionEvent evt){
        if(!undoCommand.empty()){
            undoCommand.pop().undo(evt);
        }
        else{
            logger.warning("No more undo");
        }
    }
}
