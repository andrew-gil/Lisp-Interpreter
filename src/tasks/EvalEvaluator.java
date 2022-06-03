package tasks;

import main.lisp.evaluator.Environment;
import main.lisp.evaluator.Evaluator;
import main.lisp.parser.terms.NilAtom;
import main.lisp.parser.terms.NilAtomicExpressionFactory;
import main.lisp.parser.terms.SExpression;
import main.lisp.parser.terms.TAtom;
import main.lisp.parser.terms.ExpressionFactory;
import main.lisp.evaluator.BuiltinOperationManagerSingleton;
public class EvalEvaluator implements Evaluator{

	@Override
	public SExpression eval(SExpression expr, Environment environment) {
		// TODO Auto-generated method stub
		expr = expr.getTail();
		if (expr instanceof NilAtom || expr.getHead() instanceof NilAtom) {
			return NilAtomicExpressionFactory.newInstance();
			//throw new IllegalStateException("Missing arguments for operator 'eval'");
		}
		//SExpression exprEvaled = BuiltinOperationManagerSingleton.get().getEvaluator(expr.getHead().toString()).eval(expr, environment);
		//SExpression argEvaled = expr.getTail().getTail().getHead().eval(environment);
		//SExpression newExpr = ExpressionFactory.newInstance(expr.getHead(),argEvaled);
		return expr.getHead().eval(environment).eval(environment);
	}

}