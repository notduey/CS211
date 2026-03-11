package week10.assignment;

import java.io.*;
import java.nio.file.Files;
import java.util.*;

public class HuffmanTree extends CodingTree
{
    @Override
    public void encodeFile(String inputFile, String outputFile, String mapFile) throws IOException
    {
        // Read the entire input file into a string
        String text = readFile(inputFile);
        
        // Count frequency of each character stored in a map
        Map<Character, Integer> freqMap = builtFrequencyMap(text);

        // Create priority queue of leaf nodes using frequency map
        PriorityQueue<HuffmanNode> pq = buildPriorityQueue(freqMap);

        // Build Huffman tree from priority queue
        root = buildHuffmanTree(pq);

        // Traverse Huffman tree to generate binary codes
        generateCodes(root, "");

        // Encode original text using generated Huffman codes
        String encodedText = encodeText(text);

        // Write the encoded bit string into the output file
        writeFile(outputFile, encodedText);

        // Write the character-code map into the map file
        writeMappingFile(mapFile);

        System.out.println("Encoding complete: " + outputFile);
        System.out.println("Mapping file: " + mapFile);
    }

    @Override
    public void decodeFile(String inputFile, String outputFile, String mapFile) throws IOException
    {
        // Read the encoded bit string from input file
        String bits = readFile(inputFile);

        // Read the mapping file and rebuild code to character map
        readMappingFile(mapFile);

        // Decode the encoded bit string into original text
        String decodedText = decodeText(bits);

        // Write the decoded original text into the output file
        writeFile(outputFile, decodedText);

        System.out.println("Decoding complete: " + outputFile);
    }

    // Read a file and return its contents as a string
    private String readFile(String filename) throws IOException
    {
        // Create file object representing the input file
        File file = new File(filename);

        // Read every byte from the file into a byte array
        byte[] bytes = Files.readAllBytes(file.toPath());

        // Convert the byte array into a string and return
        return new String(bytes);
    }

    // Count frequency of each character from a string and return a (character-frequency) map
    private Map<Character, Integer> builtFrequencyMap(String text)
    {
        // Create map to store character frequencies
        Map<Character, Integer> frequencyMap = new HashMap<>();

        // Loop through each character in the text
        for (char c: text.toCharArray()) // .toCharArray() returns an array of characters
        {
            // If exists, increment frequency by 1
            if (frequencyMap.containsKey(c))
            {
                frequencyMap.put(c, frequencyMap.get(c));
            }
            else
            {
                // Otherwise insert it with frequency 1
                frequencyMap.put(c, 1);
            }
        }

        // Return completed map
        return frequencyMap;
    }

    // Build and return a priority queue of leaf nodes from (character-frequency) map
    private PriorityQueue<HuffmanNode> buildPriorityQueue(Map<Character, Integer> frequencyMap)
    {
        // Priority queue that orders by frequency, since HuffmanNode implements Comparable
        PriorityQueue<HuffmanNode> pqueue = new PriorityQueue<>();

        // Loop through each character-frequency pair in the map
        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet())
        {
            // Get character and frequency from current entry
            char ch = entry.getKey();
            int freq = entry.getValue();

            // Create leaf node using constructor from HuffmanNode
            HuffmanNode node = new HuffmanNode(ch, freq);

            // Add leaf node into the priority queue
            pqueue.add(node);
        }

