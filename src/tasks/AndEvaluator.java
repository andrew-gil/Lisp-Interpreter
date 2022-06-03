package tasks;

import main.lisp.evaluator.Environment;
import main.lisp.evaluator.Evaluator;
import main.lisp.parser.terms.NilAtom;
import main.lisp.parser.terms.QuoteAtom;
import main.lisp.parser.terms.SExpression;
import main.lisp.parser.terms.TAtom;
import main.lisp.parser.terms.NilAtomicExpressionFactory;

public class AndEvaluator implements Evaluator{

	@Override
	public SExpression eval(SExpression expr, Environment environment) {
		// TODO Auto-generated method stub
		//check the slides
		expr = expr.getTail();
		while (!(expr.getTail() instanceof NilAtom)) {
			if (expr.getHead().eval(environment) instanceof NilAtom) {
				return NilAtomicExpressionFactory.newInstance();
			}
			expr = expr.getTail();
		}
		return expr.getHead().eval(environment);
	}

}
