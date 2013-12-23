/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package deriver.four;

/**
 * Some foundational-notational notes:
 *		Expression should be focused on parsing, Operations on using
 *		Everything is converted to lower case
 *		Expressions are read left to right
 * @author jamesthomas
 */
public class Expression {
	
	private Operation operation = new Identity();
	
	public Expression( String input ){
		String noSpace = input.replaceAll("\\s+","");
		String s = noSpace.toLowerCase();
		System.out.println(s);
		
		if("x".equals(s)){
			operation= new Identity();
			return;
		}
		try{
			double a= Double.parseDouble(s);
			operation= new Number( a);
			return;
		} catch( NumberFormatException e){
			//don't do anything!
		}
		
		int minScore = 100;
		int thisScore = 100;
		int paramDepth = 0;
		int breakPoint = -1;
		int prefixCheck=0;//can be checked for prefix if prefix check equals one
		String prefix = "";
		charLoop: for( int i0=0; i0<s.length(); i0++){ //This for loop determines infix operation breakpoints
			char character = s.charAt(i0);
			switch( character){
				case '(':
					if(prefixCheck==0){ //only reached at first paren
						prefix= s.substring(0,i0); 
					}
					if(paramDepth==0)
						prefixCheck++; //Goes up for every start of a top-level paren group
					paramDepth++;
					break;
				case ')':
					paramDepth--; 
					break;
				default:
					if( paramDepth==0 ){
						switch( character ){
							case '+':
								thisScore = 0; break;
							case '-':
								thisScore = 1; break;
							case '*':
								thisScore = 2; break;
							case '/':
								thisScore = 3; break;
							case '^':
								thisScore = 4; break;
							default:
								continue charLoop;
						}
						if(thisScore < minScore){
							breakPoint = i0;
							minScore = thisScore;
						}
						thisScore = 100;
					}
					break;
			}
		}
		//System.out.println(breakPoint + "    breakPoint");
		//System.out.println(prefixCheck + "      prefixCheck");
		//System.out.println(prefix + "|     prefix");
		//System.out.println(minScore + "      minScore");
		
		if( minScore<100 ){ //breakpoint found, should be infix
			String op = s.substring(breakPoint,breakPoint+1);
			//System.out.println(op+"   wa");
			this.operation = InfixOperation.getInfixOperation(
					op,
					new Expression(s.substring(0,breakPoint)),
					new Expression(s.substring(breakPoint+1,s.length()))
				);
		} else if(prefixCheck==1) { //either prefix or null parens
			//System.out.println("identity map");
			if( "".equals(prefix) ){
				this.operation = new IdentityMap(
						new Expression(s.substring(1,s.length()-1 )) 
					);
			} else {
				this.operation = PrefixOperation.getPrefixOperation(
						prefix,
						new Expression( s.substring( prefix.length()+1,s.length()-1 ) )
					);
			}
		} else { //identity, or value, should have been caught before, so error I guess
			throw new Error("Got through expression code without being labled as anything");
		}
		
		
		//operation = new Sum( new Expression(new Identity()), 
		//		new Expression(new Sin(new Expression(new Identity()))));
		
		
	}
	public Expression (Operation oper){
		operation = oper;
	}
	
	public double value( double x){
		return operation.value(x);
	}
}
