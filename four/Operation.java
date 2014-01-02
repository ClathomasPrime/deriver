/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package deriver.four;

/**
 *
 * @author jamesthomas
 */
public abstract class Operation {
	
	abstract public double value(double x);
	abstract public String getString();
	abstract public String getString( int parentPres);
	abstract public Operation simplify();
	abstract public Operation derive();
}
