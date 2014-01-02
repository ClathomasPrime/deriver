/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package deriver.four;

/**
 *
 * @author jamesthomas
 */
public class Product extends InfixOperation{
	public Product( Expression L, Expression R){
		this.L = L;
		this.R = R;
	}

	@Override
	public double value(double x) {
		return L.value(x) * R.value(x);
	}
	@Override
	public String getString() {
		return "(" + L.getString() + ")*(" + R.getString() + ")";
	}
	@Override
	public String getString( int parentPres) {
		//System.out.println( "parentPres: "+ parentPres + ";;  prod  " );
		if( parentPres > 2 )
			return "(" + L.getString( 2 ) + "*" + R.getString( 2 ) + ")";
		else
			return L.getString( 2 ) + "*" + R.getString( 2 );
	}

	@Override
	public Operation simplify() {
		Expression L = Simplify.mod(this.L);
		Expression R = Simplify.mod(this.R);
		if ( "0.0".equals(L.getString()) || "0.0".equals(R.getString()) ){
			return new Number(0);
		} else if ( "1.0".equals(L.getString()) ){
			return R.operation;
		} else if ( "1.0".equals(R.getString()) ){
			return L.operation;
		} else {
			return new Product( L, R );
		}
	}

	@Override
	public Operation derive() {
		return new Sum( new Expression( new Product( new Expression( L.operation.derive() ), 
													 R ) ) ,
						new Expression( new Product(L , 
													new Expression( R.operation.derive() ) ) ) );
	}
}