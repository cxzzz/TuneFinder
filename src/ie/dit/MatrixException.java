package ie.dit;

public class MatrixException extends Exception {

  // message of the exception
  private String message;

  // MatrixException constructor
  public MatrixException(String message) {
    this.message = message;
  }

  public String toString() {
    return message;
  }

}
