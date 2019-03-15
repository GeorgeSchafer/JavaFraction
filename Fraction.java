/* @Author George Schafer
 * 
 */


public class Fraction {
	
	// these integers are the numerator (num) and denominator(den)
	private int num, den;
	
	// A Fraction created with no arguments ought to make a Fraction of value 0/0.
	public Fraction(){
		this.setNum(0);
		this.setDen(0);
	}
	
	/* This constructor will be used for any Fraction (even 0/0).
	 * The constructor will check that the fraction is valid by checking that the
	 * 	user is not trying to put zero in the denominator when there is a non-zero
	 * 	integer in the numerator.
	 * When fraction created has zero in the numerator, the fractions will not reduce
	 *   to 0/0, 0/1. Instead it will keep its denominator.
	 */
	public Fraction(int numerator,int denominator){
		if (numerator != 0 && denominator == 0){
			throw new IllegalArgumentException(	  "Illegal Argument Exception: /n"
												+ "denominator cannot be zero unless "
												+ "numerator is also zero");
		}
		
		if( (numerator > 0 && denominator > 0 ) ||
			(numerator < 0 && denominator < 0 ) ){
			this.setNum(Math.abs(numerator  ));
			this.setDen(Math.abs(denominator));
		} else{
			this.setNum(-Math.abs(numerator  ));
			this.setDen( Math.abs(denominator));
		} // END IF-ELSE
		
		reduce();
	}
	
	public Fraction(String x){
		if (x.equals("pi")){
			this.setNum(314159265);
			this.setDen( 100000000);
		}
	}
	
	public void setNum(int numerator){
		num = numerator;
	}
	
	public void setDen(int denominator){
		den = denominator;
	}
	
	public int getNum(){
		return num;
	}
	
	public int getDen(){
		return den;
	}
	
	/* the toMethods() are meant to process the fraction into forms which can be used
	 * in operations that cannot use the fraction class. This includes a two strings
	 * (Ratio and Strings) and decimal forms (Float and double). 
	 */
	public float toFloat(){
		return (float) getNum() / getDen();
	}
	
	
	public double toDouble(){
		return (double) getNum() / getDen();
	}
	
	
	public String toString(){
		return getNum() + " / " + getDen();
	}
	
	
	public String toRatio(){
		return this.getNum() + " : " + this.getDen();
	}
	
	
	/* add() and subtract() methods are designed to return a fraction that is the sum
	 * of the implied operations. The new fraction will be automatically reduced.
	 */
	public Fraction add(Fraction x) {
		int numerator   ;
		int denominator ;
		
		if (this.getDen() == x.getDen() ){
			numerator = this.getNum() + x.getNum() ;
			denominator = this.getDen();
		}else{
			numerator = ( this.getNum() * x.getDen() ) + 
					    ( this.getDen() * x.getNum() ) ;
			denominator = this.getDen() * x.getDen() ;
		} // END IF-ELSE
		
		return new Fraction(numerator,denominator);
	}
		
	
	public Fraction subtract(Fraction x) {
		int numerator   ;
		int denominator ;
		
		if (this.getDen() == x.getDen() ){
			numerator = this.getNum() - x.getNum() ;
			denominator = this.getDen();
		}else{
			numerator = ( this.getNum() * x.getDen() ) - 
					    ( this.getDen() * x.getNum() ) ;
			denominator = this.getDen() * x.getDen() ;
		} // END IF-ELSE
		
		return new Fraction(numerator,denominator);
	}
	
	
	/* Multiply() and Divide() methods are designed to return a fraction that is the product
	 * of their implied operations. The new fraction will be automatically reduced.
	 */ 
	public Fraction multiply(Fraction x){
		return new Fraction(this.getNum() * x.getNum(), this.getDen() * x.getDen());
	}
	
	public Fraction multiply(int n, int d){ // NOT TESTED
		Fraction x = new Fraction(n,d);
		return this.multiply(x);
	}
	
	public Fraction divide(Fraction x){
		return new Fraction(this.getNum() * x.getDen(), this.getDen() * x.getNum());
	}
	
	public Fraction divide(int n, int d){ // NOT TESTED
		Fraction x = new Fraction(n,d);
		return this.divide(x);
	}
	
	/* negative() and reciprocal() return a Fraction which is the inverse (multiplicative and additive 
	 * respectively) of the Fraction that calls the method.
	 */
	public Fraction negative(){ // NOT TESTED
		return new Fraction(-this.getNum(),this.getDen());
	}
	
	public Fraction reciprocal(){ // NOT TESTED
		return new Fraction(this.getDen(),this.getNum());
	}
	
	/* Reduce() is a method which will automatically reduce a fraction into it's smallest possible terms
	*/
	private void reduce(){ 
		/* 
		 * dn,up refers to a method of finding prime numbers. This is not concerned with only finding prime numbers, 
		 * and as such may be inefficient but it will do for my purposes for now.
		 * dn = 2^i - 1
		 * up = 2^i + 1
		*/
		
		int sm = 0 ;
		int dn,up  ;
		
		
		if(getNum() == getDen()){
			this.setNum(1);
			this.setDen(1);
			return ;
		} else if (getNum() > getDen()){
			sm = getDen();
		} else {
			sm = getNum();
		} // END EL-IF
		
		
		for(int i = 0 ; (int) Math.pow(2,i) <= sm ; i++){
			
			dn = (int) (Math.pow(2,i) - 1);
			up = (int) (Math.pow(2,i) + 1);
			
			if (getNum() % up == 0 && getDen() % up == 0){
				setNum(getNum() / up);
				setDen(getDen() / up);
				this.reduce();
				
			} else if ( dn != 0 && dn != 1 && getNum() % dn == 0 && getDen() % dn == 0){
				setNum(getNum() / dn);
				setDen(getDen() / dn);
				this.reduce();
				
			}
			
		} // END FOR
		
		return;
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
}
