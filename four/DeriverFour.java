/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package deriver.four;

/**
 *
 * @author jamesthomas
 */
import javax.swing.*;

public class DeriverFour extends JFrame{
	
	public DeriverFour(){
		this.setSize(800,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setTitle("Deriver and Grapher");
		this.setVisible(true);
	}
	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		// TODO code application logic here
		
		new DeriverFour();
		
		Expression e = new Expression("sin(  cos(x+1)) +3*ln(x^3)");
		System.out.println( "Hi" );
		System.out.println( e.value(4) );
	}
}
