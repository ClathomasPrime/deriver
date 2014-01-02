/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package deriver.four;

/**
 *
 * @author jamesthomas
 */
public class Number extends Operation{
	private double value = 0;
	
	public Number( double value){
		this.value = value;
	}
	
	public double value( double x){
		return value;
	}

	@Override
	public String getString() {
		return Double.toString(value);
	}

	@Override
	public String getString(int parentPres) {
		return getString();
	}

	@Override
	public Operation simplify() {
		return new Number(this.value);
	}

	@Override
	public Operation derive() {
		return new Number( 0 );
	}
}
