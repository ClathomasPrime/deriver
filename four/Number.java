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
}
