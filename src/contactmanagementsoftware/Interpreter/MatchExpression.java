package contactmanagementsoftware.Interpreter;

import contactmanagementsoftware.singleton.Logger;
import contactmanagementsoftware.singleton.LoggerSingleton;

public class MatchExpression implements Expression {

    public static final Logger logger = LoggerSingleton.getInstance();
    private String data;

    public MatchExpression(String data) {
        this.data = data;
    }

    @Override
    public boolean interpret(String context) {
        boolean result = context.toLowerCase().matches(data.toLowerCase());
        logger.debug("Match Expression evaluated as " + result);
        return result;
    }

}
