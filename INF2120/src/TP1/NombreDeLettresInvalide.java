package TP1;

public class NombreDeLettresInvalide extends Exception {
    public NombreDeLettresInvalide() {}
    public NombreDeLettresInvalide(String messageErreur) {
        super(messageErreur);
    }
}
