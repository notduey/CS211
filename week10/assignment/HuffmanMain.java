package week10.assignment;

import java.io.IOException;

public class HuffmanMain
{
    public static void main(String[] args) throws IOException
    {
        if (args.length != 4)
        {
            System.out.println("Usage: java HuffmanMain encode/decode input.txt output.txt map.txt");
            return;
        }

        String mode = args[0];
        String inputFile = args[1];
        String outputFile = args[2];
        String mapFile = args[3];

        HuffmanTree tree = new HuffmanTree();

        if (mode.equalsIgnoreCase("encode"))
            tree.encodeFile(inputFile, outputFile, mapFile);
        else if (mode.equalsIgnoreCase("decode"))
            tree.decodeFile(inputFile, outputFile, mapFile);
        else
            System.out.println("Unknown mode: " + mode);
    }
}