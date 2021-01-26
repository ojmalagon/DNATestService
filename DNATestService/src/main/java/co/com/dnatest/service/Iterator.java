package co.com.dnatest.service;

public interface Iterator {

public Object nextCharHorizontal();
	
	public Object nextCharVertical();
	
	public Object previousChar();
	
	public Object nextCharOblique();
	
	public Object previousCharOblique();
	
	public Object getCharValue(int i, int j);
	
	public Boolean hasNextChar();
	
	public Boolean hasPreviousChar();
	
	public Boolean hasNextCharOblique();
	
	public Boolean hasPreviousCharOblique();
	
	public Boolean hasOblique();
	
	public Boolean hasHorizontal();
	
	public Boolean hasVertical();
	
	public Object getSequenceCount();
}
