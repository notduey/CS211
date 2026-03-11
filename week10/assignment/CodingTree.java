package week10.assignment;

import java.util.HashMap;
import java.util.Map;

public abstract class CodingTree
{
    // Fields for subclasses
    protected HuffmanNode root;
    protected Map<Character, String> charToCode = new HashMap<>();
    protected Map<String, Character> codeToChar = new HashMap<>();

    // Abstract methods to be implemented by the subclass
    public abstract void encodeFile(String inputFile, String outputFile, String mapFile) throws Exception;
    public abstract void decodeFile(String inputFile, String outputFile, String mapFile) throws Exception;
}