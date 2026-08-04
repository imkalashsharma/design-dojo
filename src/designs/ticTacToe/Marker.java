package designs.ticTacToe;

public enum Marker {
    O("O"),
    X("X");

    private final String value;

    Marker(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
