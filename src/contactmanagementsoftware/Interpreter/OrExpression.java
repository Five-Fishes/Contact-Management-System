package contactmanagementsoftware.Interpreter;

import contactmanagementsoftware.singleton.Logger;
import contactmanagementsoftware.singleton.LoggerSingleton;

public class OrExpression implements Expression {

    public static final Logger logger = LoggerSingleton.getInstance();
    private Expression expression1 = null;
    private Expression expression2 = null;

    public OrExpression(Expression expression1, Expression expression2) {
        this.expression1 = expression1;
        this.expression2 = expression2;
    }

    @Override
    public boolean interpret(String context) {
        boolean result = expression1.interpret(context) || expression2.interpret(context);
        logger.debug("Not Expression evaluated as " + result);
        return result;
    }

}
