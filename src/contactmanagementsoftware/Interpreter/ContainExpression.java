package contactmanagementsoftware.Interpreter;

import contactmanagementsoftware.singleton.Logger;
import contactmanagementsoftware.singleton.LoggerSingleton;

public class ContainExpression implements Expression {

    public static final Logger logger = LoggerSingleton.getInstance();
    private String data;

    public ContainExpression(String data) {
        this.data = data;
    }

    @Override
    public boolean interpret(String context) {
        boolean result = context.toLowerCase().contains(data.toLowerCase());
        logger.debug("Contain Expression evaluated as " + result);
        return result;
    }

}
