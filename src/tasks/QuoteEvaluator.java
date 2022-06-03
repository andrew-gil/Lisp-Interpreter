package tasks;

import main.lisp.evaluator.Environment;
import main.lisp.evaluator.Evaluator;
import main.lisp.parser.terms.NilAtom;
import main.lisp.parser.terms.QuoteAtom;
import main.lisp.parser.terms.SExpression;
import main.lisp.parser.terms.TAtom;
import main.lisp.parser.terms.NilAtomicExpressionFactory;

public class QuoteEvaluator implements Evaluator{

	@Override
	public SExpression eval(SExpression expr, Environment environment) {
		// TODO Auto-generated method stub
		//check the slides
		expr = expr.getTail();
		if (expr.isNIL() || !(expr.getTail().isNIL())) {
			return NilAtomicExpressionFactory.newInstance();
			//throw new IllegalStateException("Too many arguments for operator 'quote'");
		}
		return expr.getHead();
	}

}
