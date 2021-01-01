package contactmanagementsoftware.command;

import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.Map;

public class Invoker {
    Map<String, Command> commands = new HashMap<>();
    Command undoCommand;

    public void setCommand(String action, Command command) {
        commands.put(action, command);
    }

    public void execute(String action, ActionEvent evt) {
        commands.get(action).execute(evt);
        undoCommand = commands.get(action);
    }

    public void undo(ActionEvent evt){
        undoCommand.undo(evt);
    }
}
