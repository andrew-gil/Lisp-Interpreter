package tasks;

import main.lisp.evaluator.BasicExpressionEvaluator;
import main.lisp.evaluator.BuiltinOperationManagerSingleton;
import main.lisp.evaluator.Environment;
import main.lisp.evaluator.Evaluator;
import main.lisp.evaluator.function.BasicLambda;
import main.lisp.evaluator.function.Lambda;
import main.lisp.evaluator.function.LambdaFactory;
import main.lisp.parser.terms.IdentifierAtom;
import main.lisp.parser.terms.SExpression;
import main.lisp.parser.terms.StringAtom;

public class SExpressionWLambdaEvaluator extends BasicExpressionEvaluator {
	
	@Override
	public SExpression eval(SExpression expr, Environment environment) {
		if (expr.getHead() instanceof IdentifierAtom) {
			return super.eval(expr, environment);
		}
		if (expr.getHead() instanceof BasicLambda) {
			IdentifierAtom[] argNames = ((BasicLambda) expr.getHead()).getArgumentNames();
			SExpression values = expr.getTail();
			for (IdentifierAtom arg : argNames) {
				environment.assign(arg, values.getHead());
				values = values.getTail();
			}
			//return expr;
			return expr.getHead().eval(environment);
		}
		SExpression values = expr.getTail();
		expr = expr.getHead();
		SExpression parameters = expr.getTail().getHead();
		SExpression tempP = parameters;
		if (parameters.isNIL() || parameters.getHead().isNIL()) {
			IdentifierAtom[] argNames = new IdentifierAtom[0];
			SExpression newExpr = LambdaFactory.newInstance(argNames, expr.getTail().getTail());
			return newExpr.eval(environment);
		}
		int size = 0;
		while (!(tempP.getHead().isNIL())) {
			environment.assign((IdentifierAtom) tempP.getHead(), values.getHead());
			size++;
			tempP = tempP.getTail();
			values = values.getTail();
			if (tempP.isNIL() || values.isNIL()) {break;}
		}
		IdentifierAtom[] argNames = new IdentifierAtom[size];
		for (int i = 0; i < size; i++) {
			argNames[i] = (IdentifierAtom) parameters.getHead();
			parameters = parameters.getTail();
		}
		SExpression newExpr = LambdaFactory.newInstance(argNames, expr.getTail().getTail());
		//return values.getHead();
		return newExpr.eval(environment);
	}
}
