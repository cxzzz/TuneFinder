package ie.dit;

public class PitchSpeller 
{
	private float[] frequencies = {293.66f, 329.63f, 369.99f, 392.00f, 440.00f, 493.88f, 554.37f, 587.33f
			, 659.25f, 739.99f, 783.99f, 880.00f, 987.77f, 1108.73f, 1174.66f, 1318.51f, 1479.98f, 1567.98f, 1760.00f, 1975.53f, 2217.46f, 2349.32f};
	//String[] spellings = {"D,", "E,", "F,", "G,", "A,", "B,", "C", "D", "E", "F", "G", "A", "B","c", "d", "e", "f", "g", "a", "b", "c'", "d'", "e'", "f'", "g'", "a'", "b'", "c''", "d''"}; 	
	private String[] spellings = {"D", "E", "F", "G", "A", "B", "C", "D", "E", "F", "G", "A", "B","C", "D", "E", "F", "G", "A", "B", "C", "D", "E", "F", "G", "A", "B", "C", "D", "E", "F", "G", "A", "B", "C", "D"};
	
	public String spell(float frequency)
	{
		int minIndex = -1;
		float minDiff = Float.MAX_VALUE;
		
		for(int i = 0 ; i < frequencies.length ; i ++)
		{
			float diff = Math.abs(frequency - frequencies[i]);
			if (diff < minDiff)
			{
				minDiff = diff;
				minIndex = i;
			}
		}
		return spellings[minIndex];
	}
	
}

/*
	my version of pitchspeller
	package ie.dit;


public class PitchSpeller {

float[] frequencies;
String[] spellings;

// FFT, Auto Correlation other algorithms than zero crossing
public PitchSpeller() {
	frequencies = new float[] {293.66f, 329.63f, 369.99f, 392.00f, 440.00f, 493.88f,
		554.37f, 587.33f, 659.25f, 739.99f, 783.99f, 880.00f, 987.77f, 1108.73f, 1174.66f};
	spellings = new String[] {"D,", "E,", "F,", "G,", "A,", "B,", "C", "D", "E", "F", "G", "A",
	"B","c", "d", "e", "f", "g", "a", "b", "c'", "d'", "e'", "f'", "g'", "a'", "b'", "c''", "d''"};
}

// Method for taking frequency and return closest note to the frequency
public String spell(float frequency) {
	// Variable for tracking index
	int index = 0;
	// Math.abs to get absolute value
	float dist = Math.abs(frequencies[0] - frequency);
	for (int i = 1; i < frequencies.length; i++) {
		float dist2 = Math.abs(frequencies[i] - frequency);
		// If closer frequency is found 
		if (dist2 <= dist) {
			index = i;
			dist = dist2;
		} else {
			// Closest note found
			break;
		}
	}		
	
	// Return note
	return spellings[index];
}

}
*/