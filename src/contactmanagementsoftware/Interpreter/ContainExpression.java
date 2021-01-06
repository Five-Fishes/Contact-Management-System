package contactmanagementsoftware.Interpreter;

public class ContainExpression implements Expression {

    private String data;

    public ContainExpression(String data) {
        this.data = data;
    }

    @Override
    public boolean interpret(String context) {
        return context.toLowerCase().contains(data.toLowerCase());
    }

}
