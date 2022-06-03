package tasks;

import main.lisp.evaluator.BuiltinOperationManagerSingleton;
import main.lisp.evaluator.Environment;
import main.lisp.evaluator.Evaluator;
import main.lisp.parser.terms.NilAtom;
import main.lisp.parser.terms.QuoteAtom;
import main.lisp.parser.terms.SExpression;
import main.lisp.parser.terms.TAtom;
import main.lisp.parser.terms.NilAtomicExpressionFactory;
import main.lisp.parser.terms.ExpressionFactory;
import main.lisp.parser.terms.IdentifierAtom;
import main.lisp.evaluator.function.LambdaFactory;

public class FuncallEvaluator implements Evaluator{

	@Override
	public SExpression eval(SExpression expr, Environment environment) {
		// TODO Auto-generated method stub
		expr = expr.getTail();
		return ExpressionFactory.newInstance(expr.getHead().eval(environment), expr.getTail()).eval(environment);
	}

}
