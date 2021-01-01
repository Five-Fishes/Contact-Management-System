
import contactmanagementsoftware.Interpreter.Contact;
import contactmanagementsoftware.Interpreter.Expression;
import contactmanagementsoftware.Interpreter.Parser;
import java.util.ArrayList;
import java.util.List;

public class TestInterpreter {
    public static void main(String[] args) {
        List<Contact> list = new ArrayList<>();
        list.add(new Contact("Ahmad"));
        list.add(new Contact("Ali"));
        list.add(new Contact("Alice"));
        list.add(new Contact("Ah Beng"));
        list.add(new Contact("Ah Bengi"));
        list.add(new Contact("Ah Beng Gor"));
        Parser matchParser = new Parser();
        Expression matchExpression = matchParser.constructParser("\"Ah Beng\"");
        Expression aliExpression = matchParser.constructParser("Ali");
        Expression notExpression = matchParser.constructParser("Ali -Alice");
        Expression orExpression = matchParser.constructParser("Ah Beng | Ali");
        Expression secondOrExpression = matchParser.constructParser(" Ali | Ah Beng");
        for (int i = 0; i < list.size(); i++) {
            System.out.println("Name: " + list.get(i).getName());
            System.out.println("is \"Ah Beng\"? " + matchExpression.interpret(list.get(i).getName()));
            System.out.println("has Ali? " + aliExpression.interpret(list.get(i).getName()));
            System.out.println("has Ali but not Alice? " + notExpression.interpret(list.get(i).getName()));
            System.out.println("has Ah Beng or Ali? " + orExpression.interpret(list.get(i).getName()));
            System.out.println("has Ali or Ah Beng? " + secondOrExpression.interpret(list.get(i).getName()));
            System.out.println("");
        }
    }
}
