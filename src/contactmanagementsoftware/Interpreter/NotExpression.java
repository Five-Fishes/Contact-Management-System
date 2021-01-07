package contactmanagementsoftware.Interpreter;

public class NotExpression implements Expression{

    private Expression expression = null;

    public NotExpression(Expression expression) {
        this.expression = expression;
    }

    @Override
    public boolean interpret(String context) {
        return !expression.interpret(context);
    }

}
