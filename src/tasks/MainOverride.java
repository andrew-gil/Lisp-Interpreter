package tasks;

import main.Main;
import main.lisp.evaluator.ExpressionEvaluatorFactory;
import main.lisp.evaluator.environment.EnvironmentFactory;
import main.lisp.parser.terms.ExpressionFactory;
import main.lisp.parser.terms.IdentifierAtomFactory;

public class MainOverride {
	public static void main(final String[] args) {
		ExpressionFactory.setClass(BasicExpressionOverride.class);
		EnvironmentFactory.setClass(EnvironmentOverride.class);
		IdentifierAtomFactory.setClass(VariableEval.class);
		ExpressionEvaluatorFactory.setClass(SExpressionWLambdaEvaluator.class);
		OperationRegistererOverride.registerAll();
		Main.main(args);
	}
}
