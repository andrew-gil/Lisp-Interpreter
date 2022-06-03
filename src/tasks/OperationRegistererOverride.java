package tasks;

import main.lisp.evaluator.OperationRegisterer;
import main.lisp.evaluator.BuiltinOperationManagerSingleton;

public class OperationRegistererOverride implements OperationRegisterer{

	@Override
	public void registerOperations() {
		// TODO Auto-generated method stub
		registerAll();
	}
	public static void registerAll() {
		BuiltinOperationManagerSingleton.get().registerEvaluator("quote", new QuoteEvaluator());
		BuiltinOperationManagerSingleton.get().registerEvaluator("list", new ListEvaluator());
		BuiltinOperationManagerSingleton.get().registerEvaluator("eval", new EvalEvaluator());
		BuiltinOperationManagerSingleton.get().registerEvaluator("load", new LoadEvaluator());
		BuiltinOperationManagerSingleton.get().registerEvaluator("cond", new CondEvaluator());
		BuiltinOperationManagerSingleton.get().registerEvaluator("<", new LessThanEvaluator());
		BuiltinOperationManagerSingleton.get().registerEvaluator("<=", new LessThanEqualsEvaluator());
		BuiltinOperationManagerSingleton.get().registerEvaluator(">", new GreaterThanEvaluator());
		BuiltinOperationManagerSingleton.get().registerEvaluator(">=", new GreaterThanEqualsEvaluator());
		BuiltinOperationManagerSingleton.get().registerEvaluator("and", new AndEvaluator());
		BuiltinOperationManagerSingleton.get().registerEvaluator("or", new OrEvaluator());
		BuiltinOperationManagerSingleton.get().registerEvaluator("not", new NotEvaluator());
		BuiltinOperationManagerSingleton.get().registerEvaluator("setq", new SetqEvaluator());
		BuiltinOperationManagerSingleton.get().registerEvaluator("lambda", new LambdaEvaluator());
		BuiltinOperationManagerSingleton.get().registerEvaluator("funcall", new FuncallEvaluator());

	}

}
