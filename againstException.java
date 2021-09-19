public class againstException extends Exception{

    public againstException() {
        super("You either have to play against another player or the computer. Choose again. ");
    }

    public againstException(String message) {
        super(message);
    }
}
