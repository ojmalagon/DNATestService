package co.com.dnatest.service.implementation;

import co.com.dnatest.service.Iterator;

public class DNASequenceIterator implements Iterator {

	private String listStrings[];
	private int index;

	private int indexI;

	private int indexJ;

	private int sequenceCount;

	public DNASequenceIterator(String[] listStrings) {
		this.listStrings = listStrings;
		this.index = 0;
		this.indexI = 0;
		this.indexJ = 0;
		this.sequenceCount = 0;
	}

	private void setIndexI(int indexI) {
		this.indexI = indexI;
	}

	private void setIndexJ(int indexJ) {
		this.indexJ = indexJ;
	}

	@Override
	public Boolean hasOblique() {

		int count = 1;
		int countEvaluated = this.listStrings.length - 4;
		int sequence = 0;
		for (int i = 0; i <= countEvaluated; i++) {

			for (int j = 0; j <= countEvaluated; j++) {

				setIndexI(i);
				setIndexJ(j);
				char characterEvaluated = (char) getCharValue(indexI, indexJ);
				while (hasNextCharOblique()) {
					char character = (char) nextCharOblique();
					if (character == characterEvaluated) {
						count++;
					} else {
						characterEvaluated = character;
						count = 1;
					}

					if (count == 4) {
						sequence++;
					}
					if (count > 4) {
						sequence++;
					}
				}
			}
		}

		count = 1;
		for (int i = 0; i <= countEvaluated; i++) {

			for (int j = this.listStrings.length - 1; j >= this.listStrings.length - 1 - countEvaluated; j--) {

				setIndexI(i);
				setIndexJ(j);
				char characterEvaluated = (char) getCharValue(indexI, indexJ);
				while (hasPreviousCharOblique()) {
					char character = (char) previousCharOblique();
					if (character == characterEvaluated) {
						count++;
					} else {
						characterEvaluated = character;
						count = 0;
					}

					if (count == 4) {
						sequence++;
					}
					if (count > 4) {
						sequence++;
					}
				}
			}
		}
		this.sequenceCount = this.sequenceCount + sequence;
		return sequence > 0;
	}

	@Override
	public Boolean hasHorizontal() {

		int count = 1;
		int length =1;
		int sequence = 0;
		setIndexI(0);
		setIndexJ(0);
		char characterEvaluated = (char) getCharValue(indexI, indexJ);
		while (hasNextChar()) {
			length++;
			
			
			char character = (char) nextCharHorizontal();
			if (character == characterEvaluated) {
				count++;
			} else {
				characterEvaluated = character;
				count = 1;
			}

			if (count == 4) {
				sequence++;
			}
			if (count > 4) {
				sequence++;
			}
			
			if(this.listStrings.length==length) {
				count = 1;
				length =1;
				if(hasNextChar()){
					characterEvaluated = (char) nextCharHorizontal();
				}
				
			}
			
		}
		this.sequenceCount = this.sequenceCount + sequence;
		return sequence > 0;
	}

	@Override
	public Boolean hasVertical() {
		int count = 1;
		int length =1;
		int sequence = 0;
		setIndexI(0);
		setIndexJ(0);
		char characterEvaluated = (char) getCharValue(indexI, indexJ);
		while (hasNextChar()) {
			length++;
			
			
			char character = (char) nextCharVertical();
			if (character == characterEvaluated) {
				count++;
			} else {
				characterEvaluated = character;
				count = 1;
			}

			if (count == 4) {
				sequence++;
			}
			if (count > 4) {
				sequence++;
			}
			
			if(this.listStrings.length==length) {
				count = 1;
				length =1;
				if(hasNextChar()){
					characterEvaluated = (char) nextCharVertical();
				}
				
			}
			
		}
		this.sequenceCount = this.sequenceCount + sequence;
		return sequence > 0;
	}

	@Override
	public Object nextCharHorizontal() {
		if (this.hasNextChar()) {

			if (this.indexJ+1 != this.listStrings[0].length()) {
				this.indexJ++;
			} else {
				this.indexI++;
				this.indexJ = 0;
			}
			return this.listStrings[indexI].charAt(indexJ);
		}

		else
			return null;
	}
	
	@Override
	public Object nextCharVertical() {
		if (this.hasNextChar()) {

			if (this.indexI+1 != this.listStrings.length) {
				this.indexI++;
			} else {
				this.indexJ++;
				this.indexI = 0;
			}
			return this.listStrings[indexI].charAt(indexJ);
		}

		else
			return null;
	}


	@Override
	public Object previousChar() {
		if (this.hasPreviousChar()) {

			if (this.indexJ != 0) {
				this.indexJ--;
			} else {
				this.indexI--;
				this.indexJ = this.listStrings[0].length();
			}
			return this.listStrings[indexI].charAt(indexJ);
		}

		else
			return null;

	}

	@Override
	public Boolean hasNextChar() {
		return !((this.indexI+1 == this.listStrings.length) && (this.indexJ+1 == this.listStrings[0].length()));
	}

	@Override
	public Boolean hasPreviousChar() {
		return ((this.indexI > 0) || (this.indexJ > 0));
	}

	@Override
	public Object getCharValue(int i, int j) {

		return this.listStrings[i].charAt(j);
	}

	@Override
	public Object nextCharOblique() {
		if (this.hasNextCharOblique()) {
			if (this.indexI + 1 != this.listStrings.length && this.indexJ + 1 != this.listStrings[0].length()) {
				this.indexI++;
				this.indexJ++;
			}
			return this.listStrings[indexI].charAt(indexJ);
		}

		else
			return null;
	}

	@Override
	public Object previousCharOblique() {
		if (this.hasPreviousCharOblique()) {
			if (this.indexI + 1 != this.listStrings.length && this.indexJ - 1 != 0) {
				this.indexI++;
				this.indexJ--;
			}
			return this.listStrings[indexI].charAt(indexJ);
		}

		else
			return null;
	}

	@Override
	public Boolean hasNextCharOblique() {
		return !((this.indexI + 1 == this.listStrings.length) || (this.indexJ + 1 == this.listStrings[0].length()));
	}

	@Override
	public Boolean hasPreviousCharOblique() {
		return !((this.indexI + 1 == this.listStrings.length) || (this.indexJ - 1 == 0));
	}

	@Override
	public Object getSequenceCount() {
		return this.sequenceCount;
	}
}
