/**
 * @author Camera Finn
 */
public class DNA {
	private double[] genes_;

	// DNA object
	public DNA ( int length ) {
		genes_ = new double[length]; // creates an array of genes in squirrel's DNA of parameter
									 // length
		for ( int i = 0 ; i < genes_.length ; i++ ) {
			genes_[i] = Math.random(); // random double generated >= 0 and < 1.0
		}
	}

	public int getLength () { // get length of parent's DNA array
		return genes_.length;
	}

	public double getGene ( int n ) { // returns nth gene value: between 0 and 1
		return genes_[n];
	}

	public DNA clone ( DNA parent ) { // parameter: parent's DNA
		DNA child = new DNA(getLength()); // creates new DNA object: child
		for ( int i = 0 ; i < getLength() ; i++ ) {
			child.genes_[i] = parent.getGene(i); // copies parent's genes into child's
			                                     // gene array
		}
		return child; // child's DNA w/ parents copied into it
	}

	public double[] mutate ( double rate ) { // returns an array of the child's
	                                         // DNA
		double chance = Math.random();
		for ( int i = 0 ; i < getLength() ; i++ ) {
			if ( chance <= rate ) { // 0.01 is the probability for a mutation to occur
				genes_[i] = Math.random();
			}
			chance = Math.random();
		}
		return genes_; // returns child's final gene array
	}
}
