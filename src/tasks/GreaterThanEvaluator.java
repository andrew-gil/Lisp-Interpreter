package tasks;

import main.lisp.evaluator.Environment;
import main.lisp.evaluator.Evaluator;
import main.lisp.parser.terms.NilAtom;
import main.lisp.parser.terms.NilAtomicExpressionFactory;
import main.lisp.parser.terms.SExpression;
import main.lisp.parser.terms.TAtom;
import main.lisp.parser.terms.IntegerAtom;
import main.lisp.parser.terms.DecimalAtom;
import main.lisp.parser.terms.ExpressionFactory;

public class GreaterThanEvaluator extends AbstractComparatorEvaluator{

	@Override
	public SExpression eval(SExpression expr, Environment environment) {
		return comparator(expr, environment, "GT");
	}
}
