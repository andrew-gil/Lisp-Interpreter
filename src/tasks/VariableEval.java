package tasks;

import main.lisp.evaluator.Environment;
import main.lisp.parser.terms.IdentifierAtom;
import main.lisp.parser.terms.NilAtomicExpressionFactory;
import main.lisp.parser.terms.SExpression;
import main.lisp.scanner.tokens.Token;

public class VariableEval extends IdentifierAtom{

	public VariableEval(String string) {
		super(string);
		// TODO Auto-generated constructor stub
	}
	public VariableEval(Token token) {
		super(token);
	}
	@Override
	public SExpression eval(Environment environment) {
		return environment.lookup(this).get();
	}
}
