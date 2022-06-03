package tasks;


import main.lisp.parser.terms.BasicExpression;
import main.lisp.parser.terms.SExpression;
import main.lisp.parser.terms.NilAtom;
import main.lisp.parser.terms.AbstractSExpression;

public class BasicExpressionOverride extends BasicExpression {

	//private SExpression head;
	//private SExpression tail;
	
	public BasicExpressionOverride(SExpression head, SExpression tail) {
		super(head, tail);
		// TODO Auto-generated constructor stub
	}
	@Override
	public boolean isList() {
		//tail.isNil()
		if (this.getTail().isNIL()) {
			return true;
		}
		return this.getTail().isList();
	}
	@Override
	public String toString() {
		return isList()? toStringAsList() : toStringAsSExpression();
	}
	@Override
	public String toStringAsListHelperPublic() {
		if (getTail().isNIL()) {return (getHead().toString());}
		return getHead().toString() +" "+ ((AbstractSExpression) getTail()).toStringAsListHelperPublic();
	}
	
	@Override
	public String toStringAsList() {
		//String headValue = head.toString();
		//String value = ((AbstractSExpression) this.getTail()).toStringAsListHelperPublic();
		return "(" + ((AbstractSExpression) this).toStringAsListHelperPublic() + ")";
		//String value = "(" + H1.toString() + " " + H2.toString() + " " + … HN.toString() + ")";
	}
	
	@Override
	public String toStringAsSExpression() {
		String value = "(" + 
						this.getHead().toString() + 
						" " + "." + " " +
						this.getTail().toString() + 
						")";
		return value;
	}

	@Override
	public String toStringAsSExpressionDeep() {
		String value = "(" + 
						this.getHead().toStringAsSExpressionDeep() + 
						" " + "." + " " +
						this.getTail().toStringAsSExpressionDeep() + 
						")";
		return value;
	}
	
}
