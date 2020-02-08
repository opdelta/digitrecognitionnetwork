package TP1;

public class LettresInvalides extends Exception {
    public LettresInvalides() {}

    public LettresInvalides(String messageErreur) {
        super(messageErreur);
    }
}
