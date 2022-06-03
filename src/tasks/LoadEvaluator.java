package tasks;

import main.lisp.evaluator.Environment;
import main.lisp.evaluator.Evaluator;
import main.lisp.parser.terms.NilAtom;
import main.lisp.parser.terms.NilAtomicExpressionFactory;
import main.lisp.parser.terms.SExpression;
import main.lisp.parser.terms.TAtom;
import main.lisp.parser.terms.StringAtom;
import main.lisp.parser.terms.ExpressionFactory;
import main.lisp.interpreter.InterpreterModelSingleton;
import main.lisp.interpreter.ObservableLispInterpreter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.io.IOException;
import main.lisp.parser.terms.TAtomicExpressionFactory;

public class LoadEvaluator implements Evaluator{

	@Override
	public SExpression eval(SExpression expr, Environment environment) {
		// TODO Auto-generated method stub
		expr = expr.getTail();
		if (expr instanceof NilAtom || expr.getHead() instanceof NilAtom) {
			return NilAtomicExpressionFactory.newInstance();
			//throw new IllegalStateException("Missing arguments for operator 'load'");
		}
		String argString = ((StringAtom) expr.getHead().eval(environment)).getValue();

		Path lispPath = Paths.get("", argString);
		SExpression retVal = TAtomicExpressionFactory.newInstance();
		try {
			List<String> file = Files.readAllLines(lispPath);
			for (String lines : file) {
				InterpreterModelSingleton.get().newInput(lines);
			}
		} catch(IOException i) {
			retVal = NilAtomicExpressionFactory.newInstance();
		} catch(IllegalStateException i) {
			retVal = NilAtomicExpressionFactory.newInstance();
		} catch(Exception i) {
			retVal = NilAtomicExpressionFactory.newInstance();
		}
		return retVal;
		//SExpression exprEvaled = BuiltinOperationManagerSingleton.get().getEvaluator(expr.getHead().toString()).eval(expr, environment);
		
	}

}