/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package deriver.four;

/**
 *
 * @author jamesthomas
 */
public class Sum extends InfixOperation{
	
	public Sum( Expression L, Expression R){
		this.L = L;
		this.R = R;
	}

	@Override
	public double value(double x) {
		return L.value(x) + R.value(x);
	}
	@Override
	public String getString() {
		return "(" + L.getString() + ")+(" + R.getString() + ")";
	}
	@Override
	public String getString( int parentPres) {
		//System.out.println( "parentPres: "+ parentPres + ";;   sum " );
		if( parentPres > 0 )
			return "(" + L.getString( 0 ) + "+" + R.getString( 0 ) + ")";
		else
			return L.getString( 0 ) + "+" + R.getString( 0 );
	}
	@Override
	public Operation simplify() {
		Expression L = Simplify.mod(this.L);
		Expression R = Simplify.mod(this.R);
		if( "0.0".equals(L.getString()) ){
			return R.operation;
		} else if ( "0.0".equals(R.getString()) ){
			return L.operation;
		} else {
			return new Sum( L, R );
		}
	}

	@Override
	public Operation derive() {
		return new Sum( new Expression( L.operation.derive() ), 
						new Expression( R.operation.derive() )  );
	}
	
}