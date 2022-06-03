package tasks;

import main.lisp.evaluator.Environment;
import main.lisp.evaluator.Evaluator;
import main.lisp.parser.terms.NilAtom;
import main.lisp.parser.terms.NilAtomicExpressionFactory;
import main.lisp.parser.terms.SExpression;
import main.lisp.parser.terms.TAtom;
import main.lisp.parser.terms.ExpressionFactory;
import main.lisp.interpreter.InterpreterModelSingleton;
public class CondEvaluator implements Evaluator{

	@Override
	public SExpression eval(SExpression expr, Environment environment) {
		// TODO Auto-generated method stub
		expr = expr.getTail();
		if (expr instanceof NilAtom || expr.getHead() instanceof NilAtom) {
			return NilAtomicExpressionFactory.newInstance();
			//throw new IllegalStateException("Missing arguments for operator 'cond'");
		}
		while ((expr.getHead().getHead().eval(environment) instanceof NilAtom) && !(expr.getTail() instanceof NilAtom)) {
			expr = expr.getTail();
		}
		if (!(expr.getHead().getHead().eval(environment) instanceof NilAtom)) {
			return expr.getHead().getTail().getHead().eval(environment);
		}
		return NilAtomicExpressionFactory.newInstance();
		
		//SExpression exprEvaled = BuiltinOperationManagerSingleton.get().getEvaluator(expr.getHead().toString()).eval(expr, environment);
		
	}

}