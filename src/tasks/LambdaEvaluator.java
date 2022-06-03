package tasks;

import main.lisp.evaluator.Environment;
import main.lisp.evaluator.Evaluator;
import main.lisp.parser.terms.NilAtom;
import main.lisp.parser.terms.QuoteAtom;
import main.lisp.parser.terms.SExpression;
import main.lisp.parser.terms.TAtom;
import main.lisp.parser.terms.NilAtomicExpressionFactory;
import main.lisp.parser.terms.IdentifierAtom;
import main.lisp.evaluator.function.Lambda;
import main.lisp.evaluator.function.LambdaFactory;

public class LambdaEvaluator implements Evaluator{

	@Override
	public SExpression eval(SExpression expr, Environment environment) {
		// TODO Auto-generated method stub
		expr = expr.getTail();
		SExpression initialParameters = expr.getHead();
		if (initialParameters instanceof NilAtom) {
			IdentifierAtom[] parameters = new IdentifierAtom[0];
			return LambdaFactory.newInstance(parameters, expr.getTail());
		}
		SExpression temp = initialParameters;
		int size = 1;
		while (!(temp.getTail().isNIL())) {
			size++;
			temp = temp.getTail();
			if (temp.isNIL()) {break;}
		}
		IdentifierAtom[] parameters = new IdentifierAtom[size];
		for (int i = 0; i < size; i++) {
			parameters[i] = (IdentifierAtom) initialParameters.getHead();
			initialParameters = initialParameters.getTail();
		}
		
		SExpression var = LambdaFactory.newInstance(parameters, expr.getTail());
		return var;
	}

}
