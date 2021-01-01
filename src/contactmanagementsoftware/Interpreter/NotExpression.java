package contactmanagementsoftware.Interpreter;

public class NotExpression implements Expression{

    private Expression expr1 = null;

    public NotExpression(Expression expr1) {
        this.expr1 = expr1;
    }

    @Override
    public boolean interpret(String context) {
        return !expr1.interpret(context);
    }

}
