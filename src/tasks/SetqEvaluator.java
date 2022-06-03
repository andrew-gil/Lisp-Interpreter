package tasks;

import main.lisp.evaluator.Environment;
import main.lisp.evaluator.Evaluator;
import main.lisp.parser.terms.NilAtom;
import main.lisp.parser.terms.QuoteAtom;
import main.lisp.parser.terms.SExpression;
import main.lisp.parser.terms.TAtom;
import main.lisp.parser.terms.NilAtomicExpressionFactory;
import main.lisp.parser.terms.IdentifierAtom;

public class SetqEvaluator implements Evaluator{

	@Override
	public SExpression eval(SExpression expr, Environment environment) {
		// TODO Auto-generated method stub
		expr = expr.getTail();
		if (expr.isNIL() || expr.getHead().isNIL() || expr.getTail().isNIL()) {
			return NilAtomicExpressionFactory.newInstance();
			//throw new IllegalStateException("Too many arguments for operator 'quote'");
		}
		IdentifierAtom lastVar = (IdentifierAtom) expr.getHead();
		while (!(expr.getTail().isNIL()) && !(expr.getHead().isNIL())) {
			environment.assign((IdentifierAtom) expr.getHead(), expr.getTail().getHead().eval(environment));
			lastVar = (IdentifierAtom) expr.getHead();
			expr = expr.getTail().getTail();
			if (expr.isNIL()) {break;}
		}
		if (environment.lookup(lastVar).isPresent()) {
			return environment.lookup(lastVar).get();
		} else {
			return NilAtomicExpressionFactory.newInstance();
		}
	}

}
