package tasks;

import main.lisp.evaluator.Environment;
import main.lisp.evaluator.Evaluator;
import main.lisp.parser.terms.NilAtom;
import main.lisp.parser.terms.SExpression;
import main.lisp.parser.terms.TAtom;
import main.lisp.parser.terms.ExpressionFactory;
import main.lisp.parser.terms.NilAtomicExpressionFactory;

public class ListEvaluator implements Evaluator{

	@Override
	public SExpression eval(SExpression expr, Environment environment) {
		// TODO Auto-generated method stub
		expr = expr.getTail();
		if (expr instanceof NilAtom) {
			return NilAtomicExpressionFactory.newInstance();
		}
		SExpression tempExpr = expr;
		int size = 1;
		if (expr.getTail() instanceof NilAtom) {
			return expr.getHead().eval(environment);
		}
		//determine length of list
		while (!(tempExpr.getTail() instanceof NilAtom)) {
			size++;
			tempExpr = tempExpr.getTail();
		}
		SExpression[] exprCache = new SExpression[size];
		int i = 0;
		//construct an eval list
		while (!(expr.getTail() instanceof NilAtom)) {
			exprCache[i] = expr.getHead().eval(environment);
			i++;
			expr = expr.getTail();
		}
		exprCache[size-1] = expr.getHead().eval(environment);
		SExpression evaledExpr = expr.getTail();
		for (int j = size-1; j >= 0; j--) {
			evaledExpr = ExpressionFactory.newInstance(exprCache[j],evaledExpr);
		}
		return evaledExpr;
	}

}