package contactmanagementsoftware.Interpreter;

public class MatchExpression implements Expression {

    private String data;

    public MatchExpression(String data) {
        this.data = data;
    }

    @Override
    public boolean interpret(String context) {
        return context.matches(data);
    }

}
