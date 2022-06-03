package tasks;

import main.lisp.evaluator.Environment;
import main.lisp.evaluator.Evaluator;
import main.lisp.parser.terms.NilAtom;
import main.lisp.parser.terms.Atom;
import main.lisp.parser.terms.SExpression;
import main.lisp.parser.terms.TAtom;
import main.lisp.parser.terms.IntegerAtom;
import main.lisp.parser.terms.DecimalAtom;
import main.lisp.parser.terms.NilAtomicExpressionFactory;
import main.lisp.parser.terms.TAtomicExpressionFactory;

public abstract class AbstractComparatorEvaluator implements Evaluator{

	public SExpression comparator(SExpression expr, Environment environment, String comparator) {
		// TODO Auto-generated method stub
			expr = expr.getTail();
			if (expr instanceof NilAtom || expr.getHead() instanceof NilAtom || expr.getTail() instanceof NilAtom) {
				return NilAtomicExpressionFactory.newInstance();
				//throw new IllegalStateException("Missing arguments for operator '*'");
			}
			if (!(expr.getTail().getTail() instanceof NilAtom)) {
				return NilAtomicExpressionFactory.newInstance();
				//throw new IllegalStateException("Too many arguments for operator '*'");
			}
			SExpression firstEvaled = expr.getHead().eval(environment);
			SExpression secondEvaled = expr.getTail().getHead().eval(environment);
			
			IntegerAtom firstInt = null;
			IntegerAtom secondInt = null;
			DecimalAtom firstDec = null;
			DecimalAtom secondDec = null;
			
			int correctArgs = 0;
			
			if (firstEvaled instanceof IntegerAtom) {
				firstInt = (IntegerAtom)firstEvaled;
				correctArgs++;
			}
			if (firstEvaled instanceof DecimalAtom) {
				firstDec = (DecimalAtom)firstEvaled;
				correctArgs++;
			}
			
			if (secondEvaled instanceof IntegerAtom) {
				secondInt = (IntegerAtom)secondEvaled;
				correctArgs++;
			}
			if (secondEvaled instanceof DecimalAtom) {
				secondDec = (DecimalAtom)secondEvaled;
				correctArgs++;
			}
			
			if (correctArgs != 2) {
				return NilAtomicExpressionFactory.newInstance();
				//throw new IllegalStateException("Arguments for operator '<' must both evaluate to numbers");
			}
			
			if (comparator.equals("GT")) {
				if (firstInt != null && secondInt != null) {
					if (firstInt.getValue() > secondInt.getValue()) {
						return TAtomicExpressionFactory.newInstance();
					} else {
						return NilAtomicExpressionFactory.newInstance();
					}
				} else {
					double initialValue = 0;
					if (firstInt != null) {
						initialValue = firstInt.getValue();
					} else if (firstDec != null) {
						initialValue = firstDec.getValue();
					}
					if (secondInt != null) {
						if (initialValue > secondInt.getValue()) {
							return TAtomicExpressionFactory.newInstance();
						} 
					} else if (secondDec != null) {
						if (initialValue > secondDec.getValue()) {
							return TAtomicExpressionFactory.newInstance();
						}
					}
					return NilAtomicExpressionFactory.newInstance();
				}
			}
			if (comparator.equals("GTE")) {
				if (firstInt != null && secondInt != null) {
					if (firstInt.getValue() >= secondInt.getValue()) {
						return TAtomicExpressionFactory.newInstance();
					} else {
						return NilAtomicExpressionFactory.newInstance();
					}
				} else {
					double initialValue = 0;
					if (firstInt != null) {
						initialValue = firstInt.getValue();
					} else if (firstDec != null) {
						initialValue = firstDec.getValue();
					}
					if (secondInt != null) {
						if (initialValue >= secondInt.getValue()) {
							return TAtomicExpressionFactory.newInstance();
						} 
					} else if (secondDec != null) {
						if (initialValue >= secondDec.getValue()) {
							return TAtomicExpressionFactory.newInstance();
						}
					}
					return NilAtomicExpressionFactory.newInstance();
				}
			} else if (comparator.equals("LT")) {
				if (firstInt != null && secondInt != null) {
					if (firstInt.getValue() < secondInt.getValue()) {
						return TAtomicExpressionFactory.newInstance();
					} else {
						return NilAtomicExpressionFactory.newInstance();
					}
				} else {
					double initialValue = 0;
					if (firstInt != null) {
						initialValue = firstInt.getValue();
					} else if (firstDec != null) {
						initialValue = firstDec.getValue();
					}
					if (secondInt != null) {
						if (initialValue < secondInt.getValue()) {
							return TAtomicExpressionFactory.newInstance();
						} 
					} else if (secondDec != null) {
						if (initialValue < secondDec.getValue()) {
							return TAtomicExpressionFactory.newInstance();
						}
					}
					return NilAtomicExpressionFactory.newInstance();
				}
			} else if (comparator.equals("LTE")){
				if (firstInt != null && secondInt != null) {
					if (firstInt.getValue() <= secondInt.getValue()) {
						return TAtomicExpressionFactory.newInstance();
					} else {
						return NilAtomicExpressionFactory.newInstance();
					}
				} else {
					double initialValue = 0;
					if (firstInt != null) {
						initialValue = firstInt.getValue();
					} else if (firstDec != null) {
						initialValue = firstDec.getValue();
					}
					if (secondInt != null) {
						if (initialValue <= secondInt.getValue()) {
							return TAtomicExpressionFactory.newInstance();
						} 
					} else if (secondDec != null) {
						if (initialValue <= secondDec.getValue()) {
							return TAtomicExpressionFactory.newInstance();
						}
					}
					return NilAtomicExpressionFactory.newInstance();
				}
			} else {
				return NilAtomicExpressionFactory.newInstance();
			}	
	}
	
}
