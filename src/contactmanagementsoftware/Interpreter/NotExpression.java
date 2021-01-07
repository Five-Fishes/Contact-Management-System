package contactmanagementsoftware.Interpreter;

import contactmanagementsoftware.singleton.Logger;
import contactmanagementsoftware.singleton.LoggerSingleton;

public class NotExpression implements Expression{

    public static final Logger logger = LoggerSingleton.getInstance();
    private Expression expression = null;

    public NotExpression(Expression expression) {
        this.expression = expression;
    }

    @Override
    public boolean interpret(String context) {
        boolean result = !expression.interpret(context);
        logger.debug("Not Expression evaluated as " + result);
        return result;
    }

}
