package ca.eyqs.kanon;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class NoteValue {
    private static final Map<Character, Integer> PITCH_MAP = makePitchMap();
    private static Map<Character, Integer> makePitchMap() {
        Map<Character, Integer> res = new HashMap<Character, Integer>();
		res.put('C', 0);
		res.put('D', 2);
		res.put('E', 4);
		res.put('F', 5);
		res.put('G', 7);
		res.put('A', 9);
		res.put('B', 11);
        return Collections.unmodifiableMap(res);
    }
	private static final Map<String, Integer> ACCIDENTAL_MAP = makeAcciMap();
    private static Map<String, Integer> makeAcciMap() {
        Map<String, Integer> res = new HashMap<String, Integer>();
		res.put("bb", -2);
		res.put("b", -1);
		res.put("", 0);
		res.put("#", 1);
		res.put("x", 2);
        return Collections.unmodifiableMap(res);
    }
    public int midi;
    public char pitch;
    public int octave;
    public int accidental;
    public NoteValue(String name) {
		pitch = name.charAt(0);
        octave = 1 + Integer.parseInt(
            name.substring(name.length() - 1, name.length()));
        accidental = ACCIDENTAL_MAP.get(name.substring(1, name.length() - 1));
		midi = octave * 12 + PITCH_MAP.get(pitch) + accidental;
    }
    public int getHeight() {
        return 3;
    }
}
