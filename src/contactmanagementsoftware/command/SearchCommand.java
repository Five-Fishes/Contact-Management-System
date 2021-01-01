package contactmanagementsoftware.command;

import java.awt.event.ActionEvent;

public class SearchCommand implements Command{

    SearchReceiver searchReceiver;

    public SearchCommand(SearchReceiver searchReceiver) {
        this.searchReceiver = searchReceiver;
    }

    @Override
    public void execute(ActionEvent evt) {
        searchReceiver.search();
    }

    @Override
    public void undo(ActionEvent evt) {

    }
}
