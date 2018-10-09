package ie.dit;

// new class for storing the editDistance along with the word
public class Words implements Comparable<Words> {
  String word;
  int dist;

  // compareTo method for sorting Object ArrayLists
  public int compareTo(Words w) {

    // sorting using ed
    //System.out.println("current word: " + this + " comparing with: " + w);

    return this.getEd() - w.getEd();


    // sorting alphabetically

    // String str1 = this.word.toUpperCase();
    // String str2 = w.word.toUpperCase();
    // System.out.println("current word: " + str1 + " comparing with: " + str2);
    // return str1.compareTo(str2);
  }

  // Constructor
  public Words(String word, int dist) {
    this.word = word;
    this.dist = dist;
  }

  // Accessors
  public String getWord() {
    return word;
  }

  public int getEd() {
    return dist;
  }

  public String toString() {
    return word + ", " + dist;
  }
}
