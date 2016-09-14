package ca.eyqs.kanon;

public class NotePosition {
    public final int position;
    public final int height;
    public final int accidental;
    public final int acciXOff;
    public NotePosition(int x, int y, int a, int o) {
        position = x;
        height = y;
        accidental = a;
        acciXOff = o;
    }
}