        // Return completed priority queue
        return pqueue;
    }

    // Build and return a Huffman tree from priority queue
    private HuffmanNode buildHuffmanTree(PriorityQueue<HuffmanNode> pqueue)
    {
        // Loop until the queue contains only one node
        while (pqueue.size() > 1)
        {
            // Remove two nodes with smallest frequencies
            HuffmanNode left = pqueue.poll(); // .poll() returns first element and removes it
            HuffmanNode right = pqueue.poll();

            // Combine frequencies to create parent node's frequency
            int combinedFreq = left.getFreq() + right.getFreq();

            // Create new internal parent node, children are the two smallest nodes removed
            HuffmanNode parent = new HuffmanNode(combinedFreq, left, right);

            // Add parent node into the priority queue
            pqueue.add(parent);
        }

        // Last remining node is root of the Huffman tree
        return pqueue.poll();
    }

    // Traverse Huffman tree using recursion to generate binary codes
    private void generateCodes(HuffmanNode node, String code)
    {
        // If node is null, return
        if (node == null)
        {
            return;
        }

        // if node is leaf, store completed code in both maps
        if (node.isLeaf())
        {
            // Edge case: if tree contains only one unique character
            if (code.equals("")) // if root itself is leaf and no code was made
            {
                code = "0"; // set code to "0"
            }

            // Store character turned into string code for encoding
            charToCode.put(node.getChar(), code);
            
            // Store string code turned into character for decoding
            codeToChar.put(code, node.getChar());

            return;
        }

        // Recursively traverse left subtree, adding "0" to current code
        generateCodes(node.getLeft(), code + "0");

        // Recursively traverse right subtree, adding "1" to current code
        generateCodes(node.getRight(), code + "1");
    }

    // Encode original text using generated Huffman codes
    private String encodeText(String text)
    {
        // Use StringBuilder to build encoded string piece by piece
        StringBuilder encoded = new StringBuilder();

        // Loop through each character in the text
        for (char c: text.toCharArray())
        {
            // Append corresponding code from charToCode map
            encoded.append(charToCode.get(c));
        }

        // Convert StringBuilder into regular string and return
        return encoded.toString();
    }

    // Write the encoded bit string into the output file
    private void writeFile(String filename, String content) throws IOException
    {
        // Create PrintWriter to write to file
        PrintWriter out = new PrintWriter(filename);

        // Write content to file 
        out.print(content);

        // Close file so data is fully saved
        out.close();
    }

    // Write the character-code map into the map file
    private void writeMappingFile(String filename) throws IOException
    {
        // Create PrintWriter to write to file
        PrintWriter out = new PrintWriter(filename);

        // Loop through each character-code pair in the charToCode map
        for (Map.Entry<Character, String> entry : charToCode.entrySet())
        {
            // Get character and its Huffman code from current entry
            char ch = entry.getKey();
            String code = entry.getValue();

            // print formatted character's interger ASCII and its Huffman code into the file
            out.println((int) ch + ":" + code);
        }

        // Close file so data is fully saved
        out.close();
    }

    // Read the character-code map from map file
    private void readMappingFile(String filename) throws IOException
    {
        // Clear any old mappings before loading new ones
        codeToChar.clear();

        // Open the mapping file for reading
        Scanner input = new Scanner(new File(filename));

        // Read each line from the file
        while (input.hasNextLine()) 
        {
            // Read the next full line from the file
            String line = input.nextLine();

            // Skip blank lines
            if (line.equals("")) 
            {
                continue; // Move the continue statement inside the loop
            }

            // Split the line into two parts around the colon
            String[] parts = line.split(":");

            // Left side is integer value of the character
            int asciiValue = Integer.parseInt(parts[0]);

            // Right side is Huffman code
            String code = parts[1];

            // Convert integer value back into character
            char ch = (char) asciiValue;

            // Store code and character into the map
            codeToChar.put(code, ch);
        }

        // Close the file
        input.close();
    }

    // Decode the encoded bit string into original text
    private String decodeText(String bits)
    {
        // Use StringBuilder to build decoded string piece by piece
        StringBuilder decoded = new StringBuilder();

        // Stores current sequence of bits being processed
        StringBuilder currentCode = new StringBuilder();

        // Read the encoded bit string one character at a time
        for (char c: bits.toCharArray())
        {
            // Append current bit to temporary code
            currentCode.append(c);

            // Convert the current code builder into a string
            String code = currentCode.toString();

            // If bit pattern matches valid huffman code
            if (codeToChar.containsKey(code))
            {
                // Append the decoded character to the output text
                decoded.append(codeToChar.get(code));

                // Reset currentCode so it can build the next character's code
                currentCode.setLength(0);
            }
        }

        // Return completed decoded original text
        return decoded.toString();
    }
}