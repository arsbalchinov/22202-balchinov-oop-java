package Commands;

import java.util.HashMap;
import java.util.Stack;

public class ExecutionContext {
    private final Stack<Double> stack;
    private final HashMap<String, Double> parameters;

    public ExecutionContext() {
        this.stack = new Stack<>();
        this.parameters = new HashMap<>();
    }

    public Stack<Double> getStack() {
        return stack;
    }

    public HashMap<String, Double> getParameters() {
        return parameters;
    }
}