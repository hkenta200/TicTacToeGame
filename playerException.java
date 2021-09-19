public class playerException extends Exception{

    public playerException() {
        super("That is not a valid choice. Please choose again");
    }

    public playerException(String message) {
        super(message);
    }
}
