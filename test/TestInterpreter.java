
import contactmanagementsoftware.Acquaintances;
import contactmanagementsoftware.Interpreter.Expression;
import contactmanagementsoftware.Interpreter.Parser;
import java.util.ArrayList;
import java.util.List;

public class TestInterpreter {
    public static void main(String[] args) {
        List<Acquaintances> list = new ArrayList<>();
        Acquaintances ahmad = new Acquaintances();
        ahmad.setName("Ahmad");
        list.add(ahmad);
        Acquaintances ali = new Acquaintances();
        ali.setName("Ali");
        list.add(ali);
        Acquaintances alice = new Acquaintances();
        alice.setName("Alice");
        list.add(alice);
        Acquaintances ahBeng = new Acquaintances();
        ahBeng.setName("Ah Beng");
        list.add(ahBeng);
        Acquaintances ahBengi = new Acquaintances();
        ahBengi.setName("Ah Bengi");
        list.add(ahBengi);
        Acquaintances ahBengGor = new Acquaintances();
        ahBengGor.setName("Ah Beng Gor");
        list.add(ahBengGor);
        Acquaintances ahMeng = new Acquaintances();
        ahMeng.setName("Ah Meng");
        list.add(ahMeng);
        Parser matchParser = new Parser();
        Expression matchExpression = matchParser.constructParser("\"Ah Beng\"");
        Expression aliExpression = matchParser.constructParser("Ali");
        Expression notExpression = matchParser.constructParser("Ali -Alice");
        Expression orExpression = matchParser.constructParser("Ah Beng | Ali");
        Expression secondOrExpression = matchParser.constructParser("Ali | Ah Beng");
        Expression thirdOrExpression = matchParser.constructParser("Ali | Ah Beng | Ahmad");
        Expression fourthOrExpression = matchParser.constructParser("A*i");
        for (int i = 0; i < list.size(); i++) {
            System.out.println("Name: " + list.get(i).getName());
            System.out.println("is \"Ah Beng\"? " + matchExpression.interpret(list.get(i).getName()));
            System.out.println("has Ali? " + aliExpression.interpret(list.get(i).getName()));
            System.out.println("has Ali but not Alice? " + notExpression.interpret(list.get(i).getName()));
            System.out.println("has Ah Beng or Ali? " + orExpression.interpret(list.get(i).getName()));
            System.out.println("has Ali or Ah Beng? " + secondOrExpression.interpret(list.get(i).getName()));
            System.out.println("has Ali or Ahmad or Ah Beng? " + thirdOrExpression.interpret(list.get(i).getName()));
            System.out.println("");
        }
    }
}
