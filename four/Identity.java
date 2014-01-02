/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package deriver.four;

/**
 *
 * @author jamesthomas
 */
public class Identity extends Operation{
	
	public Identity(){
		
	}
	
	@Override
	public double value( double x){
		return x;
	}
	
	@Override
	public String getString( ){
		return "x";
	}

	@Override
	public String getString(int parentPres) {
		return "x";
	}

	@Override
	public Operation simplify() {
		return new Identity();
	}

	@Override
	public Operation derive() {
		return new Number(1);
	}
	
}
