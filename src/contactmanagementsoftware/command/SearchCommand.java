package contactmanagementsoftware.command;

import java.awt.event.ActionEvent;

public class SearchCommand implements Command{

    SearchButton searchButton;

    public SearchCommand(SearchButton searchButton) {
        this.searchButton = searchButton;
    }

    @Override
    public void execute(ActionEvent evt) {
        searchButton.search();
    }

    @Override
    public void undo(ActionEvent evt) {

    }
}
