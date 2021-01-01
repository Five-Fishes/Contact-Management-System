package contactmanagementsoftware.Interpreter;

import java.util.Stack;

public class Parser {

    public Expression constructParser(String text) {
        boolean orOperator = false;
        boolean afterOr = false;
        String matchString = "";
        String[] textArray = text.split(" ");
        Stack<Expression> exprStack = new Stack<>();
        for (int i = 0; i < textArray.length; i++) {
            if (textArray[i].startsWith("\"") && textArray[i].endsWith("\"")) {
                Expression matchExpression = new MatchExpression(textArray[i].replaceAll("\"", ""));
                matchString += textArray[i].replaceAll("\"", "");
                if (exprStack.isEmpty() || afterOr) {
                    exprStack.push(matchExpression);
                    afterOr = false;
                } else {
                    exprStack.push(new AndExpression(exprStack.pop(), matchExpression));
                }
            } else if (textArray[i].startsWith("\"")) {
                matchString += textArray[i].replaceAll("\"", "");
            } else if (textArray[i].endsWith("\"")) {
                matchString += " " + textArray[i].replaceAll("\"", "");
                Expression matchExpression = new MatchExpression(matchString);
                matchString = "";

                if (exprStack.isEmpty() || afterOr) {
                    exprStack.push(matchExpression);
                    afterOr = false;
                } else {
                    exprStack.push(new AndExpression(exprStack.pop(), matchExpression));
                }
            } else if (matchString.length() != 0) {
                matchString += " " + textArray[i].replaceAll("\"", "");
            } else if (textArray[i].startsWith("-")) {
                Expression notExpression = new NotExpression(new TerminalExpression(textArray[i].replaceAll("-", "")));
                if (exprStack.isEmpty() || afterOr) {
                    exprStack.push(notExpression);
                    afterOr = false;
                } else {
                    exprStack.push(new AndExpression(exprStack.pop(), notExpression));
                }
            } else if (textArray[i].equals("|")) {
                if (exprStack.isEmpty()) {
                    return null;
                } else if (i == text.length() - 1) {
                    return null;
                } else if (afterOr){
                    return null;
                }
                if (orOperator == true) {//there is a | in before
                    if (exprStack.size() < 2) {
                        return null;
                    }
                    Expression second = exprStack.pop();
                    Expression first = exprStack.pop();
                    exprStack.push(new OrExpression(first, second));
                }
                orOperator = true;
                afterOr = true;
            } else {
                Expression terminalExpression = new TerminalExpression(textArray[i]);
                if (exprStack.isEmpty() || afterOr) {
                    exprStack.push(terminalExpression);
                    afterOr = false;
                } else {
                    exprStack.push(new AndExpression(exprStack.pop(), terminalExpression));
                }
            }
        }
        if (orOperator == true) {
            if (exprStack.size() < 2) {
                return null;
            }
            Expression second = exprStack.pop();
            Expression first = exprStack.pop();
            return new OrExpression(first, second);
        }
        return exprStack.isEmpty() ? null : exprStack.pop();
    }
}
