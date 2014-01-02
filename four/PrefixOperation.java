/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package deriver.four;

/**
 *
 * @author jamesthomas
 */
public abstract class PrefixOperation extends Operation{
	
	protected Expression param;
	
	public static PrefixOperation getPrefixOperation(String type, Expression param){
		String noSpace = type.replaceAll("\\s+","");
		String s = noSpace.toLowerCase();
		if( "sin".equals(s) ){
			return new Sin( param );
		} else if ("cos".equals(s) ){
			return new Cos( param );
		}  else if ("tan".equals(s) ){
			return new Tan( param );
		}  else if ("ln".equals(s) ){
			return new Ln( param );
		} else {
			throw new Error("Unrecognized Prefix Operation."
					+ "This error might actually happen");
		}
		
	}
	
	@Override
	public String getString( int parentPres){
		return this.getString();
	}
	
	/* @Override
	public Operation simplify(){
		return this;
	} */
}
