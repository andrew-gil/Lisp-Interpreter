package tasks;

import main.lisp.evaluator.Environment;
import main.lisp.evaluator.Evaluator;
import main.lisp.parser.terms.NilAtom;
import main.lisp.parser.terms.QuoteAtom;
import main.lisp.parser.terms.SExpression;
import main.lisp.parser.terms.TAtom;
import main.lisp.parser.terms.NilAtomicExpressionFactory;
import main.lisp.parser.terms.TAtomicExpressionFactory;

public class NotEvaluator implements Evaluator{

	@Override
	public SExpression eval(SExpression expr, Environment environment) {
		// TODO Auto-generated method stub
		//check the slides
		expr = expr.getTail();
		if (expr instanceof NilAtom) {
			return NilAtomicExpressionFactory.newInstance();
		}
		if (expr.getHead().eval(environment) instanceof NilAtom) {
			return TAtomicExpressionFactory.newInstance();
		}
		return NilAtomicExpressionFactory.newInstance();
	}
}
